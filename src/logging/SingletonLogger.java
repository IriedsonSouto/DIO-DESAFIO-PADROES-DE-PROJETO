package logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

/**Classe responsavel por conter as mensagens de log da aplicação, utilizando da implementação do padrão Singleton.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
public class SingletonLogger {

	/**
	 * Atributo array de mensagens.
	 */
	private Set<String> mensagens = new LinkedHashSet<String>();
	
	/**
	 * Atributo Singleton.
	 */
	private static SingletonLogger logger;
	
	/**
	 * Construtor.
	 */
	private SingletonLogger(){
		
	}
	
	/**
	 * Metodo get do atributo singleton.
	 * @return Objeto logger existente.
	 */
	public static SingletonLogger getSingletonLogger(){
		if(logger == null){
			logger = new SingletonLogger();
			return logger;
		}
		return logger;
	}

	/**
	 * Metodo responsavel por registrar uma mensagem informativa do sistema.
	 * @param Recebe string mensagem.
	 */
	public void registrarMensagemInformativa(String msg) {
		msg = "[INFO] ("+getDataHora()+") "+msg;
		this.mensagens.add(getDataHora()+" "+msg);
	}

	/**
	 * Metodo responsavel por registrar uma mensagem debug do sistema .
	 * @param Recebe string mensagem.
	 */
	public void registrarMensagemDebug(String msg) {
		msg = "[DEBUG] ("+getDataHora()+") "+msg;
		this.mensagens.add(getDataHora()+" "+msg);
	}

	/**
	 * Metodo responsavel por registrar uma mensagem de erro do sistema.
	 * @param Recebe string mensagem.
	 */
	public void registrarMensagemErro(String msg) {
		msg = "[ERRO] ("+getDataHora()+") "+msg;
		this.mensagens.add(getDataHora()+" "+msg);
	}

	/**
	 * Metodo responsavel exibir todas as mensagens informativas.
	 */
	public void mostrarMensagensInformativas() {
		for (String msg : this.mensagens) {
			if (msg.contains("[INFO]"))
				System.out.println(msg);
		}
	}

	/**
	 * Metodo responsavel exibir todas as mensagens debug.
	 */
	public void mostrarMensagensDebug() {
		for (String msg : this.mensagens) {
			if (msg.contains("[DEBUG]"))
				System.out.println(msg);
		}
	}

	/**
	 * Metodo responsavel exibir todas as mensagens de erro.
	 */
	public void mostrarMensagensErro() {
		for (String msg : this.mensagens) {
			if (msg.contains("[ERRO]"))
				System.out.println(msg);
		}
	}

	/**
	 * Metodo responsavel exibir todas as mensagens.
	 */
	public void mostrarTodasMensagens() {
		for (String msg : this.mensagens) {
			System.out.println(msg);
		}
	}


	/**
	 * Metodo interno para capturar data e horario da mensagem registrada.
	 * @return String referente a data e horario
	 */
	private String getDataHora() {
		LocalDateTime timestamp = LocalDateTime.now();
		return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"));
	}
}
