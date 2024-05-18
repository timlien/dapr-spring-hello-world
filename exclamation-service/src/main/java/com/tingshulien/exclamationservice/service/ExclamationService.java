package com.tingshulien.exclamationservice.service;

import com.google.protobuf.Empty;
import com.tingshulien.exclamation.ExclamationResponse;
import com.tingshulien.exclamation.ExclamationServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.List;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ExclamationService extends ExclamationServiceGrpc.ExclamationServiceImplBase {

    private static final List<String> exclamations = List.of("!", "!!", "!!!", "!!!!");

    @Override
    public void getExclamation(Empty empty, StreamObserver<ExclamationResponse> responseObserver) {
        ExclamationResponse response = ExclamationResponse.newBuilder().setExclamation(randomExclamation()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String randomExclamation() {
        return exclamations.get((int) (Math.random() * exclamations.size()));
    }

}
