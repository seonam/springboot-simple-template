package kr.seonam.springboottemplate.core

import kr.disdong.springboottemplate.redis.RedisApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(RedisApplication::class)
class CoreApplication
