package com.tingshulien.helloservice.service;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldService {

  private static final String APP_ID = "world-service";

  private static final String METHOD_NAME = "world";

  private final DaprClient daprClient;

  public String getNation() {
    return daprClient.invokeMethod(APP_ID, METHOD_NAME, null, HttpExtension.GET, NationResponse.class).block().name();
  }

}
