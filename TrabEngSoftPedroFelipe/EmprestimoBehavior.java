public interface EmprestimoBehavior {
	public Emprestimo fazerEmprestimo(Usuario usuario, Livro livro) throws UsuarioInadimplenteEx, UsuarioPegouTodosEmprestimosEx, 
    	TodosExemplaresReservadosEx, SemExemplaresDisponiveisEx;
}
