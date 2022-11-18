----
grpc server with springboot
----

## generated single file from proto file

I put generated file in api folder, 
since proto fils and generated files should be apis between client
and server

```yaml
option java_package="com.pxample.api";
//option java_multiple_files = true;
option java_outer_classname = "CityScore";
```
## the starter with grpc server

```xml
		<dependency>
			<groupId>net.devh</groupId>
			<artifactId>grpc-server-spring-boot-starter</artifactId>
			<version>2.12.0.RELEASE</version>
		</dependency>
```

**@GrpcService**

>Annotation that marks gRPC services that should be registered with a gRPC server. 
> If spring-boot's auto configuration is used, then the server will be created 
> automatically. This annotation should only be added to implementations of 
> BindableService (GrpcService-ImplBase).

## source folder and target folder

```xml
					<protoSourceRoot>
						${basedir}/src/main/resources/proto/
					</protoSourceRoot>
					<outputDirectory>${basedir}/src/main/java/</outputDirectory>
```
```xml
					<clearOutputDirectory>false</clearOutputDirectory>
```
The false value will not clean the generated folder when compiling the proto files.

## Customized grpc exception

```java
@GrpcAdvice
public class CityScoreExceptionHandler {

    @GrpcExceptionHandler(CityScoreException.class)
    public StatusRuntimeException handleValidationError(CityScoreException cause) {
        ...

```