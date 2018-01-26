package com.stackfing.sso.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午4:27 18-1-26
 */

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
