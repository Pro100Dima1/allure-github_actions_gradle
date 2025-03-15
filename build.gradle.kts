plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

allure {  // Allure подключается как плагин
    report {  // Секция репорта
        version.set("2.19.0")
    }
    adapter { // Отвечает за появление папки build/allure-results
        aspectjWeaver.set(true) // Обработка аннотации @Step
        frameworks {
            junit5 {  // Название фреймворка
                adapterVersion.set("2.19.0") // Версия интеграции фреймворка и Allure
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.7.1")
    testImplementation("io.qameta.allure:allure-selenide:2.20.1") // Интеграция Selenide и Allure что б можно было прослушивать события Selenide и логировать их в Allure


}

tasks.test {
    useJUnitPlatform()
    val sysProps = System.getProperties().toMap() as Map<String, Any?>
    systemProperties(sysProps)
}