plugins {
    kotlin("jvm") version "1.3.72"
    `maven-publish`
}

group = "org.easythings"
version = "1.0"

repositories {
    mavenCentral()
}

val sendGridVersion: String by project

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // SendGrid - mailer
    implementation("com.sendgrid", "sendgrid-java", sendGridVersion)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

publishing {
    repositories {
        maven {
            name = "EasyMailer"
            url = uri("https://maven.pkg.github.com/lookbad/easy-mailer")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register("gpr") {
            from(components["java"])
        }
    }
}