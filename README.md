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

The starter will add service to grpc server automatically.

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

## Ref

[gRPC Implementation With Spring Boot](https://medium.com/turkcell/grpc-implementation-with-spring-boot-7d6f98349d27)

[gRPC Error Handling](https://www.vinsguru.com/grpc-error-handling/)

[gRPC-Spring-Boot-Starter Documentation](https://yidongnan.github.io/grpc-spring-boot-starter/en/)

[Status codes and their use in gRPC](https://grpc.github.io/grpc/core/md_doc_statuscodes.html)

[grpc server cpp demo](https://github.com/ppdouble/grpc-cpp-server-sample)

[grpc client cpp demo](https://github.com/ppdouble/grpc-cpp-client-sample)

[grpc client with springboot demo](https://github.com/ppdouble/springboot-grpc-client-sample)

[grpc server with springboot demo](https://github.com/ppdouble/springboot-grpc-server-sample)

[grpc client java demo](https://github.com/ppdouble/grpc-service-sample-client)

[grpc server java demo](https://github.com/ppdouble/grpc-service-pemo)

[sprintboot with grpc server. Fork from nils](https://github.com/ppdouble/city-score)

[gRPC Java Client App Implementation](https://www.youtube.com/watch?v=J0AMX9YpdLk)

[grpc sample on github](https://github.com/techtter/grpc)
