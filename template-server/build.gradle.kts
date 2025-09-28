dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-core"))
    implementation(libs.spring.boot.starter.web)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
