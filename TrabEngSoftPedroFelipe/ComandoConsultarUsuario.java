
/**
 * Escreva a descrição da classe consultarUsuario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ComandoConsultarUsuario implements Comando
{
 public void executar(){
        int usuario = Sistema.get().getEntrada().nextInt();
        
        Biblioteca.get().consultarUsuario(usuario);
    }
}
