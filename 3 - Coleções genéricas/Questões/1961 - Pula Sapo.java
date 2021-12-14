import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1961

public class Main {
    static class Jogo {
        public void jogar(Mapa mapa, Sapo sapo) {
            boolean resultado = true;

            for (int i = 0; i < mapa.getnCanos() - 1; i++) {
                if (mapa.canos.get(i) > mapa.canos.get(i + 1)) {
                    if (mapa.canos.get(i) - mapa.canos.get(i + 1) > sapo.getAlturaDoPulo()) {
                        resultado = false;
                        break;
                    }
                } else if (mapa.canos.get(i) < mapa.canos.get(i + 1)) {
                    if (mapa.canos.get(i + 1) - mapa.canos.get(i) > sapo.getAlturaDoPulo()) {
                        resultado = false;
                        break;
                    }
                }
            }

            if (resultado) {
                System.out.println("YOU WIN");
            } else {
                System.out.println("GAME OVER");
            }
        }

    }

    static class Sapo extends Jogo {
        private int alturaDoPulo;

        public int getAlturaDoPulo() {
            return alturaDoPulo;
        }

        public void setAlturaDoPulo(int alturaDoPulo) {
            this.alturaDoPulo = alturaDoPulo;
        }

    }

    static class Mapa extends Jogo {
        private int nCanos;
        ArrayList<Integer> canos = new ArrayList<>();

        public int getnCanos() {
            return nCanos;
        }

        public void setnCanos(int nCanos) {
            this.nCanos = nCanos;
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Sapo sapo = new Sapo();
        Mapa mapa = new Mapa();
        Jogo jogo = new Jogo();

        sapo.setAlturaDoPulo(scanner.nextInt());
        mapa.setnCanos(scanner.nextInt());

        for (int i = 0; i < mapa.getnCanos(); i++) {
            mapa.canos.add(scanner.nextInt());
        }
        jogo.jogar(mapa, sapo);
    }
}
