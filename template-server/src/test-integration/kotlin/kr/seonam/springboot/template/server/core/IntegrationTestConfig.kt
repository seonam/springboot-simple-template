package kr.seonam.springboot.template.server.core

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [RedisTestConfig::class])
@AutoConfigureMockMvc
@ActiveProfiles("test")
abstract class IntegrationTestConfig
