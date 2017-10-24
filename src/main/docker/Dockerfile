# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM java:8
ADD springboot-docker.jar /app.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar

