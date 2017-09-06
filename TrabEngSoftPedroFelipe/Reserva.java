import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Reserva
{
	private Usuario usuario;
    private Livro livro;
    private GregorianCalendar data_requisicao;
    
    private static SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy"); //formatador da data
    
    public Reserva(Usuario usuario, Livro livro){
    	this.usuario = usuario;
        this.livro = livro;
        this.data_requisicao = new GregorianCalendar();
    }
    
    public String consultaPorUsuario(){
        return "Livro: " + livro.getTitulo() + "\nData: " + date_format.format(data_requisicao) +"\n\n";
    }
    
    public String consultaPorLivro() {
    	return usuario.getNome() + "\n";
    }
    
    public Livro getLivro(){
        return this.livro;
    }
    
    public Usuario getUsuario() {
    	return this.usuario;
    }
}
