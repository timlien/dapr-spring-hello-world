package com.tingshulien.worldservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

  private static final List<String> WORLD = List.of("Taiwan", "Unites States", "Japan", "Korea", "China", "India", "Germany", "France", "United Kingdom", "Italy");

  @GetMapping("/world")
  public WorldResponse world() {
    return randomNation();
  }

  private WorldResponse randomNation() {
    return new WorldResponse(WORLD.get((int) (Math.random() * WORLD.size())));
  }

}
