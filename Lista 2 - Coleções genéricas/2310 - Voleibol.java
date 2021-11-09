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
    static class Jogo {
        ArrayList<Double> listaDeSaques = new ArrayList<>();
        ArrayList<Double> listaDeBloqueios = new ArrayList<>();
        ArrayList<Double> listaDeAtaques = new ArrayList<>();

        public int tamListaDeSaques(){ return listaDeAtaques.size(); }
        public int tamListaDeBloqueios(){ return listaDeBloqueios.size(); }
        public int tamListaDeAtaques(){ return listaDeBloqueios.size(); }

        public double getSaque(int i) { return listaDeSaques.get(i); }
        public double getBloqueio(int i) { return listaDeBloqueios.get(i); }
        public double getAtaque(int i) { return listaDeAtaques.get(i); }

        public void realizarSaque(double saque) { listaDeSaques.add(saque); }
        public void realizarBloqueio(double bloqueio) { listaDeBloqueios.add(bloqueio); }
        public void realizarAtaque(double ataque) { listaDeAtaques.add(ataque); }
    }

    static class Juizes {
        public double avaliarSaques(Jogo jogo) { //Calcula pontos dos saques
            double saquesTotais = 0;
            double saquesSucedidos = 0;
            for (int i = 0; i < jogo.tamListaDeSaques(); i += 2) {
                saquesTotais += jogo.getSaque(i);
            }
            for (int i = 1; i < jogo.tamListaDeSaques(); i += 2) {
                saquesSucedidos += jogo.getSaque(i);
            }
            return saquesSucedidos * 100 / saquesTotais;
        }

        public double avaliarBloqueios(Jogo jogo) { //Calcula pontos dos bloqueios
            double bloqueiosTotais = 0;
            double bloqueiosSucedidos = 0;
            for (int i = 0; i < jogo.tamListaDeBloqueios(); i += 2) {
                bloqueiosTotais += jogo.getBloqueio(i);
            }
            for (int i = 1; i < jogo.tamListaDeBloqueios(); i += 2) {
                bloqueiosSucedidos += jogo.getBloqueio(i);
            }
            return bloqueiosSucedidos * 100 / bloqueiosTotais;
        }

        public double avaliarAtaques(Jogo jogo) { //Calcula pontos dos Ataques
            double ataquesTotais = 0;
            double ataquesSucedidos = 0;
            for (int i = 0; i < jogo.tamListaDeAtaques(); i += 2) {
                ataquesTotais += jogo.getAtaque(i);
            }
            for (int i = 1; i < jogo.tamListaDeAtaques(); i += 2) {
                ataquesSucedidos += jogo.getAtaque(i);
            }
            return ataquesSucedidos * 100 / ataquesTotais;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Jogadores jogadores = new Jogadores();
        Juizes juizes = new Juizes();
        Jogo jogo = new Jogo();

        int nJogadores = scanner.nextInt();
        for (int i = 0; i < nJogadores; i++) {
            jogadores.addNomeDoJogador(scanner.next());
            for (int j = 0; j < 2; j++) {
                jogo.realizarSaque(scanner.nextDouble());
                jogo.realizarBloqueio(scanner.nextDouble());
                jogo.realizarAtaque(scanner.nextDouble());
            }
        }

        System.out.printf("Pontos de Saque: %.2f %%.\n", juizes.avaliarSaques(jogo));
        System.out.printf("Pontos de Bloqueio: %.2f %%.\n", juizes.avaliarBloqueios(jogo));
        System.out.printf("Pontos de Ataque: %.2f %%.\n", juizes.avaliarAtaques(jogo));
    }
}
