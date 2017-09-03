
import java.util.List;
import java.util.LinkedList;
public class Exemplar
{
    private int numero;
    private boolean disponivel;
    private Emprestimo emprestimo_corrente;
    private int Usuario_que_pegou_o_exemplar;
    private List<Integer> usuarios_na_reserva = new LinkedList<Integer>();
        
    
    
    public Exemplar(int numero){
        this.numero = numero;
        this.disponivel = true;
        this.emprestimo_corrente = null;
     
    }
    
    public void setDisponibilidade(boolean sn){
    
    this.disponivel = sn;
    
    }
    
    
        public boolean getDisponibilidade(){
    
    return this.disponivel;
    
    }
    
         public int getNumero(){
    
    return this.numero;
    
    }
    
       public void AdicionarUsuarioNaReserva(int user){
    
   this.usuarios_na_reserva.add(user);
    
    }
    
         public int getTemUsuarioNaReserva(){
    
return this.usuarios_na_reserva.get(0);
    
    }
    
    
    public void RemoveUserDaReserva() {
    this.usuarios_na_reserva.remove(0);
  }
    
    
     public boolean VerSeTaVazia() {
    return this.usuarios_na_reserva.size() == 0;
  }
    
    
    
       public void setUsuarioEmp(int user){
    
    this.Usuario_que_pegou_o_exemplar= user;
    
    }
    
    
        public int getUsuarioEmp(){
    
    return this.Usuario_que_pegou_o_exemplar;
    
    }
    
    
    
    
}
