/**
 * Escreva a descrição da classe AlunoGrad aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Professor extends Usuario implements Observer
{
    //private int codigo;
    //private String nome;
    private int numero_de_notificacoes;

    public Professor(int codigo, String nome)
    {
        super(codigo, nome);
        //this.codigo=codigo;
        //this.nome=nome;
        this.numero_de_notificacoes = 0;
    }
    
    @Override
    public void fazerEmprestimo(Livro livro) throws UsuarioInadimplenteEx, SemExemplaresDisponiveisEx{
        Emprestimo emprestimo = new Emprestimo(this, livro, 4);
        if(super.ehDevedor()){
            throw new UsuarioInadimplenteEx();
        }
        livro.registrarEmprestimo(emprestimo);// ARREMESSAR EXCEÇÕES DE LIVRO
        super.removerReserva(livro);
    }
    
    public int consultaAssinatura(){
        return this.numero_de_notificacoes;
    }

    public void atualizar(Subject s){
        this.numero_de_notificacoes++;
    }
    
    /*public void setCodigo(int in){this.codigo=in;}

    public void setNome(String str){this.nome=nome;}

    public void setDiasdeemprestimo(int in){this.diasdeemprestimo=in;}

    public void setMaximodelivros(int in){this.maximodelivros=in;}

    public int getCodigo(int in){return this.codigo;}

    public String getNome(){return this.nome;}

    public int getDiasdeemprestimo(){return this.diasdeemprestimo;}

    public int getMaximodelivros(){return this.maximodelivros;}*/
   
    
      
    
    
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
