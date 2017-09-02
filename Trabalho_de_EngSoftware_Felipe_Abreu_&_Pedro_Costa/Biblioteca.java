import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;






//Receiver







public class Biblioteca{
    
    private static Biblioteca instancia = null;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;
    
    public Biblioteca get(){
        if(instancia != null){
            instancia = new Biblioteca();
        }
        return instancia;
    }
    
    public static void main(String[] args){ //Estava faltando o Entry Point XD
        Sistema.get().initComandos();
        Sistema.get().esperarComando();
    }
    
    /**Melhor colocar na classe Menu um método idêntico a esse que epera e lê o próximo comando.*/
    private Biblioteca(){ 
      
    }
    public void fazeEmprestimo(int id_usuario, int id_livro){}
    public void devolverLivro(int id_usuario, int id_livro){}
    public void reservarLivro(int id_usuario, int id_livro){}
    public void assinarLivro(int id_professor, int id_livro){}
    public void consultarLivro(int id_livro){}
    public void consultarUsuario(int id_usuario){}
    public void consultarAssinatura(int id_livro){}
    
}
