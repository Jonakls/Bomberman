import top.jonakls.bomberman.script.BombermanJavaCompilePlugin
import top.jonakls.bomberman.script.BombermanPaperPlugin

plugins {
    id("java")
}

version = "${findProperty("version")}"

subprojects {
    apply<BombermanPaperPlugin>()
    apply<BombermanJavaCompilePlugin>()

    version = rootProject.version
}