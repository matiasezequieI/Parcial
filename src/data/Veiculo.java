package data;

import java.util.Date;

public abstract class Veiculo {

	protected String placa;
	protected String modelo;
	protected String cpf;
	protected String nome;
	protected String telefone;
	protected Date data = new Date();
//	protected int hora = data.getHours();
	public static final double VALOR_PRIMEIRA_HORA = 2.00;
	
	public Veiculo(String placa, String modelo, String cpf, String nome, String telefone, Date data) {
		this.placa = placa;
		this.modelo = modelo;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.data = data;
	}
	
	public void estacionar() {
	}

	public double calculaValorEstacionamento() {
		return 0;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "\nNome: " + this.nome + " Modelo: " + this.modelo + " Placa: " + this.placa;
	}
}