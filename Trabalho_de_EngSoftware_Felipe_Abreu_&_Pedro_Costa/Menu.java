import java.util.HashMap;
public class Menu
{
    private static Menu instancia;
    
    private HashMap<String, Comando> comandos;  //falta ver como funciona exatamente o HashMap
    
    private Menu(){}
    
    public void initComandos(){}
    
    public void esperarComando(){}
    
    public Menu get()
    {
        if(instancia == null){
            instancia = new Menu();
        }
        return instancia;
    }
}
