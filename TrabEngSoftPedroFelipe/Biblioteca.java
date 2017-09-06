import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
	private static Biblioteca instancia = null;

	private ArrayList<Usuario> usuarios;
	private ArrayList<Livro> livros;

	public static void main(String[] args) {
		Biblioteca.get().initCasosDeTeste();
		while (true) {
			Sistema.get().esperarComando();
		}
	}

	private Biblioteca() {
		this.usuarios = new ArrayList<Usuario>();
		this.livros = new ArrayList<Livro>();
	}

	public static Biblioteca get() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}

	private void initCasosDeTeste() {
		/*TODO Para todo caso de teste da especificação, crie uma instância. Primeiro os Livros e Usuarios, depois os Exemplares.
		 * Note que o número dos Exemplares não incrementa por livro, e sim globalmente. Agora, novoLivro precisa receber o número como parâmetro.
		 * Nenhuma das Exceções abaixo está tratada. Leia a especificação e imprima as mensagens corretas com Sistema.get().exibir().
		 * Note que é preciso imprimir as mensagens de sucesso e as consultas, também. Livro.consulta() está pronta. Substitua em consultarLivro()*/
	}
	
	/*Basta chamar o construtor direto
	public void novoLivro(int codigo, String titulo, String editora, String[] autores, int edicao,
			int ano_de_publicacao) {
		boolean sai = false;
		for (Livro liv : livros) {
			if (liv.getCodigo() == codigo) {
				liv.novoExemplar();
				sai = true;
			}
		}
		if (sai == false) {
			Livro liv = new Livro(codigo, titulo, editora, autores, edicao, ano_de_publicacao);
			livros.add(liv);
		}
	}*/

	public void novoAlunoGrad(int codigo, String nome) {
		Usuario usr = new AlunoGrad(codigo, nome);
		usuarios.add(usr);
	}

	public void novoAlunoPos(int codigo, String nome) {
		Usuario usr = new AlunoPos(codigo, nome);
		usuarios.add(usr);
	}

	public void Professor(int codigo, String nome) {
		Usuario usr = new AlunoPos(codigo, nome);
		usuarios.add(usr);
	}

	public void fazerEmprestimo(int id_usuario, int id_livro) {

		for (Livro liv : livros) {
			if (liv.getCodigo() == id_livro) {

				for (Usuario usu : usuarios) {
					if (usu.getCodigo() == id_usuario) {
						try {
							usu.fazerEmprestimo(liv);
						} catch (UsuarioInadimplenteEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UsuarioPegouTodosEmprestimosEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (TodosExemplaresReservadosEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SemExemplaresDisponiveisEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UsuarioJaEstaComLivroEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}

			}

		}
	}

	public void devolverLivro(int id_usuario, int id_livro) {
		for (Livro liv : livros) {
			if (liv.getCodigo() == id_livro) {
				for (Usuario usr : usuarios)
					if (usr.getCodigo() == id_usuario) {
						try {
							usr.registrarDevolucao(liv);
						} catch (UsuarioNaoEstaComLivroEx e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							liv.registrarDevolucao(usr);
						} catch (UsuarioNaoEstaComLivroEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		}
	}

	/**
	 * Esta acessando as classes modelo diretamente. Use
	 * Usuario.registrarReserva(Reserva) e Livro.registrarReserva(Usuario). Eh
	 * preciso criar a instancia da Reserva aqui, tambem, antes de passar
	 */
	public void reservarLivro(int id_usuario, int id_livro){
		for (Livro liv : livros) {
			if (liv.getCodigo() == id_livro) {
				for (Usuario usr : usuarios) {
					if (usr.getCodigo() == id_usuario) {
						Reserva res = new Reserva(usr, liv);
						try {
							usr.registrarReserva(res);
							liv.registrarReserva(res);
						} catch (ReservaJaFeitaEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UsuarioNaoPodeReservarEx e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/** Basta chamar livro.adicionarObserver(Professor) */
	public void assinarLivro(int id_professor, int id_livro) {
		for (Livro liv : livros) {
			for (Usuario usr : usuarios) {
				if (usr.getCodigo() == id_professor)
					liv.registrarObserver((Professor) usr);
			}

		}
	}

	/** Basta chamar livro.consulta() */
	public void consultarLivro(int id_livro) {
		for (Livro liv : livros) {
			if (liv.getCodigo() == id_livro) {
				System.out.println(liv.getTitulo() + " " + liv.getEditora() + " " + liv.getAutores() + " "
						+ liv.getEdicao() + " " + liv.getAnoDePublicacao());

			}
		}

	}

	/** Basta chamar usuario.consulta() */
	public void consultarUsuario(int id_usuario) {
		for (Usuario user : usuarios) {
			if (user.getCodigo() == id_usuario) {
				user.consulta();
			}
		}

	}

	/** Basta chamar professor.consultarAssinatura() */
	public void consultarAssinatura(int id_usuario) {
		for (Usuario user : usuarios) {
			if (user.getCodigo() == id_usuario) {
				Professor professor = (Professor) user;
				professor.consultaAssinatura();
			}
		}
	}

}
