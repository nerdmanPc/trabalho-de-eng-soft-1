
/**
 * Escreva a descrição da classe AlunoGrad aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class AlunoPos extends Usuario
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    //private int codigo;
    //private String nome;
    //private int diasdeemprestimo;
    //private int maximodelivros;

    public AlunoPos(int codigo, String nome)
    {
        super(codigo, nome);
        //this.codigo=codigo;
        //this.nome=nome;
        //this.diasdeemprestimo=diasdeemprestimo;
        //this.maximodelivros=maximodelivros;
    }
    
    public void fazerEmprestimo(Livro livro){
        Emprestimo emprestimo = new Emprestimo(this, livro, 2);
        if(super.ehDevedor()){
            return;  //ARREMESSAR EXCEÇÃO
        }
        if (super.getNumeroEmprestimosCorrentes() >= 4){
            return;  // ARREMESSAR EXCEÇÃO
        }
        if (livro.todosExemplaresReservados()){
            return;  // ARREMESSAR EXCEÇÃO
        }
        livro.registrarEmprestimo(emprestimo);// ARREMESSAR EXCEÇÕES DE LIVRO, SE NÃO ACHOU EXEMPLAR
        super.removerReserva(livro);
    }
    
    /*
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
    */
}
