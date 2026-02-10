package kr.seonam.springboottemplate.api.domain.user.controller

import kr.seonam.springboottemplate.api.core.ControllerTestConfig
import kr.seonam.springboottemplate.api.domain.user.dto.UserResponse
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
        whenever(userService.getByUserId(any())).thenReturn(UserResponse("hi", "01000000000"))

        // when
        val result = mockMvc.perform(get("/v1/users/1"))

        // then
        result
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.name").value("hi"))
            .andDo(print())
    }
}
