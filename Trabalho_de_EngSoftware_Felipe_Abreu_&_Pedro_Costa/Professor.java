import java.util.ArrayList;

public class Professor implements Usuario,Observer
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int codigo;
    private String nome;
    private int numero_de_notificacoes;
    private ArrayList<String> emprestimos;
    private ArrayList<String> reservas;
 
    public Professor(int codigo, String nome)
    {
     this.codigo=codigo;
       this.nome=nome;
       this.numero_de_notificacoes = 0;
    }
    
    public void atualizar(Subject s){
        this.numero_de_notificacoes++;
    }

    
     @Override
   
   
    public String getNome(){return this.nome;}
    public int getCodigo(){return this.codigo;}
    
   public int tempodeemprestimo() {
    
    return 4;
    
    
    }
   
   
   public int limitedeemprestimosemaberto(){
    Integer myInf = Integer.MAX_VALUE;
    return myInf;
    
    
    }
    
   
    
      
    
    
    /**
    
    public void setCodigo(int in){this.codigo=in;}
    public void setNome(String str){this.nome=nome;}
    public void setDiasdeemprestimo(int in){this.diasdeemprestimo=in;}
    public void setMaximodelivros(int in){this.maximodelivros=in;}
    public int getCodigo(int in){return this.codigo;}
    public String getNome(){return this.nome;}
    public int getDiasdeemprestimo(){return this.diasdeemprestimo;}
    public int getMaximodelivros(){return this.maximodelivros;}
    
    
    
    **/
}
