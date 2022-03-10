package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import logging.SingletonLogger;

/**Classe responsavel por conter os metodos de manipula��o do objeto pessoa, utilizando da implementa��o do padr�o Facade.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
public class FachadaCadastramentoPessoas {
	
	/**
	 * Instancia do objeto logger singleton
	 */
	private SingletonLogger logger = SingletonLogger.getSingletonLogger();
	
	/**
	 * Atributo array de pessoas cadastradas.
	 */
	private Set<Pessoa> pessoasCadastradas = new HashSet<Pessoa>();

	/**
	 * Metodo que abstrai toda manipula��o de cadastro de pessoas
	 * @param String nome da pessoa, LocalDate data de nascimento da pessoa
	 */
	public void cadastrar(String nome, LocalDate dataNasc) {
		Pessoa pessoa = new Pessoa(nome, dataNasc);
		LocalDate data2 = LocalDate.now();	
		Period period = Period.between(dataNasc, data2);
		logger.registrarMensagemInformativa("PROCESSANDO CADASTRAMENTO DE PESSOA ---> nome: "
		+nome+ " / idade: "+period.getYears());
		

		if(period.getYears() >= 18){
			pessoasCadastradas.add(pessoa);
			logger.registrarMensagemDebug("CADASTRAMENTO DE PESSOA REALIZADO COM SUCESSO ---> nome: " +nome);
		}else{
			logger.registrarMensagemDebug("CADASTRAMENTO DE PESSOA INV�LIDO ---> nome: " 
		+nome+". � menor de 18 anos");
		}
	}
	
	/**
	 * Metodo que abstrai toda manipula��o de pesquisa de pessoas
	 * @param String nome da pessoa
	 * @return Objeto pessoa
	 */
	public Pessoa pesquisar(String nome) {
		for(Pessoa pessoa: pessoasCadastradas){
			if(pessoa.getNome().equals(nome)){
				logger.registrarMensagemDebug("PESQUISA DE PESSOA REALIZADO COM SUCESSO ---> nome: " +nome);
				return pessoa;
			}
		}
		logger.registrarMensagemErro("PESQUISA DE PESSOA INV�LIDO ---> nome: "
				+nome+". Pessoa n�o encontrada");
		return null;
	}
			
	/**
	 * Metodo que abstrai toda manipula��o de remo��o de pessoas
	 * @param String nome da pessoa
	 */
	public void remover(String nome) {
		Pessoa pessoa = pesquisar(nome);
		if(pessoa != null){
			pessoasCadastradas.remove(pessoa);
			logger.registrarMensagemInformativa("DESCADASTRAMENTO DE PESSOA REALIZADO COM SUCESSO "
					+ "---> nome: "+nome);
		}else{
			logger.registrarMensagemErro("DESCADASTRAMENTO DE PESSOA INV�LIDO ---> nome: "
		+nome+". Pessoa n�o encontrada");
		}
	}
}
