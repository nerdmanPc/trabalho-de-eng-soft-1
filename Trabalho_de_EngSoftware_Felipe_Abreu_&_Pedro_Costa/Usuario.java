import java.util.HashMap;
import java.util.Set;
import java.lang.StringBuilder;
import java.util.GregorianCalendar;

public abstract class Usuario
{
    private int codigo;
    private String nome;
    private HashMap<Livro,Reserva> reservas;
    private HashMap<Livro,Emprestimo> emprestimos_correntes;
    private HashMap<Livro,Emprestimo> emprestimos_historico;
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
    
    public boolean registrarDevolucao(Livro livro){
        Emprestimo encerrado = emprestimos_correntes.remove(livro);
        if (encerrado == null){
            return false; // ARREMESSA EXCEÇÃO ESSE USUARIO NÃO ESTÁ COM ESSE LIVRO
        }
        emprestimos_historico.put(livro, encerrado);
        return true; //retorna de boa
    }
    
    public void removerReserva(Livro livro){
        Reserva reserva = reservas.remove(livro);
    }
    
    public boolean registrarReserva(Reserva reserva){
        if (reservas.containsValue(reserva)){
            return false; //ARREMESSA EXCEÇÃO RESERVA JÁ FEITA
        }
        if (reservas.size() >= 3){
            return false;  //ARREMESSA EXCEÇÃO USUÁRIO NÃO PODE MAIS RESERVAR
        }
        reservas.put(reserva.getLivro(),reserva);
        return true; //retorna de boa
    }
    
    public int getNumeroEmprestimosCorrentes(){
        return this.emprestimos_correntes.size();
    }
    
    public boolean ehDevedor(){
        Set<Livro> key_set = emprestimos_correntes.keySet(); // Isso é só pra iterar no HashMap, msm
        for (Livro key: key_set){
            if (emprestimos_correntes.get(key).expirou(new GregorianCalendar())){
                return false;
            }
        }
        return true;
    }
    
    public String consulta(){
        StringBuilder retorno = new StringBuilder(nome + "\n ");
        
        retorno.append("Empréstimos correntes:\n");
        
        for (Livro key: emprestimos_correntes.keySet()){
            retorno.append(emprestimos_correntes.get(key).consultaPorUsuario());
        }
        
        retorno.append("Empréstimos passados:\n");
        
        for (Livro key: emprestimos_historico.keySet()){
            retorno.append(emprestimos_historico.get(key).consultaPorUsuario());
        }
        
        retorno.append("Reservas:\n");
        
        for (Livro key: reservas.keySet()){
            retorno.append(reservas.get(key).consultaPorUsuario());
        }
        return retorno.toString();
    }
    
    public void setCodigo(int in){this.codigo=in;}
    
    public void setNome(String str){this.nome=nome;}
    
    public int getCodigo(){return this.codigo;}
    
    public String getNome(){return this.nome;}
    
    /** Os dois métodos abaixo são só pra fazer os Hashmaps que usam esta classe como chave funcionarem bem */
    //override
    public boolean equals(Object outro){
        if (!(outro instanceof Usuario)){
            return false;
        }
        return (this.codigo == ((Usuario)outro).codigo);
    }
    //override
    public int hashCode(){
        return this.codigo;
    }
}
