import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//Receiver
//abc

public class Biblioteca
{
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
        if(instancia == null){
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public void novoLivro(int codigo,String titulo,String editora,String[] autores,int edicao, int ano_de_publicacao){
        boolean sai=false;
        for (Livro liv : livros) {
            if(liv.getCodigo()==codigo){
                liv.novoExemplar();
                sai=true;
            }
        }
        if(sai==false){
            Livro liv = new Livro(codigo,titulo,editora,autores,edicao,ano_de_publicacao);
            livros.add(liv);
        }
    }

    public void novoUsuario(int codigo, String nome){
        Usuario usr = new Usuario(codigo,nome); //Achar uma solução pra novos usuarios (nao compila)
        usuarios.add(usr);
    }

    public void fazerEmprestimo(int id_usuario, int id_livro){
        for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                ArrayList<Exemplar> exemp = liv.getExemplares();
                for(Exemplar exe: exemp){
                    if(exe.getDisponibilidade()==true){
                        if(liv.VerSeTaVazia()==true){
                            exe.setDisponibilidade(false);
                            exe.setUsuarioEmp(id_usuario);
                        }else if (liv.getTemUsuarioNaReserva()==id_usuario){
                            exe.setDisponibilidade(false);
                            exe.setUsuarioEmp(id_usuario);
                            liv.RemoveUserDaReserva();
                        }
                    }
                }
            }
        }
    }

    public void devolverLivro(int id_usuario, int id_livro){
        for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                ArrayList<Exemplar> exemp = liv.getExemplares();
                for(Exemplar exe: exemp){
                    if(exe.getDisponibilidade()==false){
                        if(exe.getUsuarioEmp()==id_usuario){
                            exe.setDisponibilidade(true);
                            exe.setUsuarioEmp(0);
                        }
                    }
                }
            }
        }
    }

    public void reservarLivro(int id_usuario, int id_livro){
        for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                ArrayList<Exemplar> exemp = liv.getExemplares();
                for(Exemplar exe: exemp){
                    if(exe.getDisponibilidade()==false){
                        exe.AdicionarUsuarioNaReserva(id_usuario);
                    }
                }
                if(exe.getDisponibilidade()==false){
                    liv.AdicionarUsuarioNaReserva(id_usuario);
                }
            }
        }
    }

    public void assinarLivro(int id_professor, int id_livro){}
    
    public void consultarLivro(int id_livro){
        for (Livro liv : livros) {
            if(liv.getCodigo()==id_livro){
                System.out.println(liv.getTitulo() + " "+ liv.getEditora() + " " 
                    + liv.getAutores()+ " " + liv.getEdicao() +" " + liv.getAnoDePublicacao());

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
