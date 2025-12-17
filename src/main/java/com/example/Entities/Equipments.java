package com.example.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Equipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long equipmentId;
    private String equipmentName;
    private String equipmentType;
    private String equipmentBrand;
    private LocalDate equipmentPurchaseDate;
    private double equipmentCost;
    private int equipmentQuantity;
    private String equipmentConditionStatus;
    private LocalDate equipmentLastMaintenanceDate;
    private LocalDate equipmentNextMaintenanceDate;

}
