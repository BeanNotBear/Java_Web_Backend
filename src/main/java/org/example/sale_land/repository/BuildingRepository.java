package org.example.sale_land.repository;

import org.example.sale_land.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findAll();
}
