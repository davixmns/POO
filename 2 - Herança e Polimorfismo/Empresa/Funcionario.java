public abstract class Funcionario {
    private String nome;

    public Funcionario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract float calcularSalarioFinal();
}
