
public class ComandoAssinarLivro  implements Comando
{
  public void executar(){
        int usuario = Sistema.get().getEntrada().nextInt();
        int livro = Sistema.get().getEntrada().nextInt();
        
        Biblioteca.get().assinarLivro(usuario, livro);
    }
}
