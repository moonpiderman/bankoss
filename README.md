# 💸 HouseKeeping Book 가계부 API Server

## Tech Stack
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/></a> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/></a> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white"/></a> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/></a> <img src="https://img.shields.io/badge/JWT-6DB33F?style=flat-square&logo=Json Web Tokens&logoColor=white"/></a>

## CreatBy [문보현](https://github.com/moonpiderman)

## Create Database

```shell
bash /scripts/bash/init-db.sh
```

## API Docs
🔗 수정 중..


## Project Structure <수정 필수>
```
├── build.gradle.kts
├── gradlew
├── scripts
│   ├── bash/init-db.sh
│   └── sql/init-db.sql
└── src
    └── main
        ├── kotlin
        │    └── com.wafflestudio.waffleoverflow
        │        ├── domain
        │        │   ├── USER - controller, repository, service, model
        │        │   ├── ANSWER - controller, repository, service, model
        │        │   ├── QUESTION - controller, repository, service, model
        │        │   ├── COMMENT - repository, service, model
        │        │   ├── VOTE - repository, service, model
        │        │   └── TAG - repository, service, model
        │        └── global
        │            ├── auth - JWT, SigninAuthenticationFilter
        │            ├── common.exception - ErrorType(ENUM), ErrorResponse
        │            └── config
        │                └── SecurityConfig
        │
        └── resources
            └── application.yml
```

## Database Scheme <수정 필수>
![image](https://user-images.githubusercontent.com/70942197/145508752-4f98c975-a627-4840-9ae5-9ea84dba9115.png)
