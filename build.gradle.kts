import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.sodafit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
    mainClassName = "me.sodafit.nicerabbit.Main"
}

dependencies {
    implementation("com.sparkjava:spark-core:2.9.3")
    implementation("org.slf4j:slf4j-api:1.7.25")
    implementation("org.slf4j:slf4j-simple:1.7.25")
    implementation("com.j256.ormlite:ormlite-core:5.2")
    implementation("com.j256.ormlite:ormlite-jdbc:5.2")
    implementation("org.xerial:sqlite-jdbc:3.32.3.2")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("joda-time:joda-time:2.10.8")
    implementation("com.github.kevinsawicki:http-request:6.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.13")
    implementation("com.github.TeamNewPipe:nanojson:1d9e1aea9049fc9f85e68b43ba39fe7be1c1f751")
    implementation("com.github.TeamNewPipe:NewPipeExtractor:0.21.12")
}