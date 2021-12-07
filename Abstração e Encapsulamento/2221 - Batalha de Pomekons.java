import java.io.IOException;
import java.util.Scanner;

//Problema: https://www.urionlinejudge.com.br/judge/pt/problems/view/2221

public class BatalhaDePokemons {
    private int bonus;

    private int ataqueDabriel;
    private int defesaDabriel;
    private int levelDabriel;

    private int ataqueGuarte;
    private int defesaGuarte;
    private int levelGuarte;

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setAtaqueDabriel(int ataqueDabriel) {
        this.ataqueDabriel = ataqueDabriel;
    }

    public void setDefesaDabriel(int defesaDabriel) {
        this.defesaDabriel = defesaDabriel;
    }

    public void setLevelDabriel(int levelDabriel) {
        this.levelDabriel = levelDabriel;
    }

    public void setAtaqueGuarte(int ataqueGuarte) {
        this.ataqueGuarte = ataqueGuarte;
    }

    public void setDefesaGuarte(int defesaGuarte) {
        this.defesaGuarte = defesaGuarte;
    }

    public void setLevelGuarte(int levelGuarte) {
        this.levelGuarte = levelGuarte;
    }

    private int calcularValorGolpeDabriel() {
        int valorGolpeDabriel;
        if (this.levelDabriel % 2 != 0) {
            this.bonus = 0;
        }
        valorGolpeDabriel = (this.ataqueDabriel + this.defesaDabriel) / 2 + this.bonus;
        return valorGolpeDabriel;
    }

    private int calcularValorGolpeGuarte() {
        int valorGolpeGuarte;
        if (this.levelGuarte % 2 != 0) {
            this.bonus = 0;
        }
        valorGolpeGuarte = (this.ataqueGuarte + this.defesaGuarte) / 2 + this.bonus;
        return valorGolpeGuarte;
    }


    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        BatalhaDePokemons pokemon = new BatalhaDePokemons();
        int ntestes = entrada.nextInt();
        for (int i = 0; i < ntestes; i++) {;
            pokemon.setBonus(entrada.nextInt());

            pokemon.setAtaqueDabriel(entrada.nextInt());
            pokemon.setDefesaDabriel(entrada.nextInt());
            pokemon.setLevelDabriel(entrada.nextInt());

            pokemon.setAtaqueGuarte(entrada.nextInt());
            pokemon.setDefesaGuarte(entrada.nextInt());
            pokemon.setLevelGuarte(entrada.nextInt());

            if (pokemon.calcularValorGolpeDabriel() > pokemon.calcularValorGolpeGuarte()) {
                System.out.println("Dabriel");
            } else if (pokemon.calcularValorGolpeDabriel() < pokemon.calcularValorGolpeGuarte()) {
                System.out.println("Guarte");
            } else if (pokemon.calcularValorGolpeDabriel() == pokemon.calcularValorGolpeGuarte()) {
                System.out.println("Empate");
            }
        }
    }
}