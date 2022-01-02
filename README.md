## 💸 HouseKeeping Book 가계부 API Server


### Tech Stack
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/></a> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/></a> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white"/></a> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/></a> <img src="https://img.shields.io/badge/JWT-6DB33F?style=flat-square&logo=Json Web Tokens&logoColor=white"/></a>

### 📄 구현 상세
1. 고객은 이메일과 비밀번호 입력을 통해서 회원 가입을 할 수 있습니다.
2. 고객은 회원 가입이후, 로그인과 로그아웃을 할 수 있습니다.
3. 고객은 로그인 이후 가계부 관련 아래의 행동을 할 수 있습니다.
    1. 가계부에 오늘 사용한 돈의 금액과 관련된 메모를 남길 수 있습니다.
    2. 가계부에서 수정을 원하는 내역은 금액과 메모를 수정 할 수 있습니다.
    3. 가계부에서 삭제를 원하는 내역은 삭제 할 수 있습니다.
    4. 삭제한 내역은 언제든지 다시 복구 할 수 있어야 한다.
    5. 가계부에서 이제까지 기록한 가계부 리스트를 볼 수 있습니다.
    6. 가계부에서 상세한 세부 내역을 볼 수 있습니다.
4. 로그인하지 않은 고객은 가계부 내역에 대한 접근 제한 처리가 되어야 합니다.

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

### 📄 API Docs
🔗 [Notion](https://eggplant-sumac-51e.notion.site/API-Docs-ba5d4e938788475ea0936d8ba605ea4a)


### 📂 Project Structure
```
├── build.gradle.kts
├── gradlew
├── .editorconfig
├── Dockerfile
├── docker-compose.yml
├── scripts
│   ├── bash/init-db.sh
│   └── sql/init-db.sql
└── src
    └── main
        ├── kotlin
        │    └── com.wafflestudio.waffleoverflow
        │        ├── domain
        │        │   ├── USER - controller, repository, service, model
        │        │   ├── BOOK - controller, repository, service, model
        │        │   └── BOOKLOG - controller, repository, service, model
        │        └── global
        │            ├── auth - JWT, SigninAuthenticationFilter
        │            ├── common.exception - ErrorType(ENUM), ErrorResponse
        │            └── config
        │                └── SecurityConfig
        │
        └── resources
            ├── application.yml
            └── sql.sql
```

### 📚 Database Scheme
![image](https://user-images.githubusercontent.com/70942197/147306280-9ccd8465-4d50-42c3-829b-1b990ddd20eb.png)

### 🐳 Docker compose를 통한 배포 추가 예정
