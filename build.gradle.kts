import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
plugins {
    id("idea")
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.bins"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/central")
    }
    maven {
        url = uri("https://repo.dmulloy2.net/repository/public/")
    }
    maven {
        name = "papermc-repo"
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.citizensnpcs.co/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        url = uri("https://repo.codemc.org/repository/maven-public/")
    }
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    implementation ("io.papermc.paper:paper-api:1.17-R0.1-SNAPSHOT")
    implementation("org.bukkit:craftbukkit:1.17-R0.1-SNAPSHOT") {
        exclude("io.papermc.paper:paper-api:1.17-R0.1-SNAPSHOT")
    }
}


fun TaskContainer.createJar(name: String, configuration: ShadowJar.() -> Unit) {
    create<ShadowJar>(name) {
        archiveBaseName.set(project.name)
        archiveVersion.set("") // For bukkit plugin update
        from(sourceSets["main"].output)
        configurations = listOf(project.configurations.shadow.get().apply { isCanBeResolved = true })
        configuration()
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "16"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "16"
    }

    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }
    createJar("outJar") {
        var dest = File("C:/Users/a0103/바탕 화면/모음지이이입/버킷 모음지이입/1.17 Project RUINS 2/plugins")
        val pluginName = archiveFileName.get()
        val pluginFile = File(dest, pluginName)
        if (pluginFile.exists()) dest = File(dest, "update")
        doLast {
            copy {
                from(archiveFile)
                into(dest)
            }
        }
    }


}