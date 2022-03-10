package behavior;

/**Classe responsavel por implementar a estrategia de mensagem criptografada.
* @author Iriedson Souto.
* @version 1
* @since 09/03/2022
*/
public class ComportamentoCriptografado implements StrategyComportamentoPessoa {

	/**Método que recebe mensagem, encripta ela e simula envio
	* @param Recebe uma string
	*/
	@Override
	public void enviarMensagem(String msg) {
		String mensagen2 = msg.replaceAll(" ", ""); //Remove espaços em branco da mensagen original
		int raizCaractere = 1 + (int) Math.sqrt(mensagen2.length()); //Contabiliza a raiz da quantidade de caracteres da mensagen
		
		String mensagenEncriptada = "";
		
		for(int i = 0; i < raizCaractere; i++){
			for(int j = i; j < mensagen2.length(); j+=raizCaractere){
				mensagenEncriptada += mensagen2.charAt(j); //Pega caractere a caractere e concatena com a mensagen a ser retornada
			}
			mensagenEncriptada += " ";
		}
		logger.registrarMensagemDebug("MENSAGEM --->" +mensagenEncriptada+" ENVIADA COM SUCESSO");	
	}

}
