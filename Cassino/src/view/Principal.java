package view;

import java.util.ArrayList;
import java.util.List;

import controller.PartidaThread;
import model.Competidor;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Competidor> competidores = new ArrayList<Competidor>();
		
		for (int i = 1; i <= 10; i++) {
			competidores.add(new Competidor(i));;
		}
		
		PartidaThread partida = new PartidaThread(competidores);
		partida.run();
		
		System.out.println("Fim");
	}

}
