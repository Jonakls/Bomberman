repositories {
    maven("https://repo.glaremasters.me/repository/concuncan/")
}

dependencies {
    implementation(project(":api"))
    compileOnly(libs.slimeWorld)
}