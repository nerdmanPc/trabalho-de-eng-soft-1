import java.util.ArrayList;

public class Livro extends Subject
{
    private int codigo;
    private String titulo;
    private String editora;
    private String[] autores;
    private int edicao;
    private int ano_de_publicacao;
    private int numexemplares;
    private ArrayList<Exemplar> exemplares;
    
    //private int codigoexemplar;
    //private boolean disponibilidade;
    //private int usuario_que_pegou_o_livro;

    public Livro(int codigo,String titulo,String editora,String[] autores,int edicao, int ano_de_publicacao){
       this.codigo = codigo;
       this.titulo = titulo;
       this.editora = editora;
       this.autores = autores;
       this.edicao = edicao;
       this.ano_de_publicacao = ano_de_publicacao;
       this.exemplares = new ArrayList<Exemplar>();
       this.numexemplares=0;
       novoExemplar();
    }
    
    public void novoExemplar(){
        this.numexemplares++;
        exemplares.add(new Exemplar(numexemplares));
        
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    
    public int getNumexemplares(){
        return this.numexemplares;
    }
    
    public int getEdicao(){
       return this.edicao;
    }
    
    public int getAnoDePublicacao(){
        return this.ano_de_publicacao;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getEditora(){
        return this.editora;
    }
    
    public String[] getAutores(){
        return this.autores;
    }
    
     public ArrayList<Exemplar> getExemplares(){
        return this.exemplares;
    }
    
    
    
    
    
    
    
}
