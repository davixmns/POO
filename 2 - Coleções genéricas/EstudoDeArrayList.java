import java.util.ArrayList;
import java.util.Scanner;

//PROGRAMA DE LISTA DE INTEIROS USANDO ArrayList

public class EstudoDeArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList list = new ArrayList();

        System.out.println("\n1:nova lista - 2:mostrar lista - 3:adicionar dado - 4:alterar dado");
        System.out.println("5:procurar dado - 6:limpar lista - 7:encerrar");
        System.out.print("Digite uma opção: ");
        int escolha = scanner.nextInt();
        while (escolha != 7) { //ENQUANTO O USUÁRIO NÃO ENCERRAR
            if (escolha == 1) { //NOVA LISTA
                list.clear();
                System.out.print("Comprimento da lista: ");
                int x = scanner.nextInt();
                for (int i = 0; i < x; i++) {
                    System.out.print("dado " + (i + 1) + ": ");
                    list.add(scanner.nextInt());
                }

            } else if (escolha == 2) { //MOSTRAR LISTA
                int y = list.size();
                System.out.println();
                for (int j = 0; j < y; j++) {
                    System.out.print("Índice: " + list.indexOf(list.get(j)) + " - ");
                    System.out.println("dado: " + list.get(j));
                }

            } else if (escolha == 3) { //ADICIONAR DADO
                System.out.print("Digite o dado: ");
                list.add(scanner.nextInt());

            } else if (escolha == 4) { //ALTERAR DADO
                System.out.print("Digite a posição: ");
                int pos = scanner.nextInt();
                if (pos > list.size()) {
                    System.out.println("posição inválida");
                } else {
                    System.out.print("Digite o dado: ");
                    int dado = scanner.nextInt();
                    list.add(pos, dado);
                }

            } else if (escolha == 5) { //PROCURAR DADO
                System.out.print("digite o dado: ");
                if (list.contains(scanner.nextInt())) {
                    System.out.println("O dado está na lista");
                } else {
                    System.out.println("0 dado não está na lista");
                }

            } else if (escolha == 6) { //LIMPAR LISTA
                list.clear();

            } else {
                System.out.println("Opção inexistente");
            }

            System.out.println("\n1:nova lista - 2:mostrar lista - 3:adicionar dado - 4:alterar dado");
            System.out.println("5:procurar dado - 6:limpar lista - 7:encerrar");
            System.out.print("Digite uma opção: ");
            escolha = scanner.nextInt();
        }
    }
}

