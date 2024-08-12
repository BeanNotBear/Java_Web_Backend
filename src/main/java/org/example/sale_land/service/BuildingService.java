package org.example.sale_land.service;

import org.example.sale_land.dto.BuildingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll();
    BuildingDTO findById(Integer id);
}
