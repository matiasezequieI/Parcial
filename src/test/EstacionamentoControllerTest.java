package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.EstacionamentoController;
import data.Carro;
import data.Moto;
import data.Veiculo;

public class EstacionamentoControllerTest {

	public static void main(String[] args) {

		List<Carro> carros = criaCarros();
		List<Moto> motos = criaMotos();

		try {
			//Testa as entradas e se possuem vagas, caso não tenha ocorre uma exceção
			EstacionamentoController estacionamentoController = new EstacionamentoController();
			for (Carro carro : carros) {
				System.out.println(carro.getPlaca() + " " + carro.getNome());
				estacionamentoController.estaciona(carro);
			}
			for (Moto moto : motos) {
				System.out.println(moto.getPlaca() + " " + moto.getNome());
				estacionamentoController.estaciona(moto);
			}
			
			//Verifica vagas disponiveis
			System.out.println("Vagas: " + estacionamentoController.getVagas());
			
			//Testa Saída Carro
			double valorCobrarCarro = estacionamentoController.saida(carros.get(1));
			System.out.println("Valor a cobrar Carro: " + valorCobrarCarro);
			
			//Verifica vagas disponiveis
			System.out.println("Vagas: " + estacionamentoController.getVagas());
			
			//Testa Saída Moto
			double valorCobrarMoto = estacionamentoController.saida(motos.get(1));
			System.out.println("Valor a cobrar Moto: " + valorCobrarMoto);
			
			//Verifica vagas disponiveis
			System.out.println("Vagas: " + estacionamentoController.getVagas());
			
			for (Veiculo veiculo : estacionamentoController.getVeiculos()) {
				System.out.println(veiculo.toString());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Carro> criaCarros() {
		ArrayList<Carro> carros = new ArrayList<>();
		for (int i = 1; i <= 50; i++) {
			Carro carro = new Carro("MMM-000" + i, "Uno" + i, "081.000.000-" + i, "Joao" + i, "47-999-000" + i, new Date());
			carros.add(carro);
		}
		return carros;
	}
	
	public static List<Moto> criaMotos() {
		ArrayList<Moto> motos = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			Moto moto = new Moto("PPP-000" + i, "Hornet" + i, "081.000.000-" + i, "Juca" + i, "47-999-000" + i, new Date());
			motos.add(moto);
		}
		return motos;
	}
}