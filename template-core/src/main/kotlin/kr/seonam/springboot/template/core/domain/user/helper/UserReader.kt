package kr.seonam.springboot.template.core.domain.user.helper

import kr.disdong.springboot.template.redis.domain.user.client.UserRedisClient
import kr.disdong.springboot.template.redis.domain.user.dto.UserCache
import kr.seonam.springboot.template.core.domain.user.exception.UserNotFound
import kr.seonam.springboot.template.core.domain.user.model.User
import kr.seonam.springboot.template.core.domain.user.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserReader(
    private val userRepository: UserRepository,
    private val userRedisClient: UserRedisClient,
) {
    @Transactional(readOnly = true)
    fun getByUserId(userId: Long): User {
        val user =
            userRedisClient.get(userId)?.toUser()
                ?: userRepository.findByUserId(userId)?.also {
                    userRedisClient.set(it.toUserCache())
                }
                ?: throw UserNotFound(userId)

        return user
    }

    private fun User.toUserCache() = UserCache(id, name, phone)

    private fun UserCache.toUser(): User = User(id, name, phone)
}
