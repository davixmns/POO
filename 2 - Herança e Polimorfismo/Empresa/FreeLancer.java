public class FreeLancer extends Funcionario {
    private int diasTrabalhados;
    private float valorDia;

    public FreeLancer() {
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    @Override
    public float calcularSalarioFinal() {
        return diasTrabalhados * valorDia;
    }
}