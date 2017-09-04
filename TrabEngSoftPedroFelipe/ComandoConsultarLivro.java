
public class ComandoConsultarLivro  implements Comando
{
 public void executar(){
        int livro = Sistema.get().getEntrada().nextInt();
        
        Biblioteca.get().consultarLivro(livro);
    }
}
