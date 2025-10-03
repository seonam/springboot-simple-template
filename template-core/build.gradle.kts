plugins {
    alias(libs.plugins.kotlin.plugin.jpa)
}

dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-infrastructure:redis"))
    api(libs.spring.boot.starter.data.jpa)
    implementation(libs.querydsl.jpa) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.querydsl.apt) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.jakarta.persistence.api)
    kapt(libs.jakarta.annotation.api)
    runtimeOnly(libs.mysql.connector.java)
}

// test/** jar 를 다른 모듈에서 활용할 수 있도록 합니다.
val testJar by tasks.registering(Jar::class) {
    archiveBaseName.set("test-${archiveBaseName.get()}")
    from(sourceSets.test.get().output)
    println(sourceSets.test.get().output)
}

configurations {
    create("testJarConfig")
}

testJar.get().dependsOn(tasks.testClasses)

artifacts {
    add("testJarConfig", testJar)
}
