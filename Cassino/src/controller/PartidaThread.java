package controller;

import java.util.ArrayList;
import java.util.List;

import model.Competidor;

public class PartidaThread extends Thread {

	private int premio = 5000;
	
	private List<Competidor> competidores;
	
	private List<Competidor> vencedores;
	
	public PartidaThread(List<Competidor> competidores) {
		this.competidores = competidores;
		this.vencedores = new ArrayList<Competidor>();
	}
	
	@Override
	public void run() {
		jogar(competidores);
	}
	
	public void jogar(List<Competidor> competidores) {
		try {
			while (vencedores.size() < 3) {
				for (Competidor competidor : competidores) {
					
					if (competidor.venceu()) {
						continue;
					}
					
					JogadaThread thread = new JogadaThread(competidor);
					thread.run();
					
					if (competidor.getPontos() == 5) {
						System.out.println("Venceu " + competidor.getId());
						vencedores.add(competidor);
					}
					
					if (vencedores.size() == 3) {
						break;
					}
				}
			}
			
			for (Competidor vencedor : vencedores) {
				System.out.println("Vencedor " + vencedor.getId() + " - prêmio R$" + premio);
				premio -= 1000;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}