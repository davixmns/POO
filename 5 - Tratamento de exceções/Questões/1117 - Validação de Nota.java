import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1117

public class Main {
    static class AvaliacaoDeAluno {
        ArrayList<Float> notas = new ArrayList<>();

        public void addNota(float nota) throws Exception {
            if (nota < 0.0 || nota > 10.0) {
                throw new Exception();
            }

            notas.add(nota);
        }

        public float calcularMedia() {
            float soma = 0;
            for (int i = 0; i < notas.size(); i++) {
                soma += notas.get(i);
            }
            return soma / notas.size();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AvaliacaoDeAluno avaliador = new AvaliacaoDeAluno();

        int notasValidas = 0;
        boolean tag = true;

        do {
            try {
                while (notasValidas < 2) {
                    avaliador.addNota(scanner.nextFloat());
                    notasValidas++;
                }
                System.out.printf("media = %.2f\n", avaliador.calcularMedia());
                tag = false;
            } catch (Exception e) {
                System.out.println("nota invalida");
            }
        } while (tag);
    }
}
