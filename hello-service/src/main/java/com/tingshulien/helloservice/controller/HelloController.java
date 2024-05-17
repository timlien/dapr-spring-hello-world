package com.tingshulien.helloservice.controller;

import com.tingshulien.helloservice.service.WorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final WorldService worldService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello, " + worldService.getWorld().nation() + "!\n";
  }

}
