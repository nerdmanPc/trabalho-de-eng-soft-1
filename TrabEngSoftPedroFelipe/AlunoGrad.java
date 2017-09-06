public class AlunoGrad extends Usuario
{
    public AlunoGrad(int codigo, String nome)
    {
        super(codigo, nome, new EmprestimoComum(3,1));
    }

}
