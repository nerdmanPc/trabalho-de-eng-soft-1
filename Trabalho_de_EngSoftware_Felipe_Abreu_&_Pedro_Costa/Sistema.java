import java.util.HashMap;
import java.util.Scanner;

//Invoker


public class Sistema
{
    private static Sistema instancia;
    
    private HashMap<String, Comando> comandos;  //falta ver como funciona exatamente o HashMap
    
    private Sistema(){}
    
    public static void initComandos(){}
    
    public void esperarComando(){
      System.out.println("Digite o comando:");
        String line = "";
        String line2 ="";
        //line = input.readString();
        //System.out.println(line);
        while(!line.equals("sai")){
            Scanner input = new Scanner(System.in);
            line= input.next();
            //input = new KeyboardReader();
            //line2= input.readLine();
            //line = parsestring(line2);
            if(line.equals("emp")){
                int usuario = input.nextInt();
                int livro = input.nextInt();
                fazeEmprestimo(usuario,livro);
            }
            if(line.equals("dev")){
                 int usuario = input.nextInt();
                 int livro = input.nextInt();
                 devolverLivro(usuario,livro);
            }
            if(line.equals("res")){
                 int usuario = input.nextInt();
                 int livro = input.nextInt();
                 reservarLivro(usuario,livro);    
            }
            if(line.equals("obs")){
                 int professor = input.nextInt();
                 int livro = input.nextInt();
                 assinarLivro(professor,livro);    
            }
            if(line.equals("liv")){
                 int livro = input.nextInt();
                 consultarLivro(livro);   
            }
            if(line.equals("usu")){
                 int usuario = input.nextInt();
                 consultarUsuario(usuario);       
            }
            if(line.equals("ntf")){
                 int usuario = input.nextInt();
                 consultarAssinatura(usuario);            
            }
        }
    
    
    
    
    
    
    
    }
    
    public static Sistema get()
    {
        if(instancia == null){
            instancia = new Sistema();
        }
        return instancia;
    }
    
    
    
    public void fazeEmprestimo(int id_usuario, int id_livro){}
    public void devolverLivro(int id_usuario, int id_livro){}
    public void reservarLivro(int id_usuario, int id_livro){}
    public void assinarLivro(int id_professor, int id_livro){}
    public void consultarLivro(int id_livro){}
    public void consultarUsuario(int id_usuario){}
    public void consultarAssinatura(int id_livro){}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
