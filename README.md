# Diplom_3
Тестирование UI сервиса https://stellarburgers.nomoreparties.site/


| Документация | https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf |
|--------------|------------------------------------------------------------------------------------------------------------|
|     Примененные технологии         | Java 11, Junit4, Maven, Allure, Selenium                                                                   |
|     Запуск тестов         | `mvn clean test`                                                                                           |
|     Дополнительные настройки         | не требуются                                                                                               |

драйвер для yandexbrowser предоставлен в src/test/resources/yandexdriver  
Для работы chromebrowser необходимо   
- либо добавить драйвер вручную (скачав подходящий, например, отсюда https://chromedriver.storage.googleapis.com/index.html) 
и прописать его в переменные среды как сделано для yandex browser в классе DriverFactory  
- либо добавить зависимость 
```     
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.9.2</version>
            <scope>test</scope>
        </dependency>
```
и в классе DriverFactory в кейсе запуска браузера chrome прописать `WebDriverManager.chromedriver().setup();`