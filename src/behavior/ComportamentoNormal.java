package behavior;

/**Classe responsavel por implementar a estrategia de mensagem normal.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
public class ComportamentoNormal implements StrategyComportamentoPessoa {

	/**Método que recebe mensagem e simula envio
	* @param Recebe uma string
	*/
	@Override
	public void enviarMensagem(String msg) {	
		logger.registrarMensagemDebug("MENSAGEM --->" +msg+" ENVIADA COM SUCESSO");
	}
}
