package kr.seonam.springboot.template.server.core

import kr.seonam.springboot.template.server.domain.user.controller.UserController
import kr.seonam.springboot.template.server.domain.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(
    UserController::class,
)
@ActiveProfiles("test")
abstract class ControllerTestConfig {
    @MockitoBean
    protected lateinit var userService: UserService

    @Autowired
    protected lateinit var mockMvc: MockMvc
}
