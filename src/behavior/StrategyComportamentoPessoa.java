package behavior;

/**Interface que contem o metodo a ser implementado para possibilitar a implementação do padrão strategy.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
import logging.SingletonLogger;

public interface StrategyComportamentoPessoa {
	/**
	 * Instancia do objeto logger singleton
	 */
	SingletonLogger logger = SingletonLogger.getSingletonLogger();
	
	/**Método abstrato para envio de mensagem
	* @param Recebe uma string
	*/
	public void enviarMensagem(String msg);
}
