package kr.seonam.springboottemplate.api.domain.user.controller

import kr.seonam.springboottemplate.api.domain.user.controller.spec.UserSpec
import kr.seonam.springboottemplate.api.domain.user.dto.CreateUserBody
import kr.seonam.springboottemplate.api.domain.user.service.UserService
import kr.seonam.springboottemplate.common.dto.TemplateResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val userService: UserService,
) : UserSpec {
    @GetMapping("/{userId}")
    override fun getByUserId(
        @PathVariable userId: Long,
    ) = TemplateResponse.of(userService.getByUserId(userId))

    @PostMapping("/")
    override fun create(body: CreateUserBody) = TemplateResponse.of(HttpStatus.CREATED, userService.create(body))
}
