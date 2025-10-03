package kr.seonam.springboot.template.server

import kr.seonam.springboot.template.core.CoreApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(CoreApplication::class)
class ServerApplication

fun main(args: Array<String>) {
    runApplication<kr.seonam.springboot.template.server.ServerApplication>(*args)
}
