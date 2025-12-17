package com.example.Daos;

import com.example.Entities.Equipments;
import com.example.Repos.EquipmentsRepo;
import com.example.Services.EquipmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentsDao implements EquipmentsService {
    @Autowired
    private EquipmentsRepo equipmentsRepo;


    @Override
    public Equipments addEquipment(Equipments equipment) {
        return equipmentsRepo.save(equipment);
    }

    @Override
    public Equipments getEquipmentById(long equipmentId) {
        return equipmentsRepo.findById(equipmentId).get();
    }

    @Override
    public List<Equipments> getAllEquipments() {
        return equipmentsRepo.findAll();
    }

    @Override
    public Equipments updateEquipment(long equipmentId, Equipments equipment) {
        Equipments existingEquipment = getEquipmentById(equipmentId);
        existingEquipment.setEquipmentName(equipment.getEquipmentName());
        existingEquipment.setEquipmentType(equipment.getEquipmentType());
        existingEquipment.setEquipmentBrand(equipment.getEquipmentBrand());
        existingEquipment.setEquipmentPurchaseDate(equipment.getEquipmentPurchaseDate());
        existingEquipment.setEquipmentCost(equipment.getEquipmentCost());
        existingEquipment.setEquipmentQuantity(equipment.getEquipmentQuantity());
        existingEquipment.setEquipmentConditionStatus(equipment.getEquipmentConditionStatus());
        existingEquipment.setEquipmentLastMaintenanceDate(equipment.getEquipmentLastMaintenanceDate());
        existingEquipment.setEquipmentNextMaintenanceDate(equipment.getEquipmentNextMaintenanceDate());
        return equipmentsRepo.save(existingEquipment);
    }

    @Override
    public void deleteEquipment(long equipmentId) {
        equipmentsRepo.deleteById(equipmentId);
    }

    @Override
    public List<Equipments> getEquipmentsByType(String equipmentType) {
        return equipmentsRepo.findByEquipmentType(equipmentType);
    }

    @Override
    public List<Equipments> getEquipmentsNeedingMaintenance() {
        return List.of();
    }
}

