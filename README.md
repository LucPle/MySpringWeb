# MySpringWeb

## 2023 Summer Practical Coding 1 Integrated Project: MySpringWeb
* 프로젝트 개요: 노래 검색, 좋아요 기능을 DB와 연동
* 프로젝트 기간: 2023.07.17 ~ 2023.07.21
* 프로젝트 이름: MySpringWeb
* 프로젝트 목표: 프론트와 백엔드를 연동하고, 이를 docker image로 만들 수 있도록 dockerfile 제작

## MySpringWeb

### Frontend
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=black">

### Backend
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

### Project Management
<img src="https://img.shields.io/badge/Apache Maven-C71A36?style=for-the-badge&logo=Apache Maven&logoColor=white">

### Container-based Deployment
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white">

### 주요 기능
1. Music search: 원하는 음악을 검색하여 itunes로부터 검색 결과를 표시
2. Favorite music: 선호하는 음악에 좋아요를 표시하면, 해당 음악이 database에 저장되고 이후 web page를 재접속해도 상태 유지

### 주요 특징
1. React-MySQL을 연동하여 사용자의 좋아요 음악 리스트를 동기화
2. Lombok을 이용하여 반복적인 코드 작성을 줄여 코드 다이어트 및 가독성 강화
3. Hibernate를 이용하여 데이터베이스 스키마를 자동으로 생성 및 업데이트
4. Docker를 이용하여 프로젝트를 쉽고 빠르게 배포
