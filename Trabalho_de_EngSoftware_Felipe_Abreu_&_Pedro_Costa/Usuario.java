public class Usuario
{
    private int codigo;
    private String nome;
    private int diasdeemprestimo;
    private int maximodelivros;

    public Usuario(int codigo, String nome,int diasdeemprestimo, int maximodelivros)
    {
       this.codigo=codigo;
       this.nome=nome;
       this.diasdeemprestimo=diasdeemprestimo;
       this.maximodelivros=maximodelivros;
    }

  
    public void setCodigo(int in){this.codigo=in;}
    
    public void setNome(String str){this.nome=nome;}
    
    public void setDiasdeemprestimo(int in){this.diasdeemprestimo=in;}
    
    public void setMaximodelivros(int in){this.maximodelivros=in;}
    
    public int getCodigo(){return this.codigo;}
    
    public String getNome(){return this.nome;}
    
    public int getDiasdeemprestimo(){return this.diasdeemprestimo;}
    
    public int getMaximodelivros(){return this.maximodelivros;}
}
