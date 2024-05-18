package com.tingshulien.helloservice.controller;

import com.tingshulien.helloservice.service.ExclamationService;
import com.tingshulien.helloservice.service.WorldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

  private final WorldService worldService;

  private final ExclamationService exclamationService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello, " + worldService.getNation() + exclamationService.getExclamation() + "\n";
  }

}
