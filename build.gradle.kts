plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }

    maven {
        url = uri("https://repo.unnamed.team/repository/unnamed-public/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("me.fixeddev:commandflow-bukkit:0.4.0")
    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")
}

group = "me.jonakls.bomberman"
version = "1.0-SNAPSHOT"
description = "Bomberman minigame"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks {

    processResources {
        expand(
            "name" to rootProject.name,
            "version" to version
        )
    }

}
