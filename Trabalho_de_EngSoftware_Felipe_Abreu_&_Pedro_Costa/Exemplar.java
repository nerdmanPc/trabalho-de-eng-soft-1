public class Exemplar
{
    private int codigo;
    private boolean disponivel;
    private Emprestimo emprestimo_corrente;
    
    public Exemplar(int codigo){
        this.codigo = codigo;
        this.disponivel = true;
        this.emprestimo_corrente = null;
    }
}
