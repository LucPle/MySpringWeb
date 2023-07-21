# Base image: OpenJDK 17
FROM openjdk:17

# 앱을 실행시키기 위한 폴더 생성
WORKDIR /app

# 호스트의 'target' 폴더에 있는 JAR 파일을 컨테이너의 '/app' 폴더로 복사
COPY target/myspringweb-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너의 8098 포트를 호스트의 8098 포트와 연결
EXPOSE 8098

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]