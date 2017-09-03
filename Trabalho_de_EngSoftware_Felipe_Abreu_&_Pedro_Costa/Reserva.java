import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Reserva
{
    private Livro livro;
    private GregorianCalendar data_requisicao;
    
    public Reserva(Livro livro){
        this.livro = livro;
        this.data_requisicao = new GregorianCalendar();
    }
    
    public String consulta(){
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        return livro.getTitulo() + " - " + date_format.format +"\n";
    }
}
