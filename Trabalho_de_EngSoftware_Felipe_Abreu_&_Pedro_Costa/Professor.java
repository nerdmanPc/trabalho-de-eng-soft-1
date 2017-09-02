
/**
 * Escreva a descrição da classe AlunoGrad aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Professor implements Observer
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int codigo;
    private String nome;
    private int diasdeemprestimo;
    private int maximodelivros;
    private int numero_de_notificacoes;

    /**
     * COnstrutor para objetos da classe AlunoGrad
     */
    public Professor(int codigo, String nome,int diasdeemprestimo, int maximodelivros)
    {
     this.codigo=codigo;
       this.nome=nome;
       this.diasdeemprestimo=diasdeemprestimo;
       this.maximodelivros=maximodelivros;
       this.numero_de_notificacoes = 0;
    }
    
    public void atualizar(Subject s){
        this.numero_de_notificacoes++;
    }

    public void setCodigo(int in){this.codigo=in;}
    public void setNome(String str){this.nome=nome;}
    public void setDiasdeemprestimo(int in){this.diasdeemprestimo=in;}
    public void setMaximodelivros(int in){this.maximodelivros=in;}
    public int getCodigo(int in){return this.codigo;}
    public String getNome(){return this.nome;}
    public int getDiasdeemprestimo(){return this.diasdeemprestimo;}
    public int getMaximodelivros(){return this.maximodelivros;}
}
