package kr.seonam.springboot.template.server.domain.user.dto

import kr.seonam.springboot.template.core.domain.user.model.User

class CreateUserBody(
    val name: String,
    val phone: String,
) {

    fun toUserEntity(): User {
        return User(
            name = name,
            phone = phone,
        )
    }
}

class CreateUserResponse(
    val name: String,
    val phone: String,
) {
    companion object {
        fun from(user: User) = kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse(
            name = user.name,
            phone = user.phone,
        )
    }
}
