import java.util.ArrayList;

public class AlunoPos implements Usuario
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int codigo;
    private String nome;
        private ArrayList<String> emprestimos;
    private ArrayList<String> reservas;
 
    public AlunoPos(int codigo, String nome)
    {
     this.codigo=codigo;
       this.nome=nome;
    }

    
     @Override
   
     
    public String getNome(){return this.nome;}
    public int getCodigo(){return this.codigo;}
    
   public int tempodeemprestimo() {
    
    return 2;
    
    
    }
   
   
   public int limitedeemprestimosemaberto(){
    return 4;
    
    
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
