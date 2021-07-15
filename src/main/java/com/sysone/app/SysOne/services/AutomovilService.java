package com.sysone.app.SysOne.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sysone.app.SysOne.model.AutomovilModel;
import com.sysone.app.SysOne.responses.AppResponse;

@Service
public interface AutomovilService {
	
	AppResponse deleteAuto(Long id);
	
	Iterable<AutomovilModel> listarAutos();
	
	void modifyAuto(Integer id);

	public void addNewVehiculo( AutomovilModel model);
	
	List<AutomovilModel> stats();
	
	
}
