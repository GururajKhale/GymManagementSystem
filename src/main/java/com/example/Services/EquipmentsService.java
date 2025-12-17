package com.example.Services;

import com.example.Entities.Equipments;

import java.util.List;

public interface EquipmentsService {
    // CREATE
    Equipments addEquipment(Equipments equipment);

    // READ
    Equipments getEquipmentById(long equipmentId);
    List<Equipments> getAllEquipments();

    // UPDATE
    Equipments updateEquipment(long equipmentId, Equipments equipment);

    // DELETE
    void deleteEquipment(long equipmentId);

    // EXTRA BUSINESS METHODS
    List<Equipments> getEquipmentsByType(String equipmentType);
    List<Equipments> getEquipmentsNeedingMaintenance();

}
