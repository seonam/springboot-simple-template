package kr.seonam.springboot.template.server.core

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.boot.test.context.TestConfiguration
import redis.embedded.RedisServer

@TestConfiguration
class RedisTestConfig {
    @Autowired
    private lateinit var redisProperties: RedisProperties

    private lateinit var redisServer: RedisServer

    @PostConstruct
    fun postConstruct() {
        redisServer = RedisServer(redisProperties.port)
        redisServer.start()
    }

    @PreDestroy
    fun preDestroy() {
        redisServer.stop()
    }
}
