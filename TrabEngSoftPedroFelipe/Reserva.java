import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Reserva
{
    private Livro livro;
    private GregorianCalendar data_requisicao;
    
    private static SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy"); //formatador da data
    
    public Reserva(Livro livro){
        this.livro = livro;
        this.data_requisicao = new GregorianCalendar();
    }
    
    public String consultaPorUsuario(){
        return "Livro: " + livro.getTitulo() + "\nData: " + date_format.format(data_requisicao) +"\n\n";
    }
    
    public Livro getLivro(){
        return this.livro;
    }
}
