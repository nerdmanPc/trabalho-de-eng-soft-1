import java.util.HashMap;
import java.lang.StringBuilder;

public abstract class Usuario
{
    private int codigo;
    private String nome;
    private HashMap<Livro, Reserva> reservas;
    private HashMap<Livro, Emprestimo> emprestimos_correntes;
    private HashMap<Livro, Emprestimo> emprestimos_historico;
    //private EmprestimoBehavior behavior;
    
    public Usuario(int codigo, String nome)
    {
       this.codigo = codigo;
       this.nome = nome;
       this.reservas = new HashMap<Livro, Reserva>();
       this.emprestimos_correntes = new HashMap<Livro, Emprestimo>();
       this.emprestimos_historico = new HashMap<Livro, Emprestimo>();
    }
    
    /** Cria empréstimo e manda o Livro tentar registrar **/
    public abstract void fazerEmprestimo(Livro livro);
    
    public void registrarDevolucao(Livro livro){
        emprestimos_historico.put(livro, emprestimos_correntes.remove(livro));
    }
    
    public void removerReserva(Livro livro){
        Reserva reserva = reservas.remove(livro);
    }
    
    public void registrarReserva(Reserva reserva){
        reservas.put(reserva.getLivro(),reserva);
    }
    
    //override
    public String toString(){
        StringBuilder retorno = new StringBuilder(nome + "\n");
        
        /** Implementar o método de consulta aqui. **/
    }
    
    public void setCodigo(int in){this.codigo=in;}
    
    public void setNome(String str){this.nome=nome;}
    
    public int getCodigo(){return this.codigo;}
    
    public String getNome(){return this.nome;}
}
