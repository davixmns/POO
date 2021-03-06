import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/2311

public class Main {
    static class Saltadora {
        private String NomeSaltadora;
        private double dificuldade;

        public void setNomeSaltadora(String nome) {
            this.NomeSaltadora = nome;
        }

        public String getNomeSaltadora() {
            return this.NomeSaltadora;
        }

        public void setDificuldade(double dificuldade) {
            this.dificuldade = dificuldade;
        }

        public double getDificuldade() {
            return this.dificuldade;
        }

    }
    
    static class Juizes {
        ArrayList<Double> listaDeSaltos = new ArrayList<Double>();

        public double calcularNota(Saltadora saltadora) {
            listaDeSaltos.sort(null);
            double soma = 0;
            for (int i = 0; i < listaDeSaltos.size(); i++) {
                soma += listaDeSaltos.get(i);
            }
            return (soma - (listaDeSaltos.get(0) + listaDeSaltos.get(6))) * saltadora.getDificuldade();
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Juizes juizes = new Juizes();
        Saltadora saltadora = new Saltadora();

        int nSaltadores = scanner.nextInt();
        for (int i = 0; i < nSaltadores; i++) {
            saltadora.setNomeSaltadora(scanner.next());
            saltadora.setDificuldade(scanner.nextDouble());

            for (int j = 0; j < 7; j++) {
                juizes.listaDeSaltos.add(scanner.nextDouble());
            }
            System.out.print(saltadora.getNomeSaltadora() + " ");
            System.out.printf("%.2f\n", juizes.calcularNota(saltadora));
            juizes.listaDeSaltos.clear();
        }
    }
}
