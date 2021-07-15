package com.sysone.app.SysOne.reopository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sysone.app.SysOne.entities.Automovil;
import com.sysone.app.SysOne.model.AutomovilModel;
import com.sysone.app.SysOne.responses.AppResponse;

@Repository
public interface AutomovilRepository extends CrudRepository<Automovil, Long> {

	Optional<Automovil> findById(Integer id);

	@Modifying
	@Transactional
	void deleteById(Long id);

	AppResponse save(AutomovilModel model);

	@Query(value = "SELECT * FROM AUTOMOVIL", nativeQuery = true)
	public List<AutomovilModel> stats();

}
