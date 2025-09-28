package kr.disdong.springboot.template.server

import kr.disdong.springboot.template.core.CoreApplication
import kr.disdong.springboot.template.core.domain.user.helper.UserCreator
import kr.disdong.springboot.template.core.domain.user.model.UserCreateOption
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(CoreApplication::class)
class ServerApplication(
    private val userCreator: UserCreator,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        userCreator.create(UserCreateOption("seonam", "01000000000"))
    }
}

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
