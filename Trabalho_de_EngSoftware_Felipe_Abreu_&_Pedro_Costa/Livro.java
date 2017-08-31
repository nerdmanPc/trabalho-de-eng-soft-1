
/**
 * Escreva a descrição da classe Livro aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Livro
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int codigo;
    private String titulo;
    private String editora;
    private String[] autores;
    private int edicao;
    private int ano_de_publicacao;

    public Livro(int codigo,String titulo,String editora,String[] autores,int edicao, int ano_de_publicacao){
       this.codigo = codigo;
       this.titulo = titulo;
       this.editora = editora;
       this.autores = autores;
       this.edicao = edicao;
       this.ano_de_publicacao = ano_de_publicacao;
    }

    public int getCodigo(){
        return this.codigo;
    }
    
    public int getEdicao(){
       return this.edicao;
    }
    
    public int getano_de_publicacao(){
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
    
    
    public void setCodigo(int in){this.codigo=in;}
    public void setEdicao(int in){this.edicao=in;}
    public void setano_de_publicacao(int in){this.ano_de_publicacao=in;}
    public void setTitulo(String str){this.titulo=str;}
    public void setgetEditora(String str){this.editora=str;}
    public void setAutores(String[] str){this.autores=str;}
    
    
    
    
    
    
}
