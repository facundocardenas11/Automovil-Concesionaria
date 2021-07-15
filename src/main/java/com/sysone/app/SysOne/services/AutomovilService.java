package com.sysone.app.SysOne.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sysone.app.SysOne.entities.Automovil;
import com.sysone.app.SysOne.model.AutomovilModel;
import com.sysone.app.SysOne.responses.AppResponse;

@Service
public interface AutomovilService {

	AppResponse deleteAuto(Long id);

	List<AutomovilModel>   listarAutos();

	AppResponse modifyAuto(AutomovilModel model, Long id);

	ResponseEntity<AutomovilModel> addNewVehiculo(AutomovilModel model);

	List<AutomovilModel> stats();

}
