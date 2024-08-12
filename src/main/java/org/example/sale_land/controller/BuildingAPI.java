package org.example.sale_land.controller;

import org.example.sale_land.dto.BuildingDTO;
import org.example.sale_land.exception.ErrorObject;
import org.example.sale_land.exception.FieldRequiredException;
import org.example.sale_land.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BuildingAPI {

    private BuildingService buildingService;

    @Autowired
    public BuildingAPI(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping(value = "/buildings")
    public ResponseEntity<List<BuildingDTO>> getAllBuildings() {
        List<BuildingDTO> buildingDTOS = buildingService.findAll();
        return new ResponseEntity<List<BuildingDTO>>(buildingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/buildings/{id}")
    public ResponseEntity<BuildingDTO> getBuildingById(
            @PathVariable Integer id
    ) {
        BuildingDTO buildingDTO = buildingService.findById(id);
        return new ResponseEntity<BuildingDTO>(buildingDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/buildings")
    public ResponseEntity<Object> createBuilding(
            @RequestBody BuildingDTO building
    ) {
        validateBuilding(building);
        return new ResponseEntity<Object>(building, HttpStatus.CREATED);
    }

    private void validateBuilding(BuildingDTO building) {
        if(building != null) {
            if(building.getName() == null || building.getName().trim().isEmpty()) {
                throw new FieldRequiredException("Name is required");
            }
            if(building.getAddress() == null || building.getAddress().trim().isEmpty()) {
                throw new FieldRequiredException("Address is required");
            }
        } else {
            throw new FieldRequiredException("Building is null");
        }
    }

    @DeleteMapping(value = "/buildings/{id}")
    public ResponseEntity<Integer> deleteBuilding(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(id);
    }
}
