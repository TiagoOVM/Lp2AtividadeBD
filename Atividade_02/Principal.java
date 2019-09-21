package Atividade_02;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) throws SQLException {

        List<Aluno> listaDeAlunos = new ArrayList<>();
        List<Professor> listaDeProfessor = new ArrayList<>();
        Aluno aluno = new Aluno();
        Metodos metodo = new Metodos();
        Professor professor = new Professor();
        Dao dao = new Dao();

        String op = JOptionPane.showInputDialog("Para cadastrar Aluno digite 1 "
                + "\nPara cadastrar Professor Digite 2 "
                + "\n Para exibir Todos os Alunos digite 3"
                + "\n Para Exibir Professor digite 4"
                + "\n Para Remover Aluno digite 5"
                + "\n Para Remover Professor digite 6"
                +"\n Para Atualizar Informações de um Aluno digite 7 "
                +"\n Para Atualizar Informações de um Professor digite 8 "
                + "\n Para Buscar Professor por Nome digite 9"
                + "\n Para Buscar Aluno por Nome digite 10"
                + "\n Para sair digite 0");

        while (!op.equals("0")) {

            int opcao = Integer.parseInt(op);
            switch (opcao) {
                case 1:
                    metodo.leituraAluno();
                    //new Dao().salvarPessoa(aluno);
                    break;

                case 2:
                    metodo.leituraProfessor();
                    //new Dao().salvarPessoa(professor);
                    break;

                case 3:

                    metodo.exibirAlunos();

                    break;

                case 4:

                    metodo.exibirProfessor();

                    break;

                case 5:

                    metodo.removeAlunoCpf();

                    break;

                case 6:

                    metodo.removeProfessorCpf();

                    break;
                    
                case 7:
                    
                    metodo.atualizarAluno();
                    
                    break;
                    
                case 8:
                    
                    metodo.atualizarProfessor();
                    
                    break;
                    
                case 9:
                    
                    metodo.buscarProfesNome();
                    
                case 10:
                    
                    metodo.buscarAlunoNome();
            }

            op = JOptionPane.showInputDialog("Para cadastrar Aluno digite 1 "
                    + "\nPara cadastrar Professor Digite 2 "
                    + "\n Para exibir Aluno digite 3"
                    + "\n Para Exibir Professor digite 4"
                    + "\n Para Remover Aluno digite 5"
                    + "\n Para Remover Professor digite 6"
                    + "\n Para Atualizar Informações de um aluno digite 7"
                    + "\n Para Atualizar Informações de um Professor digite 8"
                    + "\n Para Buscar Professor por Nome digite 9"
                    + "\n Para Buscar Aluno por Nome digite 10"
                    + "\n Para sair digite 0");

            
        }
    }
}
