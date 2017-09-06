
public class EmprestimoComum implements EmprestimoBehavior {
	
	private final int NUMERO_DE_EMPRESTIMOS;
	private final int NUMERO_DE_DIAS;
	
	public EmprestimoComum(int n_emprestimos, int n_dias) {
		this.NUMERO_DE_EMPRESTIMOS = n_emprestimos;
		this.NUMERO_DE_DIAS = n_dias;
	}

	@Override
    public Emprestimo fazerEmprestimo(Usuario aluno, Livro livro) throws UsuarioInadimplenteEx, UsuarioPegouTodosEmprestimosEx, 
        TodosExemplaresReservadosEx, SemExemplaresDisponiveisEx
    {
        Emprestimo emprestimo = new Emprestimo(aluno, livro, NUMERO_DE_DIAS);
        
        if(aluno.ehDevedor()){
            throw new UsuarioInadimplenteEx();
        }
        if (aluno.getNumeroEmprestimosCorrentes() >= NUMERO_DE_EMPRESTIMOS){
            throw new UsuarioPegouTodosEmprestimosEx();
        }
        if (livro.todosExemplaresReservados() && !livro.usuarioTemReserva(aluno)){
            throw new TodosExemplaresReservadosEx();
        }
        livro.registrarEmprestimo(emprestimo);// ARREMESSAR EXCEÇÕES DE LIVRO, SE NÃO ACHOU EXEMPLAR
        aluno.removerReserva(livro);
        return emprestimo;
    }
}
