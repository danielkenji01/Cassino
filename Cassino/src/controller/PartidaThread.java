package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		System.out.println("Passou aqui");
		jogar(competidores);
	}
	
	public void jogar(List<Competidor> competidores) {
		try {
			while (vencedores.size() < 3) {
				for (Competidor competidor : competidores) {
					
					if (competidor.venceu()) {
						continue;
					}
					
					super.sleep(250);
					jogar(competidor);
					
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

	private void jogar(Competidor competidor) {
		
		System.out.println("Vez do jogador " + competidor.getId());
		
		try {
			super.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean dadoValido = sortearDados();
		
		if (dadoValido) {
			competidor.pontuar();
			System.out.println("Competidor " + competidor.getId() + " pontuou - " + competidor.getPontos());
		}
		
	}
	
	private boolean sortearDados() {
		
		Random random = new Random();
		
		int dado1 = random.nextInt(6) + 1;
		int dado2 = random.nextInt(6) + 1;

		int somaDados = dado1 + dado2;
		
		System.out.println("Dado 1: " + dado1);
		System.out.println("Dado 2: " + dado2);
		
		return somaDados == 7 || somaDados == 11;
	}
	
}