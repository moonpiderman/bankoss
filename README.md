## πΈ Bankoss κ°κ³λΆ API Server


### Tech Stack
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/></a> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/></a> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white"/></a> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/></a> <img src="https://img.shields.io/badge/JWT-6DB33F?style=flat-square&logo=Json Web Tokens&logoColor=white"/></a>

### π κ΅¬ν μμΈ
1. κ³ κ°μ μ΄λ©μΌκ³Ό λΉλ°λ²νΈ μλ ₯μ ν΅ν΄μ νμ κ°μμ ν  μ μμ΅λλ€.
2. κ³ κ°μ νμ κ°μμ΄ν, λ‘κ·ΈμΈκ³Ό λ‘κ·Έμμμ ν  μ μμ΅λλ€.
3. κ³ κ°μ λ‘κ·ΈμΈ μ΄ν κ°κ³λΆ κ΄λ ¨ μλμ νλμ ν  μ μμ΅λλ€.
    1. κ°κ³λΆμ μ€λ μ¬μ©ν λμ κΈμ‘κ³Ό κ΄λ ¨λ λ©λͺ¨λ₯Ό λ¨κΈΈ μ μμ΅λλ€.
    2. κ°κ³λΆμμ μμ μ μνλ λ΄μ­μ κΈμ‘κ³Ό λ©λͺ¨λ₯Ό μμ  ν  μ μμ΅λλ€.
    3. κ°κ³λΆμμ μ­μ λ₯Ό μνλ λ΄μ­μ μ­μ  ν  μ μμ΅λλ€.
    4. μ­μ ν λ΄μ­μ μΈμ λ μ§ λ€μ λ³΅κ΅¬ ν  μ μμ΄μΌ νλ€.
    5. κ°κ³λΆμμ μ΄μ κΉμ§ κΈ°λ‘ν κ°κ³λΆ λ¦¬μ€νΈλ₯Ό λ³Ό μ μμ΅λλ€.
    6. κ°κ³λΆμμ μμΈν μΈλΆ λ΄μ­μ λ³Ό μ μμ΅λλ€.
4. λ‘κ·ΈμΈνμ§ μμ κ³ κ°μ κ°κ³λΆ λ΄μ­μ λν μ κ·Ό μ ν μ²λ¦¬κ° λμ΄μΌ ν©λλ€.

### CreatedBy [moonpiderman](https://github.com/moonpiderman)

### Create Database
- `mysql 8`
```shell
$ bash /scripts/bash/init-db.sh
```

### Run Application
```shell
$ ./gradlew bootJar
$ java -jar -Dspring.profiles.active=local build/libs/housekeepingbook-0.0.1-SNAPSHOT.jar
```

### π API Docs
π [Notion](https://eggplant-sumac-51e.notion.site/API-Docs-ba5d4e938788475ea0936d8ba605ea4a)


### π Project Structure
```
βββ build.gradle.kts
βββ gradlew
βββ .editorconfig
βββ Dockerfile
βββ docker-compose.yml
βββ scripts
β   βββ bash/init-db.sh
β   βββ sql/init-db.sql
βββ src
    βββ main
        βββ kotlin
        β    βββ com.wafflestudio.waffleoverflow
        β        βββ domain
        β        β   βββ USER - controller, repository, service, model
        β        β   βββ BOOK - controller, repository, service, model
        β        β   βββ BOOKLOG - controller, repository, service, model
        β        βββ global
        β            βββ auth - JWT, SigninAuthenticationFilter
        β            βββ common.exception - ErrorType(ENUM), ErrorResponse
        β            βββ config
        β                βββ SecurityConfig
        β
        βββ resources
            βββ application.yml
            βββ sql.sql
```

### π Database Scheme
![image](https://user-images.githubusercontent.com/70942197/147306280-9ccd8465-4d50-42c3-829b-1b990ddd20eb.png)

### π³ Docker composeλ₯Ό ν΅ν λ°°ν¬ μΆκ° μμ 
