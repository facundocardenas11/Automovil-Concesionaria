package com.sysone.app.SysOne.factory;

import com.sysone.app.SysOne.model.AutomovilModel;
import com.sysone.app.SysOne.model.Coupe;
import com.sysone.app.SysOne.model.Familiar;
import com.sysone.app.SysOne.model.Opcional;
import com.sysone.app.SysOne.model.Sedan;
import com.sysone.app.SysOne.model.opcionales.Airbag;
import com.sysone.app.SysOne.model.opcionales.AireAcondicionado;
import com.sysone.app.SysOne.model.opcionales.LlantasAleacion;
import com.sysone.app.SysOne.model.opcionales.SistemaFrenos;
import com.sysone.app.SysOne.model.opcionales.TechoCorredizo;
import com.sysone.app.SysOne.objsnull.AutomovilNull;
import com.sysone.app.SysOne.objsnull.OpcionalNull;

public class FactoryOperation {
	
	public FactoryOperation() {}

	public static AutomovilModel creoAutomovil(String modelo) {

		if (modelo.equalsIgnoreCase("Familiar"))
			return new Familiar();

		if (modelo.equalsIgnoreCase("Coupe"))
			return new Coupe();

		if (modelo.equalsIgnoreCase("Sedan"))
			return new Sedan();

		return new AutomovilNull();
	}

	public static Opcional creoOpcional(String codigo) {

		if (codigo.equalsIgnoreCase("TC"))
			return new TechoCorredizo();

		if (codigo.equalsIgnoreCase("LL"))
			return new LlantasAleacion();

		if (codigo.equalsIgnoreCase("ABS"))
			return new SistemaFrenos();

		if (codigo.equalsIgnoreCase("AA"))
			return new AireAcondicionado();

		if (codigo.equalsIgnoreCase("AB"))
			return new Airbag();

		return new OpcionalNull();

	}
}
