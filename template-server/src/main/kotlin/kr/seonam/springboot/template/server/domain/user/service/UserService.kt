package kr.seonam.springboot.template.server.domain.user.service

import kr.seonam.springboot.template.core.domain.user.helper.UserCreator
import kr.seonam.springboot.template.core.domain.user.helper.UserReader
import kr.seonam.springboot.template.core.domain.user.model.UserCreateOption
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userReader: UserReader,
    private val userCreator: UserCreator,
) {
    fun getByUserId(userId: Long) =
        kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse.from(
            userReader.getByUserId(userId),
        )

    fun create(
        request: kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody,
    ): kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse =
        kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse
            .from(userCreator.create(request.toOption()))

    private fun kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody.toOption() =
        UserCreateOption(name = name, phone = phone)
}
