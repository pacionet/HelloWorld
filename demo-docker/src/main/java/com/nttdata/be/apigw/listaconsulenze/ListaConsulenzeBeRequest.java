package com.nttdata.be.apigw.listaconsulenze;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaConsulenzeBeRequest {
	
	private String canale;
	private String cf;
	private String ndg;
	private String dataInizio;
	
	public String getCanale() {
		return canale;
	}
	public void setCanale(String canale) {
		this.canale = canale;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getNdg() {
		return ndg;
	}
	public void setNdg(String ndg) {
		this.ndg = ndg;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	
}
