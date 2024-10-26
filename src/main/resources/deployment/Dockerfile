FROM  #{java_11_alpine}#
LABEL version="1.0.0" maintainer="vanessa.luna.vasquez@gmail.com" description="Prueba"
EXPOSE 8080
COPY --chown=#{java_user}#:#{java_user}# franquicia-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom"
USER #{corretto_user}#
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]