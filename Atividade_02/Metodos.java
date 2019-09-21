package Atividade_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Metodos {

    Dao dao = new Dao();
    private int i;

    //METODOS LEITURA DE DADOS ALUNO OU PROFESSOR
    public void leituraAluno() throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setNome(JOptionPane.showInputDialog("Digite o nome do Aluno: "));
        aluno.setSexo(JOptionPane.showInputDialog("Digite o sexo do Aluno: "));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do Aluno")));
        aluno.setCpf(JOptionPane.showInputDialog("Digite o CPF do Aluno: "));
        aluno.setRa(JOptionPane.showInputDialog("Informe o RA do Aluno: "));
        //dao.salvarAluno(aluno);
        dao.salvarAlunoNoBD(aluno);
    }

    public void leituraProfessor() throws SQLException {
        Professor prof = new Professor();
        prof.setNome(JOptionPane.showInputDialog("Digite o nome do Professor: "));
        prof.setSexo(JOptionPane.showInputDialog("Digite o sexo do Professor: "));
        prof.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do Professor: ")));
        prof.setCpf(JOptionPane.showInputDialog("Digite o CPF do Professor: "));
        prof.setSiape(JOptionPane.showInputDialog("Digite o SIAPE do professor: "));
        dao.salvarProfessorNoBD(prof);
    }

    //METODO EXIBIR ALUNOS
    public void exibirAlunos() throws SQLException {

        dao.exibirTodosAlunos();
    }

    //METODO EXIBIR PROFESSOR
    public void exibirProfessor() throws SQLException {

        dao.exibirTodosProfessores();
    }

    //METODO REMOVER ALUNO  
    public String cpfAluno() throws SQLException {

        String infoCpf = JOptionPane.showInputDialog("Informe o CPF do aluno a ser removido: ");

        return infoCpf;
    }

    public void removeAlunoCpf() throws SQLException {

        dao.removerAlunoBD(cpfAluno());
    }

    //METODO REMOVER PROFESSOR
    public String cpfProfessor() throws SQLException {

        String infoCpf = JOptionPane.showInputDialog("Informe o CPF do Professor a ser removido: ");

        return infoCpf;
    }

    public void removeProfessorCpf() throws SQLException {

        dao.removerProfessorBD(cpfProfessor());
    }

    public String atualizarCPF() throws SQLException {

        String infoCpf = JOptionPane.showInputDialog("Informe o CPF da Pessoa a ser Atualizado: ");

        return infoCpf;
    }

    public void atualizarAluno() throws SQLException {

        dao.atualizarAlunoBD(atualizarCPF());
    }

    public void atualizarProfessor()throws SQLException{
        
        dao.atualizarProfessorBD(atualizarCPF());
    }
    
    public void buscarProfesNome()throws SQLException{
        
        String nome;
        nome = JOptionPane.showInputDialog("Digite o nome do Professor a ser Visualizado: ");
        
        dao.buscarProf(nome);
        
    }
    
    public void buscarAlunoNome()throws SQLException{
        String nome;
        nome = JOptionPane.showInputDialog("Digite o nome do Aluno a ser Visualizado: ");
        
        dao.buscarAluno(nome);
        
    }
}


/*  public void removerProfessor() {
        dao.removerProfessor();
    }
    
    public void atualizar Aluno(){

    dao
    }
 */
