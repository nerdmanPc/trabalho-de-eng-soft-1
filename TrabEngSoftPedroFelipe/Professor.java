public class Professor extends Usuario implements Observer
{
    private int numero_de_notificacoes;

    public Professor(int codigo, String nome){
        super (codigo, nome, new EmprestimoPrioritario(4));
        this.numero_de_notificacoes = 0;
    }
    
    public int consultaAssinatura(){
        return this.numero_de_notificacoes;
    }

    public void atualizar(Subject s){
        this.numero_de_notificacoes++;
    }
}
