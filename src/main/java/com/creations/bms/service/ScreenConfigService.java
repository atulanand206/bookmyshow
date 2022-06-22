package com.creations.bms.service;

import com.creations.bms.models.theatre.*;
import com.creations.bms.repository.ScreenConfigRepository;
import com.creations.bms.repository.ScreenSeatsRepository;
import com.creations.bms.repository.SeatTypeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScreenConfigService {

  @Autowired ScreenConfigRepository screenConfigRepository;

  @Autowired SeatTypeRepository seatTypeRepository;

  @Autowired ScreenSeatsRepository screenSeatsRepository;

  @Transactional
  public ScreenConfigDto create(ScreenConfigDto configDto) {
    ScreenConfig config = screenConfigRepository.save(withRandomId(configDto));
    List<SeatType> result = new ArrayList<>();
    configDto
        .getConfigs()
        .forEach(
            seatTypeDto -> {
              seatTypeDto.setId(UUID.randomUUID());
              SeatType seatType = seatTypeRepository.save(seatTypeDto);
              result.add(seatType);
              ScreenSeats screenSeats =
                  ScreenSeats.builder()
                      .id(UUID.randomUUID())
                      .screenConfigId(config.getId())
                      .seatTypeId(seatTypeDto.getId())
                      .build();
              screenSeatsRepository.save(screenSeats);
            });
    return ScreenConfigDto.builder()
        .id(configDto.getId())
        .tag(config.getTag())
        .configs(result)
        .build();
  }

  private ScreenConfig withRandomId(ScreenConfigDto screenConfig) {
    return ScreenConfig.builder().id(UUID.randomUUID()).tag(screenConfig.getTag()).build();
  }

  public List<ScreenConfig> getAll() {
    List<ScreenConfig> result = new ArrayList<>();
    screenConfigRepository.findAll().iterator().forEachRemaining(result::add);
    return result;
  }

  public ScreenConfigDto get(UUID config_id) {
    ScreenConfig config = screenConfigRepository.findById(config_id).orElseThrow();
    Iterable<ScreenSeats> screenSeats = screenSeatsRepository.findAllByScreenConfigId(config_id);
    List<UUID> seatIds = new ArrayList<>();
    screenSeats.iterator().forEachRemaining(screenSeat -> seatIds.add(screenSeat.getSeatTypeId()));
    Iterable<SeatType> seatTypes = seatTypeRepository.findAllById(seatIds);
    List<SeatType> list = new ArrayList<>();
    seatTypes.forEach(list::add);
    return ScreenConfigDto.builder().id(config.getId()).tag(config.getTag()).configs(list).build();
  }
}
