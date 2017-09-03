
/**
 * Escreva a descrição da classe consultarAssinatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ComandoConsultarAssinatura  implements Comando
{
 public void executar(){
        int usuario = Sistema.get().getEntrada().nextInt();
        Biblioteca.get().consultarAssinatura(usuario);
    }
}
