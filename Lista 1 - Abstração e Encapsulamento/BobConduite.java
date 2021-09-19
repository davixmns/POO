import java.util.Scanner;
import java.io.IOException;

//Problema: https://www.urionlinejudge.com.br/judge/pt/problems/view/1589

public class BobConduite {
        private int r1;
        private int r2;

        public void SetR1(int r1) {
            this.r1 = r1;
        }

        public void setR2(int r2) {
            this.r2 = r2;
        }

        private int calcularMenorRaioDoConduite(){
            int raio = this.r1 + this.r2;
            return raio;
        }

        public static void main(String[] args) throws IOException{
            Scanner entrada = new Scanner(System.in);
            BobConduite conduite = new BobConduite();
            int ncasos = entrada.nextInt();
            for(int i = 0; i < ncasos; i++) {
                conduite.SetR1(entrada.nextInt());
                conduite.setR2(entrada.nextInt());
                System.out.println(conduite.calcularMenorRaioDoConduite());
            }
        }
    }
