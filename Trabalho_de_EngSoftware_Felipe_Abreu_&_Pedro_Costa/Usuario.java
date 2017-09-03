//import java.util.HashMap;
//import java.lang.StringBuilder;


public interface Usuario
{
  
   
    
    
   int tempodeemprestimo();
    
   int limitedeemprestimosemaberto();
    
    String getNome();
    int getCodigo();
    
    
    
   /** private int codigo;
    private String nome;
    private HashMap<Livro,Reserva> reservas;
    private HashMap<Livro,Emprestimo> emprestimos_correntes;
    private HashMap<Livro,Emprestimo> emprestimos_historico;
    private int tempodeemprestimo;
    private int limitesdeemprestimosemaberto;
    //private EmprestimoBehavior behavior;
    
    public Usuario(int codigo, String nome)
    {
       this.codigo = codigo;
       this.nome = nome;
       this.reservas = new HashMap<Livro, Reserva>();
       this.emprestimos_correntes = new HashMap<Livro, Emprestimo>();
       this.emprestimos_historico = new HashMap<Livro, Emprestimo>();
    }
    
 
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
    
    public String consulta(){
        StringBuilder retorno = new StringBuilder(nome + "\n ");
        
        for (Livro key: emprestimos_correntes.keySet()){
            retorno.append(emprestimos_correntes.get(key).consulta());
        }
        
        for (Livro key: emprestimos_historico.keySet()){
            retorno.append(emprestimos_historico.get(key).consulta());
        }
        
        for (Livro key: reservas.keySet()){
            retorno.append(reservas.get(key).consulta());
        }
      
        return retorno;
    }
    
    public void setCodigo(int in){this.codigo=in;}
    
    public void setNome(String str){this.nome=nome;}
    
    public int getCodigo(){return this.codigo;}
    
    public String getNome(){return this.nome;}
    
    public String getDiasdeemprestimo(){return this.diasdeemprestimo;}
    
    public String getQntsdiastempradevolver(){return this.qntsdiastempradevolver;}
    
    **/
    
    
    
   
    
    
    
}
