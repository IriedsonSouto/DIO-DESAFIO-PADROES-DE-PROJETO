package model;

import java.time.LocalDate;

import behavior.StrategyComportamentoPessoa;

/**Classe referente ao objeto pessoa.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
public class Pessoa {
 
	/**
	 * Atributos base de pessoa
	 */
	private String nome;
	private LocalDate dataNascimento;
	private StrategyComportamentoPessoa comportamentoMensagem;	
	
	/**
	 * Construtor de pessoa
	 * @param String nome da pessoa, LocalDate data de nascimento
	 */
	public Pessoa(String nome, LocalDate dataNasc){
		setNome(nome);
		setDataNascimento(dataNasc);
	}

	/**
	 * Metodo responsavel por eniar mensagem utilizando do padrão Strategy
	 * @param String mensagem a ser enviada
	 */
	public void enviarMensagem(String msg){
		comportamentoMensagem.enviarMensagem(msg);
	}
	
	/**
	 * Metodos get
	 */
	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	/**
	 * Metodos set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setComportamentoMensagem(StrategyComportamentoPessoa comportamentoMensagem) {
		this.comportamentoMensagem = comportamentoMensagem;
	}
}
