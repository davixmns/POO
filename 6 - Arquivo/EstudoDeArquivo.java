import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//Programa que fiz para estudos de arquivo
//Utiliza: Scanner, File, FileInputStream, FileWriter e Exceptions

public class EstudoDeArquivo {
    public static void main(String[] args) throws IOException {
        File arquivo = new File("Arquivo.txt"); //Objeto de referência para o arquivo
        FileWriter fileWriter = new FileWriter(arquivo); //FileWriter  que se conecta com o objeto de File
        FileInputStream fileInputStream = new FileInputStream(arquivo); //FileInputStream que se conecta com o objeto de File
        Scanner scanner = new Scanner(System.in); //Scanner que usa a entrada padrão(teclado)
        Scanner fileScanner = new Scanner(fileInputStream); //Scanner que usa o objeto fileInputStream como entrada de dados do programa
        boolean flag = true; //Variável para encerrar o programa

        do {
            try {
                System.out.println("1-(escrever) 2-(ler) 3-(Encerrar programa)");
                System.out.print("Digite uma opção -> ");
                int escolha = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                if (escolha == 1) { //Escrever
                    if(!arquivo.canWrite()) { //Verifica se o arquivo não pode ser escrito
                      System.out.println("Arquivo não pode ser escrito");

                    } else { //Pode ser escrito
                        System.out.print("Digite oque escrever -> ");
                        fileWriter.write(scanner.nextLine());
                        fileWriter.close();
                        System.out.println("Escrita realizada com sucesso\n");
                    }

                } else if (escolha == 2) { //Ler
                    if(!arquivo.canRead()) { //Verifica se o arquivo não pode ser lido
                        System.out.println("O arquivo não pode ser lido\n");
                    } else { //Pode ser lido
                        if (arquivo.length() == 0) { //Verifica se o arquivo está vazio
                            System.out.println("Arquivo vazio ou inexistente\n");

                        } else { //Tem algo a ler
                            while (fileScanner.hasNextLine()) { //Enquanto tiver linhas
                                System.out.println(fileScanner.nextLine()); //printa linhas do arquivo
                            }
                            System.out.println();
                        }
                    }

                } else if (escolha == 3) { //Encerrar programa
                    System.out.println("Fim do programa");
                    flag = false;
                }

            }catch (InputMismatchException e){
                System.out.println("\nEntrada inválida, digite novamente.\n");
                scanner.nextLine();
            } catch (IOException e) {
                e.getStackTrace();
                scanner.nextLine();
            }
        } while (flag); //Enquanto a escolha for != 3
    }
}
