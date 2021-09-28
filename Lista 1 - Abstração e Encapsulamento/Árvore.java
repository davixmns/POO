import java.util.Scanner;
import java.io.IOException;

public class Main {
    static class CompraDaArvore {
        private int altura;
        private int espessura;
        private int qtdGalhos;

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public int getEspessura() {
            return espessura;
        }

        public void setEspessura(int espessura) {
            this.espessura = espessura;
        }

        public int getQtdGalhos() {
            return qtdGalhos;
        }

        public void setQtdGalhos(int qtdGalhos) {
            this.qtdGalhos = qtdGalhos;
        }

        public boolean verificarAltura() {
            return this.altura >= 200 && this.altura <= 300;
        }

        public boolean verificarEspessura() {
            return this.espessura >= 50;
        }

        public boolean verificarQtdGalhos() {
            return this.qtdGalhos >= 150;
        }

        public void verificarArvore() {
            if (verificarAltura() && verificarEspessura() && verificarQtdGalhos()) {
                System.out.println("Sim");
            } else {
                System.out.println("Nao");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        CompraDaArvore arvore = new CompraDaArvore();

        int ncasos = entrada.nextInt();
        for(int i = 0; i < ncasos; i++){
            arvore.setAltura(entrada.nextInt());
            arvore.setEspessura(entrada.nextInt());
            arvore.setQtdGalhos(entrada.nextInt());

            arvore.verificarArvore();
        }
    }
}
