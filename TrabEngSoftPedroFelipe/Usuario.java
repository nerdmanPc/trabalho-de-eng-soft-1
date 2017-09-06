import java.util.HashMap;
import java.util.Set;
import java.lang.StringBuilder;
import java.util.GregorianCalendar;

public class Usuario
{   
    private int codigo;
    private String nome;
    private EmprestimoBehavior emprestador;
    private HashMap<Livro,Reserva> reservas;
    private HashMap<Livro,Emprestimo> emprestimos_correntes;
    private HashMap<Livro,Emprestimo> emprestimos_historico;
    
    Usuario(int codigo, String nome, EmprestimoBehavior emprestador)
    {
       this.codigo = codigo;
       this.nome = nome;
       this.emprestador = emprestador;
       this.reservas = new HashMap<Livro, Reserva>();
       this.emprestimos_correntes = new HashMap<Livro, Emprestimo>();
       this.emprestimos_historico = new HashMap<Livro, Emprestimo>();
    }
    
    /** Para fazer emprestimo, chamar apenas este método */
    public void fazerEmprestimo(Livro livro) throws UsuarioInadimplenteEx, 
    	UsuarioPegouTodosEmprestimosEx, TodosExemplaresReservadosEx, SemExemplaresDisponiveisEx
    {
    	emprestador.fazerEmprestimo(this, livro);
    }
    
    public void registrarDevolucao(Livro livro) throws UsuarioNaoEstaComLivroEx{
        Emprestimo encerrado = emprestimos_correntes.remove(livro);
        if (encerrado == null){
            throw new UsuarioNaoEstaComLivroEx();
        }
        emprestimos_historico.put(livro, encerrado);
        return; //retorna de boa
    }
    
    public void registrarReserva(Reserva reserva) throws ReservaJaFeitaEx, UsuarioNaoPodeReservarEx{
        if (reservas.containsValue(reserva)){
            throw new ReservaJaFeitaEx();
        }
        if (reservas.size() >= 3){
            throw new UsuarioNaoPodeReservarEx();
        }
        reservas.put(reserva.getLivro(),reserva);
        return; //retorna de boa
    }
    
    public String consulta(){
        StringBuilder retorno = new StringBuilder(nome + "\n ");
        
        retorno.append("Emprestimos correntes:\n");
        
        for (Livro key: emprestimos_correntes.keySet()){
            retorno.append(emprestimos_correntes.get(key).consultaPorUsuario());
        }
        
        retorno.append("Emprestimos passados:\n");
        
        for (Livro key: emprestimos_historico.keySet()){
            retorno.append(emprestimos_historico.get(key).consultaPorUsuario());
        }
        
        retorno.append("Reservas:\n");
        
        for (Livro key: reservas.keySet()){
            retorno.append(reservas.get(key).consultaPorUsuario());
        }
        return retorno.toString();
    }
    
    public void removerReserva(Livro livro){
        Reserva reserva = reservas.remove(livro);
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
    
    public String getNome() {
    	return this.nome;
    }
    
    /** Os dois métodos abaixo são só pra fazer os Hashmaps que usam esta classe como chave funcionarem bem */
    @Override
    public boolean equals(Object outro){
        if (!(outro instanceof Usuario)){
            return false;
        }
        return (this.codigo == ((Usuario)outro).codigo);
    }
    @Override
    public int hashCode(){
        return this.codigo;
    }
}
