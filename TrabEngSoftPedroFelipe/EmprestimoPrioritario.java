public class EmprestimoPrioritario implements EmprestimoBehavior {
	
	private final int NUMERO_DE_DIAS;
	
	public EmprestimoPrioritario(int n_dias) {
		this.NUMERO_DE_DIAS = n_dias;
	}

	@Override
	public Emprestimo fazerEmprestimo(Usuario professor,Livro livro) throws UsuarioInadimplenteEx, SemExemplaresDisponiveisEx{
        Emprestimo emprestimo = new Emprestimo(professor, livro, NUMERO_DE_DIAS);
        if(professor.ehDevedor()){
            throw new UsuarioInadimplenteEx();
        }
        livro.registrarEmprestimo(emprestimo);
        professor.removerReserva(livro);
        return emprestimo;
    }
}
