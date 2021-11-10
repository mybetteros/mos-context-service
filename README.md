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

Configure the certificate information

```
server.ssl.key-store:src/main/resources/certificates/keystorefile.p12
server.ssl.key-store-password:*******
server.ssl.keyStoreType:PKCS12
server.ssl.keyAlias:aliasname

```