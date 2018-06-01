package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Carro;
import data.Moto;
import data.Vaga;
import data.Veiculo;
import exception.EstacionamentoCheioException;

public class EstacionamentoController {
	
	
	//Apenas uma lista para armazenar as vagas
	//O calculo de vagas disponiveis é feito pelo método getVagas()
	public static List<Vaga> vagas = new ArrayList<Vaga>();
	
	//Numedo de vagas do estacionamento
	private static final int NUMERO_VAGAS = 60;
	
	public void estaciona(Veiculo v) throws EstacionamentoCheioException {
		//Busca numero de vagas disponiveis, levando em consideração o tipo de veiculo
		double vagasDisponiveis = getVagas();
		if (vagasDisponiveis > 0) {
			if (v instanceof Carro) {
				//Se restar apenas 0.5 vagas não poderá ser estacionado um carro
				if (vagasDisponiveis >= 1) {
					v.estacionar();
				} else {
					throw new EstacionamentoCheioException("Estacionamento Cheio!");
				}
			} else if (v instanceof Moto) {
				//Se for uma moto poderá estacionar mesmo restando apenas 0.5 vagas
				v.estacionar();
			}
		} else {
			throw new EstacionamentoCheioException("Estacionamento Cheio!");
		}
	}
	
	public double saida(Veiculo v) {
		double ret = 0.0;
		// Busca o vaga que o veiculo está
		Vaga vaga = encontraVagaDoVeiculo(v);
		if (v instanceof Carro) {
			// Remove a vaga da lista de vagas
			vagas.remove(vaga);
			ret = v.calculaValorEstacionamento();
		} else if (v instanceof Moto) {
			vagas.remove(vaga);
			ret = v.calculaValorEstacionamento();
		}
		return ret;
	}
	
	//Pega a lista de vagas e monta o retorno com os veiculos de cada vaga
	public List<Veiculo> getVeiculos(){
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		for (Vaga vaga : vagas) {
			veiculos.add(vaga.getVeiculo());
		}
		//Metodo de ordenação do Java 8, sem a necessidade de implementar a classe comparator na classe Veiculo
		Collections.sort(veiculos, (v1, v2) -> v1.getPlaca().compareToIgnoreCase(v2.getPlaca()));
		return veiculos;
	}
	
	public static double getVagas() {
		double ret = NUMERO_VAGAS;
		for (Vaga vaga : vagas) {
			if (vaga.getVeiculo() instanceof Carro) {
				ret = ret - 1;
			} else if (vaga.getVeiculo() instanceof Moto) {
				ret = ret - 0.5;
			}
		}
		return ret;
	}
	
	//Percorre a lista de vagas procurando o veiculo que está saindo pela placa que é o identificador unico do veiculo
	private Vaga encontraVagaDoVeiculo(Veiculo v) {
		Vaga ret = new Vaga();
		for (Vaga vaga : vagas) {
			if (vaga.getVeiculo().getPlaca().equals(v.getPlaca())) {
				ret = vaga;
				break;
			}
		}
		return ret;
	}
	

}