/**
 * Escreva a descrição da classe AlunoGrad aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class AlunoPos extends Usuario
{
    public AlunoPos(int codigo, String nome)
    {
        super(codigo, nome);
    }
    
    @Override
    public void fazerEmprestimo(Livro livro) throws UsuarioInadimplenteEx, UsuarioPegouTodosEmprestimosEx, 
        TodosExemplaresReservadosEx, SemExemplaresDisponiveisEx
    {
        Emprestimo emprestimo = new Emprestimo(this, livro, 2);
        
        if(super.ehDevedor()){
            throw new UsuarioInadimplenteEx();
        }
        if (super.getNumeroEmprestimosCorrentes() >= 4){
            throw new UsuarioPegouTodosEmprestimosEx();
        }
        if (livro.todosExemplaresReservados()){
            throw new TodosExemplaresReservadosEx();
        }
        livro.registrarEmprestimo(emprestimo);// ARREMESSAR EXCEÇÕES DE LIVRO, SE NÃO ACHOU EXEMPLAR
        super.removerReserva(livro);
    }
    /*
    public void setCodigo(int in){this.codigo=in;}
    public void setNome(String str){this.nome=nome;}
    public void setDiasdeemprestimo(int in){this.diasdeemprestimo=in;}
    public void setMaximodelivros(int in){this.maximodelivros=in;}
    */
    /*
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
    /*
    public int getCodigo(int in){return this.codigo;}
    public String getNome(){return this.nome;}
    public int getDiasdeemprestimo(){return this.diasdeemprestimo;}
    public int getMaximodelivros(){return this.maximodelivros;}
    */
}
