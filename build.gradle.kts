
plugins {
    kotlin("jvm") version "1.8.0"
    application
    jacoco
    java
}

group = "ru.nitology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation ("junit:junit:4.13.2")
}



kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}