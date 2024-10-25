FROM  #{java_11_alpine}#
LABEL version="1.0.0" maintainer="jargaez@bancolombia.com.co" description="Firma Electrónica Leasing"
EXPOSE 8080
COPY --chown=#{java_user}#:#{java_user}# app-service.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom"
USER #{corretto_user}#
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]