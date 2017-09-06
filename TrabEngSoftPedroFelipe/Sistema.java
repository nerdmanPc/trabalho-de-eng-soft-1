import java.util.HashMap;
import java.util.Scanner;

//Invoker

public class Sistema
{
    private static Sistema instancia = null;
    
    private HashMap<String, Comando> comandos;
    private Scanner entrada;
    
    /** O construtor deve preencher o HashMap com os comandos correpondentes **/
    private Sistema(){
        entrada = new Scanner(System.in);
        comandos = new HashMap<String, Comando>();
        
        /** Inicializa comandos: sai, emp, dev, res, obs, liv, usu, ntf**/
        comandos.put("sai", new ComandoSair());
        comandos.put("emp", new ComandoFazerEmprestimo());
        comandos.put("dev", new ComandoDevolverLivro());
        comandos.put("res", new ComandoReservarLivro());
        comandos.put("obs", new ComandoAssinarLivro());
        comandos.put("liv", new ComandoConsultarLivro());
        comandos.put("usu", new ComandoConsultarUsuario());
        comandos.put("ntf", new ComandoConsultarAssinatura());
        
        
        /** ... **/
    } 
    
    public static Sistema get(){
        if(instancia == null){
            instancia = new Sistema();
        }
        return instancia;
    }
    
    public Scanner getEntrada(){
        return this.entrada;
    }
    
    public void exibir(String mensagem) {
    	System.out.println(mensagem);
    }
        
    public void esperarComando(){
        System.out.println("Digite o comando:");
        
        String comando = entrada.next();
        comandos.get(comando).executar();
        
        /*
        String line = "";
        String line2 ="";
        //line = entrada.readString();
        //System.out.println(line);
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
        }*/
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
