plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    implementation("org.apache.kafka:kafka-clients:3.0.0")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.1")
    testImplementation(kotlin("test"))
}

val packageApp = tasks.register<Zip>("packageApp") {
    from(layout.projectDirectory.file("run.sh"))
    from(tasks.jar) {
        into("libs")
    }
    from(configurations.runtimeClasspath) {
        into("libs")
    }

    destinationDirectory.set(layout.buildDirectory.dir("dist"))
    archiveFileName.set("myApplication.zip")
}

tasks.build {
    dependsOn(packageApp)
}

//task buildZip(type: Zip) {
//    archiveName = "${project.name}.zip"
//    from compileJava
//            from processResources
//            into('lib') {
//                from configurations.runtimeClasspath
//            }
//}
//build.dependsOn buildZip

tasks.test {
    useJUnitPlatform()
}