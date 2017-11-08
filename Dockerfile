# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8
ADD /target/nb-springboot-docker.jar pstassino/nb-springboot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","nb-springboot-docker.jar"]
#CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar