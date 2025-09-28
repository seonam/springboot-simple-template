package kr.disdong.springboot.template.core.domain.user.helper

import kr.disdong.springboot.template.core.domain.user.exception.UserNotFound
import kr.disdong.springboot.template.core.domain.user.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserReader(
    private val userRepository: UserRepository,
) {

    @Transactional(readOnly = true)
    fun getByUserId(userId: Long) =
        userRepository.findByUserId(userId)
            ?: throw UserNotFound(userId)
}
