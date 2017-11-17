# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

FROM openjdk:8
ADD /target/springboot-docker.jar pstassino/springboot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","springboot-docker.jar"]
#CMD java -Djava.security.egd=file:/dev/./urandom -jar /springboot-docker.jar
