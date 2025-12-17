package com.example.Controllers;


import com.example.Entities.Equipments;
import com.example.Services.EquipmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentsController {
    @Autowired
    private EquipmentsService equipmentsService;

    @PostMapping("/addEquipment")
    public ResponseEntity<Equipments> addEquipment(@RequestBody Equipments equipment){
        return new ResponseEntity<>(equipmentsService.addEquipment(equipment), HttpStatus.CREATED);
    }

    @GetMapping("/getEquipmentById/{eId}")
    public ResponseEntity<Equipments> getEBI(@PathVariable("eId") Long equipmentId){
        return new ResponseEntity<>(equipmentsService.getEquipmentById(equipmentId), HttpStatus.OK);
    }

    @GetMapping("/getAllEquipments")
    public ResponseEntity<List<Equipments>> getAE(){
        return new ResponseEntity<>(equipmentsService.getAllEquipments(), HttpStatus.OK);
    }



}
