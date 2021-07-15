package com.sysone.app.SysOne.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sysone.app.SysOne.entities.Automovil;
import com.sysone.app.SysOne.model.AutomovilModel;
import com.sysone.app.SysOne.reopository.AutomovilRepository;
import com.sysone.app.SysOne.responses.AppResponse;
import com.sysone.app.SysOne.services.AutomovilService;

@RestController
@RequestMapping(path = "/costos")
public class AutomovilController {

	@Autowired
	AutomovilRepository repo;

	@Autowired
	AutomovilService aService;

	
	@PostMapping("/add")
	public ResponseEntity<AutomovilModel> agregarAuto(@RequestBody AutomovilModel model) {

		AutomovilModel newModel = model.crearAutomovilModel();
		Automovil entity = repo.save(newModel.toEntity());
		newModel.setId(entity.getId());
		return new ResponseEntity<AutomovilModel>(newModel, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/listarAutos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<AutomovilModel> listarAutos() {

		return aService.listarAutos();
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteAuto/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse eliminarAuto(@PathVariable Long id) {

		return aService.deleteAuto(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/modificarAuto/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppResponse modificarAuto(@RequestBody AutomovilModel model, @PathVariable Long id) {

		
			model.setModelo(model.getModelo());
			model.setPrecio(model.getPrecio());
			model.setOpcionales(model.getOpcionales());
			model.setId(id);
			return repo.save(model);
		
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AutomovilModel> stats(){
		
		return aService.stats();
	}
	

}
