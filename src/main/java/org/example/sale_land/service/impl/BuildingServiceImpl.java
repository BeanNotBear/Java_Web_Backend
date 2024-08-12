package org.example.sale_land.service.impl;

import org.example.sale_land.dto.BuildingDTO;
import org.example.sale_land.exception.NotFoundBuildingException;
import org.example.sale_land.mapper.BuildingMapper;
import org.example.sale_land.model.Building;
import org.example.sale_land.repository.BuildingRepository;
import org.example.sale_land.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    private BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<BuildingDTO> findAll() {
        List<Building> buildings = buildingRepository.findAll();
        List<BuildingDTO> buildingDTOS = buildings.stream().map(b -> BuildingMapper.toBuildingDTO(b))
                .collect(Collectors.toList());
        return buildingDTOS;
    }

    @Override
    public BuildingDTO findById(Integer id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new NotFoundBuildingException("Not found building"));
        BuildingDTO buildingDTO = BuildingMapper.toBuildingDTO(building);
        return buildingDTO;
    }
}
