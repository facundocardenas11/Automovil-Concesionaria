package com.sysone.app.SysOne.responses;

public class AppResponse {

	private String status;

	private String codigo;

	public AppResponse(String status, String codigo) {

		this.status = status;
		this.codigo = codigo;
	}

	public AppResponse() {
		this.status = "OK";
		this.codigo = "200";
	}

	public void setOk() {

		this.status = "OK";
		this.codigo = "200";
	}

	public void setError(String status) {
		this.status = status;
		this.codigo = "400";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
