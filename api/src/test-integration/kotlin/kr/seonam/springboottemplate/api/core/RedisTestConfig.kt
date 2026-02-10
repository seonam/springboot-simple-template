package kr.seonam.springboottemplate.api.core

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.TestConfiguration
import redis.embedded.RedisServer

@TestConfiguration
class RedisTestConfig {
    @Value("\${spring.data.redis.port}")
    private var redisPort: Int = 6381

    private lateinit var redisServer: RedisServer

    @PostConstruct
    fun postConstruct() {
        redisServer = RedisServer(redisPort)
        redisServer.start()
    }

    @PreDestroy
    fun preDestroy() {
        redisServer.stop()
    }
}
