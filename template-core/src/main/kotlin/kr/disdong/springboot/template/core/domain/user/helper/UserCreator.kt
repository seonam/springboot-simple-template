package kr.disdong.springboot.template.core.domain.user.helper

import kr.disdong.springboot.template.core.domain.user.model.User
import kr.disdong.springboot.template.core.domain.user.model.UserCreateOption
import kr.disdong.springboot.template.core.domain.user.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserCreator(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun create(option: UserCreateOption): User {
        return userRepository.save(
            option.toUser()
        )
    }
}
