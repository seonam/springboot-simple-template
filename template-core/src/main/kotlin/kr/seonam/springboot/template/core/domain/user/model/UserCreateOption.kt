package kr.seonam.springboot.template.core.domain.user.model

data class UserCreateOption(
    val name: String,
    val phone: String,
) {
    fun toUser(): User =
        User(
            name = name,
            phone = phone,
        )
}
