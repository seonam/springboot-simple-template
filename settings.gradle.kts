rootProject.name = "springboot-simple-template"

include(
    "infrastructure:feign",
    "infrastructure:redis",
    "common",
    "core",
    "api",
)

dependencyResolutionManagement {
    repositories {
        // FIXME. version-catalog 테스트를 위해 필요. 파이프라인에서 넣도록 수정.
        mavenLocal()
        maven { url = uri("https://jitpack.io") }
        maven {
            url = uri("https://maven.pkg.github.com/seonam/version-catalog")
            // jitpack 설정으로 아래 크레덴셜은 필요하지 않음.
            // FIXME. 여기서는 version-catalog 테스트를 위해 필요. 파이프라인에서 넣도록 수정.
            credentials {
                // PAT, github username 을 환경변수 (.zshrc 등)로 저장해야합니다.
                username = System.getenv("SEONAM_USERNAME")
                password = System.getenv("SEONAM_TOKEN")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("kr.seonam:spring-version-catalog:0.1.3")
        }
    }
}
