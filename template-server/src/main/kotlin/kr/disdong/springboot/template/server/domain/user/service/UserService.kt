package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.core.domain.user.helper.UserCreator
import kr.disdong.springboot.template.core.domain.user.helper.UserReader
import kr.disdong.springboot.template.core.domain.user.model.UserCreateOption
import kr.disdong.springboot.template.server.domain.user.dto.CreateUserBody
import kr.disdong.springboot.template.server.domain.user.dto.CreateUserResponse
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userReader: UserReader,
    private val userCreator: UserCreator,
) {

    fun getByUserId(userId: Long) =
        CreateUserResponse.from(
            userReader.getByUserId(userId)
        )

    fun create(request: CreateUserBody): CreateUserResponse {
        return CreateUserResponse.from(userCreator.create(request.toOption()))
    }

    private fun CreateUserBody.toOption() = UserCreateOption(name = name, phone = phone)
}
