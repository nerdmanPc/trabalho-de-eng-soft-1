
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
    private String autores;
    private int edicao;
    private int anodepublicacao;

    /**
     * COnstrutor para objetos da classe Livro
     */
    public Livro(int codigo,String titulo,String editora,String autores,int edicao, int anodepublicao)
    {
       this.codigo=codigo;
       this.titulo=titulo;
       this.editora=editora;
       this.autores=autores;
       this.edicao=edicao;
       this.anodepublicacao=anodepublicao;
    }

    public int getCodigo(){
    return this.codigo;
    
    }
     public int getEdicao(){
        return this.edicao;
        
        }
     public int getAnodepublicacao(){
        
        return this.anodepublicacao;
        }
    
    public String getTitulo(){
    return this.titulo;
    }
    public String getEditora(){
    return this.editora;
    }
    public String getAutores(){
    return this.autores;
    }
    
    
    public void setCodigo(int in){this.codigo=in;}
    public void setEdicao(int in){this.edicao=in;}
    public void setAnodepublicacao(int in){this.anodepublicacao=in;}
    public void setTitulo(String str){this.titulo=str;}
    public void setgetEditora(String str){this.editora=str;}
    public void setAutores(String str){this.autores=str;}
    
    
    
    
    
    
}
