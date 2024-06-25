package kr.disdong.springboot.simple.template.client.core.config.feign

import feign.Logger
import org.springframework.context.annotation.Bean

open class DefaultFeignConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.BASIC
    }
}
