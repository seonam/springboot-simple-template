rootProject.name = "springboot-simple-template"

include(
    "template-infrastructure:feign",
    "template-infrastructure:redis",
    "template-common",
    "template-core",
    "template-server"
)

dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
        maven {
            url = uri("https://maven.pkg.github.com/seonam/version-catalog")
            // jitpack 설정으로 아래 크레덴셜은 필요하지 않음.
            // credentials {
            //     // PAT, github username 을 환경변수 (.zshrc 등)로 저장해야합니다.
            //     username = System.getenv("DISDONG_USERNAME")
            //     password = System.getenv("DISDONG_TOKEN")
            // }
        }
    }
    versionCatalogs {
        create("libs") {
            from("kr.disdong:spring-version-catalog:0.0.31")
        }
    }
}
