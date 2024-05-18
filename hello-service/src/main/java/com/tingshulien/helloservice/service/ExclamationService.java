package com.tingshulien.helloservice.service;

import com.google.protobuf.Empty;
import com.tingshulien.exclamation.ExclamationServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExclamationService {

  @GrpcClient(value = "exclamation-service")
  private ExclamationServiceGrpc.ExclamationServiceBlockingStub exclamationClient;

  public String getExclamation() {
    return exclamationClient.getExclamation(Empty.newBuilder().build()).getExclamation();
  }

}
