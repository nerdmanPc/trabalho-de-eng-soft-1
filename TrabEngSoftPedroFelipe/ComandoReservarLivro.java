
/**
 * Escreva a descrição da classe reservarLivro aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ComandoReservarLivro implements Comando
{
 public void executar(){
        int usuario = Sistema.get().getEntrada().nextInt();
        int livro = Sistema.get().getEntrada().nextInt();
        
        Biblioteca.get().reservarLivro(usuario, livro);
    }
}
