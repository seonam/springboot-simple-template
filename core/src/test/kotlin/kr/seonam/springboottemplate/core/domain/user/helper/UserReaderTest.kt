package kr.seonam.springboottemplate.core.domain.user.helper

import kr.disdong.springboottemplate.redis.domain.user.client.UserRedisClient
import kr.seonam.springboottemplate.core.domain.user.exception.UserNotFound
import kr.seonam.springboottemplate.core.domain.user.fixture.UserCacheFixture
import kr.seonam.springboottemplate.core.domain.user.fixture.UserFixture
import kr.seonam.springboottemplate.core.domain.user.repository.UserRepository
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class UserReaderTest {
    private val userRepository: UserRepository = mock()
    private val userRedisClient: UserRedisClient = mock()
    private val sut = UserReader(userRepository, userRedisClient)

    @Nested
    inner class GetByUserIdTest {
        @Nested
        inner class SuccessCase {
            @Test
            fun `simple test`() {
                // given
                whenever(userRedisClient.get(any())).thenReturn(UserCacheFixture.any())

                // when
                val response = sut.getByUserId(1)

                // then
                assertNotNull(response)
                verify(userRepository, never()).findByUserId(any())
            }

            @Test
            fun `simple test2`() {
                // given
                whenever(userRedisClient.get(any())).thenReturn(null)
                whenever(userRepository.findByUserId(any())).thenReturn(UserFixture.any())

                // when
                val response = sut.getByUserId(1)

                // then
                assertNotNull(response)
            }
        }

        @Nested
        inner class FailureCase {
            @Test
            fun `simple test`() {
                // given
                whenever(userRedisClient.get(any())).thenReturn(null)
                whenever(userRepository.findByUserId(any())).thenReturn(null)

                // when, then
                assertThrows<UserNotFound> {
                    sut.getByUserId(1)
                }
            }
        }
    }
}
