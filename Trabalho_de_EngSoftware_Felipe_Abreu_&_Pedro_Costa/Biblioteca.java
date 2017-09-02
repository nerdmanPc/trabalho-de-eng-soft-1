import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//Receiver

public class Biblioteca{
    
    private static Biblioteca instancia = null;
    
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;
    
    public static void main(String[] args){
        Sistema.get().esperarComando();
    }
    
    private Biblioteca(){
        this.usuarios = new ArrayList<Usuario>();
        this.livros = new ArrayList<Livro>();
    }
    
    public static Biblioteca get(){
        if(instancia != null){
            instancia = new Biblioteca();
        }
        return instancia;
    }
    
    public void novoLivro(int codigo,String titulo,String editora,String[] autores,int edicao, int ano_de_publicacao){
        Livro liv = new Livro(codigo,titulo,editora,autores,edicao,ano_de_publicacao);
        livros.add(liv);
    
    }
    
        public void novoUsuario(int codigo, String nome,int diasdeemprestimo, int maximodelivros){
        Usuario usr = new Usuario(codigo,nome,diasdeemprestimo,maximodelivros);
        usuarios.add(usr);
    
    }
    
    public void fazerEmprestimo(int id_usuario, int id_livro){
       for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                if(liv.getDisponibilidade()==true){
                    liv.setDisponibilidade(false);
                    liv.setUsuarioEmp(id_usuario);
                }
            }
       }
    }
    public void devolverLivro(int id_usuario, int id_livro){
      for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                if(liv.getUsuarioEmp()==id_usuario){
                if(liv.getDisponibilidade()==false){
            liv.setDisponibilidade(true);
            liv.setUsuarioEmp(0);
        }
            }
        }
        }
    
    }
    public void reservarLivro(int id_usuario, int id_livro){
    
      for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                if(liv.getDisponibilidade()==true){
            liv.setDisponibilidade(false);
            liv.setUsuarioEmp(id_usuario);
        }
            }
        }
    
    
    }
    public void assinarLivro(int id_professor, int id_livro){}
    public void consultarLivro(int id_livro){
       for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
            System.out.println(liv.getTitulo() + " "+ liv.getEditora() + " " 
            + liv.getAutores()+ " " + liv.getEdicao() +" " + liv.getano_de_publicacao());
            
            }
        }
    
    }
    public void consultarUsuario(int id_usuario){
            for (Usuario user : usuarios) {
            if(user.getCodigo()==id_usuario){
            System.out.println(user.getNome() + " "+ user.getCodigo() + " " + user.getDiasdeemprestimo());
            
            }
        }
    
    }
    public void consultarAssinatura(int id_usuario){
         for (Usuario user : usuarios) {
            if(user.getCodigo()==id_usuario){
            
            }
        }
    
    
    }
    
}
