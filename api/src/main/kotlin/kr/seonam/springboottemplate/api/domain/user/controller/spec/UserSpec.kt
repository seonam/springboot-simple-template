package kr.seonam.springboottemplate.api.domain.user.controller.spec

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.seonam.springboottemplate.api.domain.user.dto.CreateUserBody
import kr.seonam.springboottemplate.api.domain.user.dto.UserResponse
import kr.seonam.springboottemplate.common.dto.TemplateResponse

@Tag(name = "유저")
interface UserSpec {
    @Operation
    fun getByUserId(userId: Long): TemplateResponse<UserResponse>

    @Operation
    fun create(body: CreateUserBody): TemplateResponse<UserResponse>
}
