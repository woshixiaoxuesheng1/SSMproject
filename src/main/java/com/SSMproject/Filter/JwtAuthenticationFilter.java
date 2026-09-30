package com.SSMproject.Filter;

import com.SSMproject.Util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;



@Slf4j
// 拦截器
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws IOException, ServletException {


        System.out.println("登录接口过滤器模块");

        // 登录接口直接放行
        if (request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 1. 获取请求头中的Token(Bearer jwt令牌)Header 根据对应的键取对应的值         Authorization n授权
        String token = request.getHeader("Authorization");

        // 2. 没有Token
        if (token == null || token.isEmpty()) {

            response.getWriter().write("未登录");

            return;
        }

        // 3. 去掉 Bearer
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        try {

            // 4. 解析JWT Claims存放Jwt中payload信息
            Claims claims = JwtUtils.parseToken(token);

            // 5. 获取用户ID 找到名字叫“id”的数据 并按Integer类型取出来
            Integer userId = claims.get("id", Integer.class);
            log.info("当前登录用户ID：{}", userId);

            // 创建认证并放进SecurityContext中以便controller获取登录用户信息
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            userId,
                            null,
                            List.of(new SimpleGrantedAuthority("admin"))
                    );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);


            // 6. JWT认证处理完成，继续执行后续过滤器
            filterChain.doFilter(request, response);

        } catch (Exception e) {

            // 7. JWT验证失败
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            response.getWriter().write("Token无效或已过期");
        }
    }
}