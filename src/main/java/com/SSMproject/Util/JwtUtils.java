package com.SSMproject.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    // 密钥
    private static final String SECRET = "12345678901234567890123456789012";

    // 生成密钥
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    /**
     * 生成JWT JSON WEB TOKEN
     * 一般包含 header payload signature
     * Header Authorization: Bearer Token
     * payload 存放用户信息
     * signature 签名防止篡改令牌信息
     */
    public static String generateToken(Integer userId) {

        // 链式编程返回JWT令牌
        return Jwts.builder()
                // 存储用户ID
                .claim("id", userId)

                // 创建时间
                .issuedAt(new Date())

                // 过期时间：1小时
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000))

                // 签名
                .signWith(KEY)

                // 生成JWT
                .compact();
    }

    /**
     * 解析JWT
     */
    public static Claims parseToken(String token) {

        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
