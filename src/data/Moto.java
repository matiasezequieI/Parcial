package data;

import java.util.Date;

import controller.EstacionamentoController;

public class Moto extends Veiculo {
	
	public Moto(String placa, String modelo, String cpf, String nome, String telefone, Date data) {
		super(placa, modelo, cpf, nome, telefone, data);
	}

	public static final double VALOR_HORA_ADICIONAL = 1.50;
	
	@Override
	public void estacionar() {
		Vaga vaga = new Vaga();
		vaga.setVeiculo(this);
		EstacionamentoController.vagas.add(vaga);
	}

	@Override
	public double calculaValorEstacionamento() {
		///Data e Hora Atual
		Date dateHoraCorente = new Date();
		
		//Pega a data atual menos a data de entrada do veiculo
		double tempoPermanecia = dateHoraCorente.getHours() - this.data.getHours();
		
		//Horas Adicionais
		double horasAdicionais = tempoPermanecia - 1;
		
		if(tempoPermanecia < 1) {
			//Ele ficou menos que 1 hora
			return Veiculo.VALOR_PRIMEIRA_HORA;
		}else {
			//Calcula o Valor da Hora inicial mais o valor das horas adicionais
			return Veiculo.VALOR_PRIMEIRA_HORA + (horasAdicionais * Moto.VALOR_HORA_ADICIONAL);
		}
	}

}