import java.util.Scanner;

public class Empresa {

    public static float obterSalarioDoFuncionario(Funcionario funcionario) {
        float resposta = funcionario.calcularSalarioFinal();
        return resposta;
    }

    public static void main(String[] args) {
        Vendedor v = new Vendedor();
        FreeLancer f = new FreeLancer();
        v.setNome("Carlos");
        v.setSalarioBase(2000);
        v.setComissao(3000);
        System.out.println("Salario vendedor: " + obterSalarioDoFuncionario(v));
        f.setNome("Clara");
        f.setDiasTrabalhados(20);
        f.setValorDia(150);
        System.out.println("Salario free lancer: " + obterSalarioDoFuncionario(f));
    }

}