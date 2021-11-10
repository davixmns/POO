import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/2167

public class Main {
    static class testeDoMotor {
        ArrayList<Integer> lista = new ArrayList<>();

        public void ligarMotor(int velocidade) {
            lista.add(velocidade);
        }

        public int detectorDeQuedas() {
            int falha = 0;
            for (int i = 1; i < lista.size(); i++) {
                if (lista.get(i) < lista.get(i - 1)) {
                    falha = i + 1;
                    break;
                }
            }
            return falha;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        testeDoMotor motor = new testeDoMotor();

        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            motor.ligarMotor(scanner.nextInt());
        }
        System.out.println(motor.detectorDeQuedas());
    }
}
