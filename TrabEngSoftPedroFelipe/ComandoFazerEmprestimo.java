public class ComandoFazerEmprestimo implements Comando
{
    public void executar(){
        int usuario = Sistema.get().getEntrada().nextInt();
        int livro = Sistema.get().getEntrada().nextInt();
        
        Biblioteca.get().fazerEmprestimo(usuario, livro);
    }
}
