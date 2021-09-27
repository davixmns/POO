import java.util.Scanner;
import java.io.IOException;

public class Main {
    static class Salto {
        private String NomeSaltadora;
        private double dificuldadeSalto;
        double vetorNotas[] = new double[7];

        public void setNomeSaltadora(String nome) {
            this.NomeSaltadora = nome;
        }

        public String getNomeSaltadora() {
            return this.NomeSaltadora;
        }

        public double setNota(int indice, double nota) {
            this.vetorNotas[indice] = nota;
            return nota;
        }

        public double getNota(int indice) {
            return this.vetorNotas[indice];
        }

        public void setDificuldadeSalto(double dificuldade) {
            this.dificuldadeSalto = dificuldade;
        }

        public double getDificuldadeSalto() {
            return this.dificuldadeSalto;
        }

        public void zerarMenorNota() {
            int indice = 0;
            for (int i = 1; i < this.vetorNotas.length; i++) {
                if (this.vetorNotas[i] < this.vetorNotas[indice]) {
                    indice = i;
                }
            }
            vetorNotas[indice] = 0;
        }

        public void zerarMaiorNota() {
            int indice = 0;
            for (int i = 1; i < this.vetorNotas.length; i++) {
                if (this.vetorNotas[i] > this.vetorNotas[indice]) {
                    indice = i;
                }
            }
            vetorNotas[indice] = 0;
        }

        public double calcularNotaFinal(double dificuldade) {
            zerarMenorNota();
            zerarMaiorNota();
            double soma = 0;
            for (int i = 0; i < this.vetorNotas.length; i++) {
                soma += this.vetorNotas[i];
            }
            return soma * dificuldade;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        Salto salto = new Salto();

        int nNotas = 7;
        int nSaltadores = entrada.nextInt();
        for(int i = 0; i < nSaltadores; i++){
            salto.setNomeSaltadora(entrada.next());
            salto.setDificuldadeSalto(entrada.nextDouble());

            for(int j = 0; j < nNotas; j++) {
                salto.setNota(j, entrada.nextDouble());
            }
            System.out.print(salto.getNomeSaltadora() + " ");
            System.out.printf("%.2f\n", salto.calcularNotaFinal(salto.getDificuldadeSalto()));
        }
    }
}
