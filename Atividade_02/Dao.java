package Atividade_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Dao {

    //List<Aluno> listaDeAlunos = new ArrayList<>();
    //List<Professor> listaDeProfessor = new ArrayList<>();

    /*public void salvarAlunoNoBD(Aluno aluno) {
        listaDeAlunos.add(aluno);
    }

    public void salvarProfessorNoBD(Professor professor) {
        listaDeProfessor.add(professor);
    }
     */
 /*EXIBE ALUNOS
    public void exibirTodosAlunos() {
        Aluno alunos = new Aluno();
        String nomes = "";
        for (int i = 0; i < listaDeAlunos.size(); i++) {
            alunos = listaDeAlunos.get(i);
            nomes += alunos.getNome() + "\n"; }
        JOptionPane.showMessageDialog(null, "LISTA DE ALUNOS CADASTRADOS \n" + nomes);
    
    }*/
    public void salvarAlunoNoBD(Aluno aluno) throws SQLException {
        Connection conexao = null;
        //primeira coisa é conectar
        try {
            //DriverManager.getConnection("jdbc:mysql://localhost/lp2", "root", "root123");
            //faco a conexao ser armazenada em um objeto conexao para ele nao se perder.
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2bd", "root", "");
            String sql = "insert into aluno(nome, sexo, idade, cpf, ra) "
                    + "values('" + aluno.getNome() + "','" + aluno.getSexo() + "','" + aluno.getIdade() + "',"
                    + "'" + aluno.getCpf() + "','" + aluno.getRa() + "')";
            //Essa funcao faz executar os comandos no Banco
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.executeUpdate();//retorna a quantidade de registros que são afetados.

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            conexao.close();
        }

    }

    public void salvarProfessorNoBD(Professor prof) throws SQLException {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2bd", "root", "");
            String sql = "insert into pprofessor(nome, sexo, cpf, idade, siape)"
                    + "values('" + prof.getNome() + "','" + prof.getSexo() + "','" + prof.getCpf() + "','"
                    + prof.getIdade() + "','" + prof.getSiape() + "')";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            conexao.close();
        }
    }

    public void exibirTodosAlunos() {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2bd", "root", "");

            String info = "";
            String sql = "select * FROM aluno";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String ra = rs.getString("ra");

                String in
                        = "_______________\n"
                        + "NOME: " + nome
                        + "\n CPF: " + cpf
                        + "\n RA: " + ra + "\n";
                info = info + in;

            }
            String imprimi = JOptionPane.showInputDialog(null, info);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        } finally {
            //conexao.close();
        }
    }

    public void exibirTodosProfessores() throws SQLException {

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2bd", "root", "");

            String info = "";
            String sql = "select * FROM pprofessor";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String siape = rs.getString("siape");

                String in
                        = "_______________\n"
                        + "Nome: " + nome
                        + "\nCPF: " + cpf
                        + "\nsiape: " + siape + "\n";

                info = info + in;

            }
            String imprimi = JOptionPane.showInputDialog(null, info);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        } finally {
            //   conexao.close();
        }
    }

    public void removerAlunoBD(String cpfAluno) throws SQLException {

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2bd", "root", "")) {
            String sql = "delete from pprofessor where cpf = ?";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(1, cpfAluno);
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno exluido com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void removerProfessorBD(String cpfProfessor) throws SQLException {

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2bd", "root", "")) {
            String sql = "delete from pprofessor where cpf = ?";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(1, cpfProfessor);
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor exluido com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void atualizarAlunoBD(String infoCpfAluno) throws SQLException {

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2bd", "root", "")) {
            //Aluno aluno = new Aluno();
            String sql = "UPDATE aluno SET nome = ?, sexo = ?, idade = ?, cpf = ?, ra = ? WHERE cpf = ? ";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(6, infoCpfAluno);
            prepare.setString(1, JOptionPane.showInputDialog("Informe novo Nome: "));
            prepare.setString(2, JOptionPane.showInputDialog("Informe novo Sexo: "));
            prepare.setInt(3, Integer.parseInt(JOptionPane.showInputDialog("Informe nova idade: ")));
            prepare.setString(4, JOptionPane.showInputDialog("Informe novo CPF: "));
            prepare.setString(5, JOptionPane.showInputDialog("Informe novo RA: "));
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void atualizarProfessorBD(String infoCpfProfessor) {

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2bd", "root", "")) {
            String sql = "UPDATE pprofessor SET nome = ?, sexo = ?, idade = ?, cpf = ?, siape = ? WHERE cpf = ? ";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(6, infoCpfProfessor);
            prepare.setString(1, JOptionPane.showInputDialog("Informe novo Nome: "));
            prepare.setString(2, JOptionPane.showInputDialog("Informe novo Sexo: "));
            prepare.setInt(3, Integer.parseInt(JOptionPane.showInputDialog("Informe nova idade: ")));
            prepare.setString(4, JOptionPane.showInputDialog("Informe novo CPF: "));
            prepare.setString(5, JOptionPane.showInputDialog("Informe novo SIAPE: "));
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void buscarProf(String nomeProf) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2bd", "root", "");
            String sql = "select * FROM pprofessor WHERE nome = ?";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(1, nomeProf);
            ResultSet rs = prepare.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String siape = rs.getString("siape");

                String in
                        = "_______________\n"
                        + "Nome: " + nome
                        + "\nCPF: " + cpf
                        + "\nsiape: " + siape + "\n";

                JOptionPane.showInputDialog(null, in);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }

    public void buscarAluno(String nomeAluno) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2bd", "root", "");
            String sql = "select * FROM aluno WHERE nome = ?";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(1, nomeAluno);
            ResultSet rs = prepare.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String ra = rs.getString("ra");

                String in
                        = "_______________\n"
                        + "NOME: " + nome
                        + "\nCPF: " + cpf
                        + "\n RA: " + ra + "\n";

                JOptionPane.showInputDialog(null, in);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
}

/*EXIBE PROFESSORES
    public void exibirTodosProfessor() {
        Professor professor = new Professor();
        String nomes = "";
        for (int i = 0; i < listaDeProfessor.size(); i++) {
            professor = listaDeProfessor.get(i);

            nomes += professor.getNome() + "\n";

        }

        JOptionPane.showMessageDialog(null, "LISTA DE PROFESSOR CADASTRADOS\n" + nomes);
    }*/
//REMOVE ALUNO PELO CPF
/* public void removerAluno() {
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa a ser removida: ");
        //Scanner leia = new Scanner(System.in);
        //int c = leia.nextInt();
        for (int i = 0; i < listaDeAlunos.size(); i++) {
            Aluno aluno = listaDeAlunos.get(i);
            if (Long.parseLong(cpf) == aluno.getCpf()) {
                listaDeAlunos.remove(i);
            }

        }
    }
 */
 /*
    //REMOVE PROFESSOR PELO CPF
    public void removerProfessor() {
        String cpf = JOptionPane.showInputDialog("Informe o CPF da pessoa a ser removida: ");
        for (int i = 0; i < listaDeProfessor.size(); i++) {
            Professor prof = listaDeProfessor.get(i);
            if (Long.parseLong(cpf) == prof.getCpf()) {
                listaDeProfessor.remove(i);
                JOptionPane.showMessageDialog(null, "Pessoa deletado com sucesso!");
            }
        }
    }
 */
//SALVAR ALUNO NO BANCO DE DADOS
//SAVLVAR PROFESSOR NO BANCO DE DADOS

