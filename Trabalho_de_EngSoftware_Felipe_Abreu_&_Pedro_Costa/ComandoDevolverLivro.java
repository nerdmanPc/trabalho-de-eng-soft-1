public class ComandoDevolverLivro  implements Comando
{
    public void executar(int[] argumentos){
        Biblioteca.get().devolverLivro(argumentos[0], argumentos[1]);
    }
}
