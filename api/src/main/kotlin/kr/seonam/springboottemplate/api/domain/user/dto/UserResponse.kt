package kr.seonam.springboottemplate.api.domain.user.dto

import kr.seonam.springboottemplate.core.domain.user.model.User

class UserResponse(
    val name: String,
    val phone: String,
) {
    companion object {
        fun from(user: User) =
            UserResponse(
                name = user.name,
                phone = user.phone,
            )
    }
}
