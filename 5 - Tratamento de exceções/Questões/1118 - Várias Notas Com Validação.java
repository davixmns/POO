import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1118

public class Main {
    static class AvaliacaoDeAluno {
        ArrayList<Double> listaDeNotas = new ArrayList<Double>();

        public void gravarNota(double nota) throws InvalidParameterException {
            if (nota < 0.00 || nota > 10.00) {
                throw new InvalidParameterException();
            }

            listaDeNotas.add(nota);
        }

        public double calcularMedia() {
            double soma = 0;
            for (int i = 0; i < listaDeNotas.size(); i++) {
                soma += listaDeNotas.get(i);
            }
            return soma / 2;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AvaliacaoDeAluno avaliador = new AvaliacaoDeAluno();
        boolean flag = true;
        boolean flag2;
        int nNotasRequisitadas = 2;
        int nNotasValidas = 0;
        int escolha;

        do {
            try {
                flag2 = true;
                while (nNotasValidas < nNotasRequisitadas) {
                    avaliador.gravarNota(scanner.nextDouble());
                    nNotasValidas++;
                }
                nNotasValidas = 0;
                System.out.printf("media = %.2f\n", avaliador.calcularMedia());
                avaliador.listaDeNotas.clear();

                do {
                    System.out.println("novo calculo (1-sim 2-nao)");
                    escolha = scanner.nextInt();
                    if(escolha == 2){
                        flag2 = false;
                        flag = false;
                    } else if(escolha == 1) {
                        flag2 = false;
                    }
                } while (flag2);

            } catch (InvalidParameterException e) {
                System.out.println("nota invalida");
            }
        } while (flag);
    }
}
