package com.tingshulien.worldservice.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WorldController {

  private static final List<String> WORLD = List.of("Taiwan", "Unites States", "Japan", "Korea", "China", "India", "Germany", "France", "United Kingdom", "Italy");

  @GetMapping("/world")
  public NationResponse world() {
    var nation = randomNation();
    log.info("nation: {}", nation);
    return new NationResponse(randomNation());
  }

  private String randomNation() {
    return WORLD.get((int) (Math.random() * WORLD.size()));
  }

}
