# mos-context-service
MyBetterOS Context Service


## Get Started

### Generate Self Signed Certificate (Windows)

- Open CMD with "Run As Administrator"
- Navigate to the JDK installation directory and go into the BIN folder.  We will be using the Keytool.exe to generate the self-signed certificate

```
.\keytool -genkey -alias aliasname -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystorefile.p12 -validity 3650
```

Follow the prompt to enter a password and detail.

Once it's done, a certificate file will be generated in the BIN folder.  We will then move the .p12 file to the project src/main/resources/certificates

### Configure the application.properties

Use the SSL port instead of the default 8080, add the following lines into application.properties

```
server.port=8443
```

Enable SSL

```
server.ssl.enabled=true
```

Configure the certificate information.  The path to the .p12 file has the prefix of classpath: as when the jar is built, it's under the classpath.  This will allow it to work both running in jar or local tomcat in STS4.

```
server.ssl.key-store:classpath:certificates/keystorefile.p12
server.ssl.key-store-password:*******
server.ssl.keyStoreType:PKCS12
server.ssl.keyAlias:aliasname

```

### Containerize the project

1. Build the project into a jar.  (Run As > Maven Build; then set goals to "Build Compile Install"
2. Once the project is built, the jar will be in the target folder.
3. You can test it by running the java in CMD 

```
java -jar mos-context-service-0.0.1-SNAPSHOT.jar
```

Next Add the "Dockerfile" to the root of the project.

```
# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13

VOLUME /app
ADD target/mos-context-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

- We are building the base image of openjdk:16-alpine3.13
- Specified the volumne of the image to /app
- copy the jar into the image and rename it to app.jar
- finally, the comman to run the jar when the image is run

### Build the docker image

1. Go to the folder where the Dockerfile is in CMD
2. Execute the docker command

```
docker build -t mos-context-service .
```

Once the docker image is build, you can view it by running 

```
docker image ls
```

### Run the image

Add to the hosts file:
127.0.0.1 local.context-service.mybetteros.com 


```
docker run -p8443:8443 -e VIRTUAL_HOST=local.context-service.mybetteros.com mos-context-service
```

then you you can access the app by hitting the URL https://local.context-service.mybetteros.com:8443/buildinfo on the browser