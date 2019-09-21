package Atividade_02;

public class Professor extends Pessoa {

    private String siape;

    public Professor(String siape, String nome, String sexo, String cpf, int idade) {
        super(nome, sexo, cpf, idade);
        this.siape = siape;
    }

    public Professor(String siape) {
        this.siape = siape;
    }

    Professor() {

    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

}
