package controller;

import java.util.Random;

import model.Competidor;

public class JogadaThread extends Thread {

	private Competidor competidor;
	
	public JogadaThread(Competidor competidor) {
		this.competidor = competidor;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		jogar(competidor);
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