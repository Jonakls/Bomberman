package top.jonakls.bomberman.script

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

class BombermanPaperPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.configure()

    private fun Project.configure() {
        project.plugins.apply("java")

        project.repositories {
            maven("https://repo.papermc.io/repository/maven-public/")
        }

        project.dependencies.apply {
            add("compileOnly", "io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
        }

    }
}