plugins {
    idea
}

dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-core"))
    implementation(libs.spring.boot.starter.web)

    testImplementation(project(path = ":template-core", configuration = "testJarConfig"))
    testImplementation(libs.embedded.redis)
    testRuntimeOnly(libs.h2.database)
    testImplementation(libs.spring.boot.starter.web)
    testImplementation(libs.spring.boot.starter.webmvc.test)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

// 통합 테스트 용 소스셋을 별도로 구성합니다.
sourceSets {
    create("integrationTest") {
        kotlin.srcDir(file("src/test-integration/kotlin"))
        resources.srcDir(file("src/test-integration/resources"))
        compileClasspath += sourceSets.main.get().output + sourceSets.test.get().output
        runtimeClasspath += sourceSets.main.get().output + sourceSets.test.get().output
    }
}

val integrationTest =
    task<Test>("integrationTest") {
        description = "Run integration tests"
        group = "verification"

        classpath = sourceSets["integrationTest"].runtimeClasspath
        testClassesDirs = sourceSets["integrationTest"].output.classesDirs

        shouldRunAfter(tasks.test)
    }

val integrationTestImplementation: Configuration by configurations.getting {
    extendsFrom(
        configurations.testCompileOnly.get(),
        configurations.testImplementation.get(),
        configurations.testRuntimeOnly.get(),
        configurations.testApi.get(),
    )
}

tasks.check { dependsOn(integrationTest) }

idea.module {
    testSources.from(
        project.sourceSets
            .getByName("integrationTest")
            .kotlin.srcDirs,
    )
    testResources.from(
        project.sourceSets
            .getByName("integrationTest")
            .resources.srcDirs,
    )
}
