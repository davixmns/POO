public class Vendedor extends Funcionario {
    private float salarioBase;
    private float comissao;

    public Vendedor() {
        super();
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }


    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    @Override
    public float calcularSalarioFinal() {
        return salarioBase + comissao;
    }

}