package kr.disdong.springboot.template.redis.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kr.disdong.springboot.template.redis.domain.user.dto.UserCache
import org.springframework.boot.data.redis.autoconfigure.DataRedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.util.TimeZone

@Configuration
class RedisConfig {
    @Bean
    fun redisConnectionFactory(redisProperties: DataRedisProperties): RedisConnectionFactory =
        LettuceConnectionFactory(
            redisProperties.host,
            redisProperties.port,
        )

    @Bean
    fun userRedisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, UserCache> =
        createObjectRedisTemplate(redisConnectionFactory, UserCache::class.java)

    private fun <T : Any> createObjectRedisTemplate(
        connectionFactory: RedisConnectionFactory,
        classInfo: Class<T>,
    ): RedisTemplate<String, T> =
        RedisTemplate<String, T>().apply {
            setConnectionFactory(connectionFactory)

            val objectMapper = ObjectMapper()
            objectMapper.registerModule(JavaTimeModule())
            objectMapper.registerKotlinModule()
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            objectMapper.enable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
            objectMapper.setTimeZone(TimeZone.getDefault())

            keySerializer = StringRedisSerializer()
            valueSerializer = Jackson2JsonRedisSerializer(objectMapper, classInfo)
        }
}
