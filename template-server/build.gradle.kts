dependencies {
    implementation(project(":template-persistence"))
    implementation(project(":template-common"))
    implementation(libs.spring.boot.starter.web)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
