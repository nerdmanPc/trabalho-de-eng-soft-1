import java.util.HashMap;

public abstract class Usuario
{
    private int codigo;
    private String nome;
    private HashMap<Livro, Reserva> reservas;
    private HashMap<Livro, Emprestimo> emprestimos;
    //private EmprestimoBehavior behavior;
    
    public Usuario(int codigo, String nome)
    {
       this.codigo = codigo;
       this.nome = nome;
       this.reservas = new HashMap<Livro, Reserva>();
       this.emprestimos = new HashMap<Livro, Emprestimo>();
    }
    
    /**  
    public abstract void fazerEmprestimo(Livro livro);
    
    public void registrarDevolucao(Livro livro){
        emprestimos.remove(livro);
    }
    
    public void registrarReserva(Reserva reserva){
        reservas.put(reserva.getLivro(),reserva);
    }
    **/
    //override
    public String toString(){
        /** Implementar o método de consulta aqui. **/
        return "";
    }
    
    public void setCodigo(int in){this.codigo=in;}
    
    public void setNome(String str){this.nome=nome;}
    
    public int getCodigo(){return this.codigo;}
    
    public String getNome(){return this.nome;}
}
