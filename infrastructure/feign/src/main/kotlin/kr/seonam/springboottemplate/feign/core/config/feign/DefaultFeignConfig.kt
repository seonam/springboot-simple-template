package kr.seonam.springboottemplate.feign.core.config.feign

import feign.Logger
import org.springframework.context.annotation.Bean

open class DefaultFeignConfig {
    @Bean
    fun feignLoggerLevel(): Logger.Level = Logger.Level.BASIC
}
