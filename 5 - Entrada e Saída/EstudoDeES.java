import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//Programa que fiz para estudos de streaming de dados
//Utiliza InputStream, OutputStream, PrintStream, File, FileOutputStream, FileInputStream e Exceptions

public class EstudoDeES {
    public static void main(String[] args) throws IOException, InputMismatchException {
        InputStream inputStream = System.in; //Entrada padrão
        OutputStream outputStream = System.out; //Saída padrão
        File arquivo = new File("arquivo.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(arquivo); //se conecta com o objeto arquivo
        FileInputStream fileInputStream = new FileInputStream(arquivo); //se conecta com o objeto arquivo
        PrintStream printStream = new PrintStream(fileOutputStream); //PrintStream que usa o arquivo como saída
        Scanner fileScanner = new Scanner(fileInputStream); //scanner que usa objeto fileInputStream como entrada para a aplicação
        Scanner scanner = new Scanner(inputStream); //scanner que usa a entrada padrão(teclado) como entrada para a aplicação
        boolean flag = true; //variável para encerrar o programa

        do {
            try {
                System.out.println("\n1-(Caractere -> Decimal) 2-(Decimal -> Caractere) 3-(Escrever em arquivo) 4-(Ler arquivo) 5-(Encerrar programa)");
                System.out.print("Digite uma opção -> ");
                int escolha = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                if (escolha == 1) { //Caractere -> Decimal
                    System.out.print("Quantos caracteres quer ler? -> ");
                    int n = scanner.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Digite o " + i + "° -> ");
                        scanner.nextLine();
                        System.out.println(inputStream.read()); //Lê o caractere e retorna o decimal
                    }

                } else if (escolha == 2) { //Decimal -> Caractere
                    System.out.print("Quantos decimais quer ler? -> ");
                    int n = scanner.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Digite o " + i + "° -> ");
                        outputStream.write(scanner.nextInt()); //Lê o decimal
                        outputStream.flush(); //Descarga dos dados em caractere
                        System.out.println();
                    }

                } else if (escolha == 3) { //Escrever em arquivo
                    if(!arquivo.canWrite()) { //Verificar se o arquivo não pode ser escrito
                        System.out.println("Arquivo não pode ser escrito");

                    } else { //Pode ser escrito
                        System.out.print("Digite o que quer escrever -> ");
                        printStream.println(scanner.nextLine());
                        System.out.println("Escrita realizada com sucesso");
                    }

                } else if (escolha == 4) { //Ler arquivo
                    if (arquivo.length() == 0) { //Verificar se o arquivo está vazio
                        System.out.println("Arquivo vazio ou inexistente");
                    } else if(!arquivo.canRead()) { //Verifica se o arquivo não pode ser lido
                        System.out.println("O arquivo não pode ser lido");

                    } else { //Pode ser lido
                        while (fileScanner.hasNextLine()) { //Enquanto tiver linhas
                            System.out.println(fileScanner.nextLine()); //Printa a linha
                        }
                    }

                } else if (escolha == 5) { //Encerrar programa
                    System.out.println("Fim do programa");
                    flag = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida, digite novamente");
                scanner.nextLine();
            } catch (IOException e){
                System.out.println("\nErro na manipulação do arquivo");
                scanner.nextLine();
            }
        } while (flag); //Enquanto a escolha for != 5
    }
}
