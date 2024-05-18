package com.tingshulien.helloservice.config;

import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.StubTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class GrpcConfig {

  @Bean
  public StubTransformer transformer() {
    return (name, stub) -> {
      log.info("Attach grpc client '{}' with dapr interceptor", name);
      var headers = new Metadata();
      headers.put(Metadata.Key.of("dapr-app-id", Metadata.ASCII_STRING_MARSHALLER), name);
      return stub.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(headers));
    };
  }

}
