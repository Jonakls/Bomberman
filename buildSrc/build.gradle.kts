plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        register("bomberman-paper") {
            id = "bomberman-paper"
            implementationClass = "top.jonakls.bomberman.script.BombermanCompilePlugin"
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}