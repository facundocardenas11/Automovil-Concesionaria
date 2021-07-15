package com.sysone.app.SysOne.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sysone.app.SysOne.entities.Automovil;
import com.sysone.app.SysOne.model.AutomovilModel;
import com.sysone.app.SysOne.reopository.AutomovilRepository;
import com.sysone.app.SysOne.responses.AppResponse;
import com.sysone.app.SysOne.services.AutomovilService;

@Service
public class AutomovilServiceImpl implements AutomovilService {

	@Autowired
	AutomovilRepository repo;

	public ResponseEntity<AutomovilModel> addNewVehiculo(AutomovilModel model) {

		AutomovilModel newModel = model.crearAutomovilModel();
		Automovil entity = repo.save(newModel.toEntity());
		newModel.setId(entity.getId());
		return new ResponseEntity<AutomovilModel>(newModel, HttpStatus.OK);

	}

	@Override
	public AppResponse deleteAuto(Long id) {
		AppResponse response = new AppResponse();
		Optional<Automovil> a = repo.findById(id);

		if (a.getClass().equals(null)) {

			response.setError("Error 500");
		}

		repo.deleteById(id);
		response.setOk();
		return response;
	}

	@Override
	public List<AutomovilModel> listarAutos() {

		List<Automovil> automoviles = (List<Automovil>) repo.findAll();
		List<AutomovilModel> listRet = new ArrayList<AutomovilModel>();
		for (Automovil automovil : automoviles) {
			listRet.add(new AutomovilModel(automovil));
		}
		
		return listRet;
	}

	@Override
	public AppResponse modifyAuto(AutomovilModel model, Long id) {

		model.setModelo(model.getModelo());
		model.setOpcionales(model.getOpcionales());
		return repo.save(model);
	}

	@Override
	public List<AutomovilModel> stats() {
		return null;
	}
}
