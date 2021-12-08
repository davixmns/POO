public class EstudoDeInterface {
    public interface Conta {
        void depositar(double valor);
        void sacar(double valor);
        double verSaldo();
    }

    static class Poupanca implements Conta { //A interface Caixa obriga a Poupanca a ter seus métodos
        private double saldo;

        public Poupanca() {
            this.saldo = 0;
        }

        public void depositar(double valor) {
            this.saldo += valor;
        }

        public void sacar(double valor) {
            this.saldo -= valor;
        }

        public double verSaldo() {
            return this.saldo;
        }
    }

    public static void main(String[] args) {
        Poupanca poupanca = new Poupanca();

        poupanca.depositar(10);
        poupanca.sacar(5);
        System.out.println(poupanca.verSaldo());
    }
}
