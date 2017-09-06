public class Exemplar
{
    private int numero;
    private Emprestimo emprestimo_corrente;

    public Exemplar(int numero){
        this.numero = numero;
        //this.disponivel = true;
        this.emprestimo_corrente = null;
    }
    
    public boolean emprestar(Emprestimo emprestimo){
        if (emprestimo_corrente != null){
            return false;
        }
        this.emprestimo_corrente = emprestimo;
        return true;
    }
    
    public Emprestimo devolver(){
        Emprestimo retorno = emprestimo_corrente;
        this.emprestimo_corrente = null;
        return retorno;
    }
    
    public Usuario getUsuario(){
        if(this.emprestimo_corrente == null){
            return null;
        }
        return this.emprestimo_corrente.getUsuario();
    }
    
    public int getNumero(){
        return this.numero;
    }
}
