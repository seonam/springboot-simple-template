package kr.seonam.springboot.template.server.domain.user.controller

import kr.seonam.springboot.template.common.dto.TemplateResponse
import kr.seonam.springboot.template.server.domain.user.controller.spec.UserSpec
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody
import kr.seonam.springboot.template.server.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: kr.seonam.springboot.template.server.domain.user.service.UserService,
) : kr.seonam.springboot.template.server.domain.user.controller.spec.UserSpec {
    @GetMapping("/users/{userId}")
    override fun getByUserId(
        @PathVariable userId: Long,
    ) = TemplateResponse.of(userService.getByUserId(userId))

    @PostMapping("/users")
    override fun create(body: kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody) =
        TemplateResponse.of(HttpStatus.CREATED, userService.create(body))
}
