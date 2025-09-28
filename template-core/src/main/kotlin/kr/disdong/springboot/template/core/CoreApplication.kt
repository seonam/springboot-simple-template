package kr.disdong.springboot.template.core

import kr.disdong.springboot.template.redis.RedisApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(RedisApplication::class)
class CoreApplication
