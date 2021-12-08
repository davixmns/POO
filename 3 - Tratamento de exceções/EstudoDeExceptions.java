import java.util.InputMismatchException;
import java.util.Scanner;

//Programa que fiz para estudo de Exceptions

public class EstudoDeExceptions {
    public static int quociente(int numerador, int denomidador) throws ArithmeticException, InputMismatchException {
        return numerador/denomidador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            try {
                int resultado = quociente(scanner.nextInt(), scanner.nextInt());
                System.out.printf("%nResult: = %s%n",resultado);
                continueLoop = false;

            } catch (InputMismatchException exception) {
                System.err.printf("%nException: %s%n", exception);
                scanner.nextLine();
                System.out.printf("Você deve digitar inteiros, tente novamente%n%n");

            } catch (ArithmeticException exception) {
                System.err.printf("%nException: %s%n", exception);
                System.out.printf("Zero é um denominador inválido, tente novamente. %n%n");
            }

        } while (continueLoop);
    }
}

