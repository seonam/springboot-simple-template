package kr.seonam.springboot.template.server.domain.user.service

import kr.seonam.springboot.template.core.domain.user.helper.UserCreator
import kr.seonam.springboot.template.core.domain.user.helper.UserReader
import kr.seonam.springboot.template.core.domain.user.model.User
import kr.seonam.springboot.template.server.domain.user.dto.CreateUserBody
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

internal class UserServiceTest {
    private val userReader = mock(UserReader::class.java)
    private val userCreator = mock(UserCreator::class.java)
    private val sut =
        kr.seonam.springboot.template.server.domain.user.service
            .UserService(userReader, userCreator)

    @Test
    fun `샘플 테스트 1`() {
        whenever(userReader.getByUserId(any())).thenReturn(User(1, "name", "010"))

        val response = sut.getByUserId(1)

        assertNotNull(response)
    }

    @Test
    fun `샘플 테스트 2`() {
        Mockito.`when`(userCreator.create(any())).thenReturn(User(1, "name", "010"))

        val response =
            sut.create(
                kr.seonam.springboot.template.server.domain.user.dto
                    .CreateUserBody("name", "010"),
            )

        assertEquals("name", response.name)
        assertEquals("010", response.phone)
    }
}
