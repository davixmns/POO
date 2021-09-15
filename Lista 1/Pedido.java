import java.util.Scanner;
//Problema: https://www.urionlinejudge.com.br/judge/pt/problems/view/1038
public class Pedido {
    private int codigo;
    private int quantidade;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private double calcularConta() {
        double cachorroQuente = 4.00;
        double xSalada = 4.50;
        double xBacon = 5.00;
        double torrada = 2.00;
        double refrigerante = 1.50;
        double conta = 0;

        if (this.codigo == 1) {
            conta += cachorroQuente * this.quantidade;
        } else if (this.codigo == 2) {
            conta += xSalada * this.quantidade;
        } else if (this.codigo == 3) {
            conta += xBacon * this.quantidade;
        } else if (this.codigo == 4) {
            conta += torrada * this.quantidade;
        } else if (this.codigo == 5) {
            conta += refrigerante * this.quantidade;
        }
        return conta;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Pedido pedido = new Pedido();
        pedido.setCodigo(entrada.nextInt());
        pedido.setQuantidade(entrada.nextInt());
        System.out.printf("Total: R$ %.2f\n", pedido.calcularConta());
    }
}