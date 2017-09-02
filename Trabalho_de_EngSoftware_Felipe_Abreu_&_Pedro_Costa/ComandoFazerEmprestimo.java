public class ComandoFazerEmprestimo implements Comando
{
    public void executar(int[] argumentos){
        Biblioteca.get().fazerEmprestimo(argumentos[0], argumentos[1]);
    }
}
