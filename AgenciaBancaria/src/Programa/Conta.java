package Programa;

import Utilitarios.utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Usuario usuario;
	private Double saldo = 0.0;
	
	public Conta(Usuario usuario) {
		this.numeroConta = contadorDeContas;
		this.usuario = usuario;
		contadorDeContas += 1;
		
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNumero da conta: " + this.getNumeroConta() +
		       "\nNome: " + this.usuario.getNome() +
		       "\nCPF: " + this.usuario.getCpf() +
		       "\nEmail: " + this.usuario.getEmail() +
		       "\nSaldo: " + utils.doubleToString(this.getSaldo()) +
		       "\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() > valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");		
		}else {
			System.out.println("Não foi possível realizar a transferência");
		}
		
		
	}
	
}
