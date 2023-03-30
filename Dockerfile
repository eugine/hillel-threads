FROM eclipse-temurin:17-jre-alpine

ADD build/libs/hillel*.jar /usr/local/lib/app.jar

CMD java -cp /usr/local/lib/app.jar ua.ithillel.reflection.ReflectionExample