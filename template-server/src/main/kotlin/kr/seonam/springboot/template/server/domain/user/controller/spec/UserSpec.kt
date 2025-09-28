package kr.seonam.springboot.template.server.domain.user.controller.spec

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.seonam.springboot.template.common.dto.TemplateResponse
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse

@Tag(name = "유저")
interface UserSpec {

    @Operation
    fun getByUserId(userId: Long): TemplateResponse<kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse>

    @Operation
    fun create(body: kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody): TemplateResponse<kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse>
}
