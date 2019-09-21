package Atividade_02;

public abstract class Pessoa {

    private String nome;
    private String sexo;
    private String cpf;
    private int idade;

    public Pessoa(String nome, String sexo, String cpf, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
    }

    Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
