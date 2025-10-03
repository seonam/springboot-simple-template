package kr.seonam.springboot.template.server.domain.user.controller

import kr.seonam.springboot.template.server.core.ControllerTestConfig
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserResponse
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserControllerTest : ControllerTestConfig() {
    @Test
    fun `simple test`() {
        whenever(userService.getByUserId(any())).thenReturn(CreateUserResponse("hi", "01000000000"))

        // when
        val result = mockMvc.perform(get("/users/1"))

        // then
        result
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.name").value("hi"))
            .andDo(print())
    }
}
