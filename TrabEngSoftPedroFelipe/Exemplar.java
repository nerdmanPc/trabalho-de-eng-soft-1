import java.util.List;
import java.util.LinkedList;

public class Exemplar
{
    private int numero;
    //private boolean disponivel;
    private Emprestimo emprestimo_corrente;
    //private int Usuario_que_pegou_o_exemplar;

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
        emprestimo_corrente = null;
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
    
    /*
    public boolean getDisponibilidade(){
        return this.emprestimo_corrente == null;
    }*/
    
    /*
    public void setDisponibilidade(boolean sn){
        if (sn) emprestimo_corrente = null;
    }*/
    
    

    //public void setUsuarioEmp(int user){}
    
    
}

    
    
    
/* 
    
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
*/
