plugins {
    id("java")
}

group = "org.example"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest.attributes["Main-Class"] = "org.example.TermDepositCalculator"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}