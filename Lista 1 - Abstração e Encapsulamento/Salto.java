import java.util.Scanner;
import java.io.IOException;

//Problema: https://www.urionlinejudge.com.br/judge/pt/problems/view/2311

public class Main {
    static class Salto {
        private String NomeSaltadora;
        private double dificuldade;
        double notas[] = new double[7];

        public void setNomeSaltadora(String nome) {
            this.NomeSaltadora = nome;
        }

        public String getNomeSaltadora() {
            return this.NomeSaltadora;
        }

        public double setNota(int indice, double nota) {
            this.notas[indice] = nota;
            return nota;
        }

        public double getNota(int indice) {
            return this.notas[indice];
        }

        public void setDificuldade(double dificuldade) {
            this.dificuldade = dificuldade;
        }

        public double getDificuldade() {
            return this.dificuldade;
        }

        public void zerarMenorNota() {
            int indice = 0;
            for (int i = 1; i < this.notas.length; i++) {
                if (this.notas[i] < this.notas[indice]) {
                    indice = i;
                }
            }
            notas[indice] = 0;
        }

        public void zerarMaiorNota() {
            int indice = 0;
            for (int i = 1; i < this.notas.length; i++) {
                if (this.notas[i] > this.notas[indice]) {
                    indice = i;
                }
            }
            notas[indice] = 0;
        }

        public double calcularNota(double dificuldade) {
            zerarMenorNota();
            zerarMaiorNota();
            double soma = 0;
            for (int i = 0; i < this.notas.length; i++) {
                soma += this.notas[i];
            }
            return soma * dificuldade;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        Salto salto = new Salto();

        int nNotas = 7;
        int nSaltadores = entrada.nextInt();
        for (int i = 0; i < nSaltadores; i++) {
            salto.setNomeSaltadora(entrada.next());
            salto.setDificuldade(entrada.nextDouble());

            for (int j = 0; j < nNotas; j++) {
                salto.setNota(j, entrada.nextDouble());
            }
            System.out.print(salto.getNomeSaltadora() + " ");
            System.out.printf("%.2f\n", salto.calcularNota(salto.getDificuldade()));
        }
    }
}
