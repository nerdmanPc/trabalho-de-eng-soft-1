
/**
 * Escreva a descrição da classe AlunoGrad aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class AlunoPos
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
     private int codigo;
    private String nome;
    private int diasdeemprestimo;
    private int maximodelivros;

    /**
     * COnstrutor para objetos da classe AlunoGrad
     */
    public AlunoPos(int codigo, String nome,int diasdeemprestimo, int maximodelivros)
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
    public int getCodigo(int in){
    return this.codigo;
    }
    public String getNome(){
    return this.nome;
    }
    public int getDiasdeemprestimo(){
    return this.diasdeemprestimo;
    }
    public int getMaximodelivros(){
    return this.maximodelivros;
    }
}
