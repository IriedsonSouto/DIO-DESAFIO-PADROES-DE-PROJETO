package main;

import java.time.LocalDate;

import behavior.*;
import logging.SingletonLogger;
import model.*;

/**Classe main responsavel por simular e demonstrar as aplica��es do projeto.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
public class Main {
	
	public static void main(String[] args) {
				
		/**
		 * Aplica��o do padr�o Singleton, onde � recuperado o objeto logger.
		 */
		SingletonLogger logger = SingletonLogger.getSingletonLogger();
		logger.registrarMensagemInformativa("APLICACAO PRINCIPAL INICIADA!!!");			
		
		/**
		 * Aplica��o do padr�o Facade, onde podemos observar que o cliente apenas faz opera��es simples deixando a responsabilidade
		 * de manipula��o dos metodos para a classe FachadaCadastramento.
		 */
		FachadaCadastramentoPessoas pessoaService = new FachadaCadastramentoPessoas();
		pessoaService.cadastrar("Fulano", LocalDate.of(1986, 5, 25));
		pessoaService.remover("Fulano");
		pessoaService.cadastrar("Cicrano", LocalDate.of(2020, 5, 25));
		pessoaService.remover("Cicrano");
		pessoaService.cadastrar("Beltrano", LocalDate.of(1994, 2, 25));

		/**
		 * Aplica��o do padr�o Strategy, onde o objeto pessoa pode adotar estrategias diferentes de envio de mensagem.
		 */
		StrategyComportamentoPessoa criptografada = new ComportamentoCriptografado();
		StrategyComportamentoPessoa normal = new ComportamentoNormal();
		
		Pessoa beltrano = pessoaService.pesquisar("Beltrano");
		
		beltrano.setComportamentoMensagem(criptografada);
		beltrano.enviarMensagem("Ola mundo");
		
		beltrano.setComportamentoMensagem(normal);
		beltrano.enviarMensagem("Ola mundo");
		
		logger.registrarMensagemInformativa("APLICACAO PRINCIPAL ENCERRADA!!!");		
		/**
		 * Aplica��o do padr�o Singleton, onde � mostrado que as mensagens foram salvas num mesmo objeto mesmo que em
		 * classes diferentes.
		 */
		logger.mostrarTodasMensagens();	
	}
}
