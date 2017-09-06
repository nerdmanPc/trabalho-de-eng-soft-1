import java.util.ArrayList;
import java.util.HashMap;

public class Livro extends Subject
{
    private int codigo;
    private String titulo;
    private String editora;
    private String[] autores;
    private int edicao;
    private int ano_de_publicacao;
    
    private ArrayList <Exemplar> exemplares;
    private HashMap<Usuario, Reserva> reservas;

    public Livro(int codigo,String titulo,String editora,String[] autores,int edicao, int ano_de_publicacao){
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.ano_de_publicacao = ano_de_publicacao;
        this.exemplares = new ArrayList<Exemplar>();
        reservas = new HashMap<Usuario, Reserva>();
    }
    
    public void registrarDevolucao(Usuario usuario) throws UsuarioNaoEstaComLivroEx{
        for (Exemplar exemplar: exemplares){
            if (exemplar.getUsuario() == usuario){
                exemplar.devolver();
                return; // retorna de boa
            }
        }
        throw new UsuarioNaoEstaComLivroEx(); 
    }
    
    public void registrarReserva(Reserva reserva) throws ReservaJaFeitaEx{
        if (this.reservas.containsKey (reserva.getUsuario()) ){
            throw new ReservaJaFeitaEx(); 
        }
        this.reservas.put(reserva.getUsuario(), reserva);
        if (reservas.size() > 2){ 
            super.notificarObservers();
        }
        return; //retorna de boa
    }
    
    public void registrarEmprestimo(Emprestimo emprestimo) throws SemExemplaresDisponiveisEx{
        for(Exemplar exemplar: exemplares){
            if(exemplar.emprestar(emprestimo)){
                removerReserva(emprestimo.getUsuario());
                return; //retorna de boa
            }
        }
        throw new SemExemplaresDisponiveisEx();
    }
    
    public void removerReserva(Usuario usuario){
    	reservas.remove(usuario);
    }
    
    public String consulta() {
    	StringBuilder retorno = new StringBuilder("Título: " + titulo + "\n" + reservas.size() + " reservas:\n");
    	
    	retorno.append(reservas.size() + " reservas:\n");
    	for(Usuario key: reservas.keySet()) {
    		retorno.append(key.getNome() + "\n");
    	}
    	retorno.append("Exemplares:\n");
    	for(Exemplar exemplar: exemplares) {
    		retorno.append(exemplar.consulta());
    	}
    	return retorno.toString();
    }
    
    public boolean todosExemplaresReservados(){
        return (reservas.size() >= exemplares.size());
    }
    
    public boolean usuarioTemReserva(Usuario usuario) {
    	return reservas.containsKey(usuario);
    }
    
    public void novoExemplar(int numero){
        exemplares.add(new Exemplar(numero));        
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public int getCodigo() {
    	return this.codigo;
    }
    
    /** Os dois métodos abaixo são só pra fazer os Hashmaps que usam esta classe como chave funcionarem bem */
    @Override
    public boolean equals(Object outro){
        if ( !(outro instanceof Livro) ){
            return false;
        }
        return (this.codigo == ((Livro)outro).codigo);
    }
    
    @Override
    public int hashCode(){
        return this.codigo;
    }
    
}
