import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/2310

public class Main {
    static class Jogadores {
        ArrayList<String> jogadores = new ArrayList<>(); //Lista de nomes dos jogadores

        public void addNomeDoJogador(String nome) {
            jogadores.add(nome);
        }
    }
    static class Partida {
        ArrayList<Double> listaDeSaques = new ArrayList<>();
        ArrayList<Double> listaDeBloqueios = new ArrayList<>();
        ArrayList<Double> listaDeAtaques = new ArrayList<>();
    }

    static class Juizes {
        public double avaliarSaques(Partida jogo) { //Calcula pontos dos saques
            double saquesTotais = 0;
            double saquesSucedidos = 0;
            for (int i = 0; i < jogo.listaDeSaques.size(); i += 2) {
                saquesTotais += jogo.listaDeSaques.get(i);
            }
            for (int i = 1; i < jogo.listaDeSaques.size(); i += 2) {
                saquesSucedidos += jogo.listaDeSaques.get(i);
            }
            return saquesSucedidos * 100 / saquesTotais;
        }

        public double avaliarBloqueios(Partida jogo) { //Calcula pontos dos bloqueios
            double bloqueiosTotais = 0;
            double bloqueiosSucedidos = 0;
            for (int i = 0; i < jogo.listaDeBloqueios.size(); i += 2) {
                bloqueiosTotais += jogo.listaDeBloqueios.get(i);
            }
            for (int i = 1; i < jogo.listaDeBloqueios.size(); i += 2) {
                bloqueiosSucedidos += jogo.listaDeBloqueios.get(i);
            }
            return bloqueiosSucedidos * 100 / bloqueiosTotais;
        }

        public double avaliarAtaques(Partida jogo) { //Calcula pontos dos Ataques
            double ataquesTotais = 0;
            double ataquesSucedidos = 0;
            for (int i = 0; i < jogo.listaDeAtaques.size(); i += 2) {
                ataquesTotais += jogo.listaDeAtaques.get(i);
            }
            for (int i = 1; i < jogo.listaDeAtaques.size(); i += 2) {
                ataquesSucedidos += jogo.listaDeAtaques.get(i);
            }
            return ataquesSucedidos * 100 / ataquesTotais;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Jogadores jogadores = new Jogadores();
        Juizes juizes = new Juizes();
        Partida partida = new Partida();

        int nJogadores = scanner.nextInt();
        for (int i = 0; i < nJogadores; i++) {
            jogadores.addNomeDoJogador(scanner.next());
            for (int j = 0; j < 2; j++) {
                partida.listaDeSaques.add(scanner.nextDouble());
                partida.listaDeBloqueios.add(scanner.nextDouble());
                partida.listaDeAtaques.add(scanner.nextDouble());
            }
        }

        System.out.printf("Pontos de Saque: %.2f %%.\n", juizes.avaliarSaques(partida));
        System.out.printf("Pontos de Bloqueio: %.2f %%.\n", juizes.avaliarBloqueios(partida));
        System.out.printf("Pontos de Ataque: %.2f %%.\n", juizes.avaliarAtaques(partida));
    }
}
