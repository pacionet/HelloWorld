package com.nttdata.fe.listaconsulenze;

import java.util.List;

public class ListaConsulenzeFeResponse {
	
	private int esito = 0;
	
	private List<FeConsulenza> list;

	public int getEsito() {
		return esito;
	}

	public void setEsito(int esito) {
		this.esito = esito;
	}

	public List<FeConsulenza> getList() {
		return list;
	}

	public void setList(List<FeConsulenza> list) {
		this.list = list;
	}
	
	
	

}
