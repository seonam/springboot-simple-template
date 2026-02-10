package kr.disdong.springboottemplate.redis.domain.user.client

import kr.disdong.springboottemplate.redis.domain.user.dto.UserCache
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class UserRedisClient(
    private val userRedisTemplate: RedisTemplate<String, UserCache>,
) {
    companion object {
        private const val KEY = "user"
    }

    fun get(id: Long) = userRedisTemplate.opsForValue().get(userKey(id))

    fun set(value: UserCache) = userRedisTemplate.opsForValue().set(userKey(value), value)

    private fun userKey(value: UserCache): String = userKey(value.id)

    private fun userKey(id: Long): String = "$KEY-$id"
}
