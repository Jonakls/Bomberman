plugins {
    alias(libs.plugins.shadow)
    alias(libs.plugins.paperPluginYAML)
}

repositories {
    maven("https://repo.triumphteam.dev/snapshots/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
    maven("https://repo.glaremasters.me/repository/concuncan/")
}


dependencies {
    implementation(project(":core"))
    implementation(libs.triumphcmd)
    implementation(libs.inject)
    compileOnly(libs.slimeWorld)
}

paper {
    main = "top.jonakls.bomberman.plugin.BombermanPlugin"
    name = "${findProperty("plugin-name")}"
    version = "${rootProject.version}"
    description = "${findProperty("plugin-description")}"
    authors = listOf("Jonakls")
    apiVersion = "1.20"
}