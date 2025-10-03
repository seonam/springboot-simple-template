package kr.seonam.springboot.template.server.domain.user.service

import kr.seonam.springboot.template.core.domain.user.fixture.UserFixture
import kr.seonam.springboot.template.core.domain.user.repository.UserRepository
import kr.seonam.springboot.template.server.core.IntegrationTestConfig
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.beans.factory.annotation.Autowired

class UserServiceTest : IntegrationTestConfig() {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var sut: UserService

    @BeforeEach
    fun setup() {
        userRepository.deleteAll()
        userRepository.save(UserFixture.any())
    }

    @Test
    fun `simple test`() {
        val response = sut.getByUserId(1L)

        assertNotNull(response)
    }
}
