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
    //private int numexemplares;
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
        //this.numexemplares=0;
        novoExemplar();
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
    
    public boolean todosExemplaresReservados(){
        return (reservas.size() >= exemplares.size());
    }
    
    public boolean usuarioTemReserva(Usuario usuario) {
    	return reservas.containsKey(usuario);
    }
    
    public void novoExemplar(){
        exemplares.add(new Exemplar(exemplares.size() + 1));        
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    //implementar consulta
    
    /*
    public int getCodigo(){
        return this.codigo;
    }
        
    public int getNumexemplares(){
        return this.exemplares.size();
    }
    
    public int getEdicao(){
       return this.edicao;
    }
    
    public int getAnoDePublicacao(){
        return this.ano_de_publicacao;
    }
    
    
    
    public String getEditora(){
        return this.editora;
    }
    
    public String[] getAutores(){
        return this.autores;
    }
    
    public void RemoveUserDaReserva(){
        this.usuarios_na_reserva.remove(0);
    }
    
    public boolean VerSeTaVazia() {
        return this.usuarios_na_reserva.size() == 0;
    }
  */
    /** Os dois mÃ©todos abaixo sÃ£o sÃ³ pra fazer os Hashmaps que usam esta classe como chave funcionarem bem */
    @Override
    public boolean equals(Object outro){
        if (!(outro instanceof Livro)){
            return false;
        }
        return (this.codigo == ((Livro)outro).codigo);
    }
    
    @Override
    public int hashCode(){
        return this.codigo;
    }
    /*
     public ArrayList<Exemplar> getExemplares(){
        return this.exemplares;
    }*/
    
    /*
    public int getTemUsuarioNaReserva(){
        return this.usuarios_na_reserva.get(0);
    }*/
    
}
