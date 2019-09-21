package Atividade_02;

public class Aluno extends Pessoa {

    private String ra;

    public Aluno(String ra, String nome, String sexo, String cpf, int idade) {
        super(nome, sexo, cpf, idade);
        this.ra = ra;
    }

    public Aluno(String ra) {
        this.ra = ra;
    }

    public Aluno() {

    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

}
