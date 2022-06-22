package com.creations.bms.controllers;

import com.creations.bms.models.theatre.ScreenConfig;
import com.creations.bms.models.theatre.ScreenConfigDto;
import com.creations.bms.service.ScreenConfigService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/screens/configs")
public class ScreenConfigController {

  @Autowired ScreenConfigService screenConfigService;

  @PostMapping("/")
  private ScreenConfigDto createConfig(@RequestBody ScreenConfigDto screenConfig) {
    return screenConfigService.create(screenConfig);
  }

  @GetMapping("/")
  private List<ScreenConfig> getAll() {
    return screenConfigService.getAll();
  }

  @GetMapping("/{config_id}")
  private ScreenConfigDto get(@RequestParam UUID config_id) {
    return screenConfigService.get(config_id);
  }
}
