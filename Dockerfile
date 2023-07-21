# Base image: OpenJDK 17 with Maven
FROM maven:3.8.4-openjdk-17-slim AS build

# 작업 디렉토리 설정
WORKDIR /app

# 소스 코드 복사
COPY pom.xml .
COPY src ./src

# Maven을 사용하여 프로젝트 빌드
RUN mvn clean package

# 빌드가 완료된 JAR 파일을 target 폴더로 이동
RUN mv target/myspringweb-0.0.1-SNAPSHOT.jar /app/target/app.jar

# 실제 실행할 이미지 생성
FROM openjdk:17

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일을 이미지로 복사
COPY --from=build /app/target/app.jar .

# 컨테이너의 8098 포트를 호스트의 8098 포트와 연결
EXPOSE 8098

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]