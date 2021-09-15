import java.io.IOException;
import java.util.Scanner;

public class Main {
    private int codigo;
    private double valorProduto;
    private int quantidade;
    private double conta;

    public void setCodigo(int tipo){
        this.codigo = tipo;
        defineValorProduto();
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
        calcularConta();
    }
    private void defineValorProduto() {
        if (this.codigo == 1) {
            this.valorProduto = 4.00;
        } else if (this.codigo == 2) {
            this.valorProduto = 4.50;
        } else if (this.codigo == 3) {
            this.valorProduto = 5.00;
        } else if (this.codigo == 4) {
            this.valorProduto = 2.00;
        } else if (this.codigo == 5) {
            this.valorProduto = 1.50;
        }
    }
    private void calcularConta(){
        this.conta = this.quantidade * this.valorProduto;
    }
    public double getConta(){
        return this.conta;
    }
    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        Main produto = new Main();
        produto.setCodigo(entrada.nextInt());
        produto.setQuantidade(entrada.nextInt());
        System.out.printf("Total: R$ %.2f\n", produto.getConta());

    }

}