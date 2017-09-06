import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Emprestimo
{
    private Usuario usuario;
    private Livro livro;
    private GregorianCalendar data_aquisicao;
    private GregorianCalendar data_devolucao;
    
    private static SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy"); //formatador da data

    public Emprestimo(Usuario usuario, Livro livro, int dias_de_emprestimo){
        this.usuario = usuario;
        this.livro = livro;
        this.data_aquisicao = new GregorianCalendar();
        this.data_devolucao = new GregorianCalendar();
        this.data_devolucao.add(GregorianCalendar.DAY_OF_MONTH, dias_de_emprestimo);
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    public boolean expirou(GregorianCalendar hoje){
        return hoje.after(data_devolucao);
    }
    
    public void encerrar() {
    	this.data_devolucao = new GregorianCalendar();
    }

    public String consultaPorUsuario(){
        return "Livro: " + livro.getTitulo() + 
            "\nData do empréstimo: " + date_format.format(data_aquisicao) + 
            "\nData de devolução: " + date_format.format(data_devolucao) + "\n\n";
    }
}
