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
    
    public void fazerEmprestimo(int id_usuario, int id_livro){}
    public void devolverLivro(int id_usuario, int id_livro){}
    public void reservarLivro(int id_usuario, int id_livro){}
    public void assinarLivro(int id_professor, int id_livro){}
    public void consultarLivro(int id_livro){}
    public void consultarUsuario(int id_usuario){}
    public void consultarAssinatura(int id_livro){}
    
}
