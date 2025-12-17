package com.example.Repos;

import com.example.Entities.Equipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentsRepo extends JpaRepository<Equipments, Long> {
    List<Equipments> findByEquipmentType(String equipmentType);


}
