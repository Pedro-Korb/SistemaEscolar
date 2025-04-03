package com.classes.main;


public class Processo {
	
	protected Persistencia persistencia;
	
	public Processo(Persistencia persistencia) {
		this.persistencia = persistencia;
	}
	
	public void persistir() {
		this.persistencia.persistir();
	}

}
