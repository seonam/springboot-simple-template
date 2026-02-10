package kr.seonam.springboottemplate.api.domain.user.service

import kr.seonam.springboottemplate.api.domain.user.dto.CreateUserBody
import kr.seonam.springboottemplate.api.domain.user.dto.UserResponse
import kr.seonam.springboottemplate.core.domain.user.helper.UserCreator
import kr.seonam.springboottemplate.core.domain.user.helper.UserReader
import kr.seonam.springboottemplate.core.domain.user.model.UserCreateOption
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userReader: UserReader,
    private val userCreator: UserCreator,
) {
    fun getByUserId(userId: Long) =
        UserResponse.from(
            userReader.getByUserId(userId),
        )

    fun create(request: CreateUserBody): UserResponse =
        UserResponse
            .from(userCreator.create(request.toOption()))

    private fun CreateUserBody.toOption() = UserCreateOption(name = name, phone = phone)
}
