import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


public class Livro extends Subject
{
    private int codigo;
    private String titulo;
    private String editora;
    private String[] autores;
    private int edicao;
    private int ano_de_publicacao;
    //private int numexemplares;
    private ArrayList<Exemplar> exemplares;
    private List<Usuario> usuarios_na_reserva;
    //private int codigoexemplar;
    //private boolean disponibilidade;
    //private int usuario_que_pegou_o_livro;

    public Livro(int codigo,String titulo,String editora,String[] autores,int edicao, int ano_de_publicacao){
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.ano_de_publicacao = ano_de_publicacao;
        this.exemplares = new ArrayList<Exemplar>();
        usuarios_na_reserva = new LinkedList<Usuario>();
        //this.numexemplares=0;
        novoExemplar();
    }
    
    public boolean registrarDevolução(Usuario usuario){
        for (Exemplar exemplar: exemplares){
            if (exemplar.getUsuario() == usuario){
                exemplar.devolver();
                return true; // retorna de boa
            }
        }
        return false; // ARREMESSA EXCEÇÃO DE USUARIO NAO ESTA COM LIVRO
    }
    
    public boolean registrarReserva(Usuario usuario){
        if (this.usuarios_na_reserva.indexOf(usuario) != -1){
            return false; // ARREMSSA EXCEÇÃO DE RESERVA JÁ FEITA
        }
        this.usuarios_na_reserva.add(usuario);
        if (usuarios_na_reserva.size() == 3){ //notifica apenas quando é feita e terceira reserva
            super.notificarObservers();
        }
        return true; //retorna de boa
    }
    
    public boolean registrarEmprestimo(Emprestimo emprestimo){
        for(Exemplar exemplar: exemplares){
            if(exemplar.emprestar(emprestimo)){
                removerReserva(emprestimo.getUsuario());
                return true; //retorna de boa
            }
        }
        return false; //ARREMESSA EXCEÇÃO DE SEM EXEMPLARES
    }
    
    public void removerReserva(Usuario usuario){
        for(Usuario reserva: usuarios_na_reserva){
            if (usuario == reserva){
                usuarios_na_reserva.remove(reserva);
                return; // retorna de boa
            }
        }
    }
    
    public boolean todosExemplaresReservados(){
        return (usuarios_na_reserva.size() >= exemplares.size());
    }
    
    public void novoExemplar(){
        exemplares.add(new Exemplar(exemplares.size() + 1));        
    }
    
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
    
    public String getTitulo(){
        return this.titulo;
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
  
    /* Os dois métodos abaixo são só pra fazer os Hashmaps que usam esta classe como chave funcionarem bem */
    //override
    public boolean equals(Object outro){
        if (!(outro instanceof Livro)){
            return false;
        }
        return (this.codigo == ((Livro)outro).codigo);
    }
    //override
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
