package org.example.sale_land.mapper;

import org.example.sale_land.dto.BuildingDTO;
import org.example.sale_land.model.Building;

public class BuildingMapper {
    public static BuildingDTO toBuildingDTO(Building building) {
        return new BuildingDTO(building.getName(), building.getAddress());
    }
}
