import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/3160

public class Main {
    static class ListaDeAmigos {
        private String indicacao;
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> listaFinal = new ArrayList<>();
        String[] vAmigosVelhos = new String[5];
        String[] vAmigosNovos = new String[5];

        public String getIndicacao() {
            return indicacao;
        }

        public void setIndicacao(String indicacao) {
            this.indicacao = indicacao;
        }

        public void addAmigosVelhos(String amigos) {
            vAmigosVelhos = amigos.split(" ");
            Collections.addAll(lista, vAmigosVelhos);
        }

        public void addAmigosNovos(String amigosNovos) {
            vAmigosNovos = amigosNovos.split(" ");
            Collections.addAll(lista, vAmigosNovos);
        }

        public void organizarListaDeAmigos() {
            if (!Objects.equals(getIndicacao(), "nao")) {
                int tag = lista.indexOf(getIndicacao());

                for (int i = 0; i < vAmigosNovos.length; i++) {
                    lista.add(tag, vAmigosNovos[i]);
                    tag++;
                }
                limparExcesso();
            }
        }

        public void limparExcesso(){
            int qtdElemRemover = lista.size() - (vAmigosNovos.length + vAmigosVelhos.length);
            int ultimoElem = lista.size()-1;
            for (int j = qtdElemRemover; j > 0; j--) {
                lista.remove(ultimoElem);
                ultimoElem--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListaDeAmigos listBook = new ListaDeAmigos();

        listBook.addAmigosVelhos(scanner.nextLine());
        listBook.addAmigosNovos(scanner.nextLine());
        listBook.setIndicacao(scanner.next());

        listBook.organizarListaDeAmigos();

        for (int i = 0; i < listBook.lista.size()-1; i++) {
            System.out.print(listBook.lista.get(i) + " ");
        }
        System.out.print(listBook.lista.get(listBook.lista.size()-1) + "\n");
    }

}
