package com.classes.main;

import java.util.Scanner;

public class MainInjecaoDependencia {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Qual forma de persistência dos dados? \n 1 - SQL \n 2 - XML \n 3 - Json\n");
		int resposta = leitor.nextInt();
		
		switch (resposta) {
		case 1:
			PersistenciaSql sql = new PersistenciaSql();
			Processo processoSql = new Processo(sql);
			processoSql.persistir();
		break;
		
		case 2:
			PersistenciaXml xml = new PersistenciaXml();
			Processo processoXml = new Processo(xml);
			processoXml.persistir();
		break;
		
		case 3:
			PersistenciaJson json = new PersistenciaJson();
			Processo processoJson = new Processo(json);
			processoJson.persistir();
		break;
		
		}
		
		leitor.close();
		
	}

}
