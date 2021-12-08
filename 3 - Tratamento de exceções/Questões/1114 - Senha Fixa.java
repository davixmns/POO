import java.util.Scanner;
import java.io.IOException;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1114

public class Main {
    static class Seguranca {
        private int senha;

        public Seguranca(){
            senha = 2002;
        }

        public int getSenha() {
            return senha;
        }

        public void setSenha(int senha) {
            this.senha = senha;
        }

        public void verificarSenhaDigitada(int senha) throws Exception {
            if(this.senha != senha){
                throw new Exception();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Seguranca seguranca = new Seguranca();
        boolean tag = true;

        do{
            try{
                seguranca.verificarSenhaDigitada(scanner.nextInt());
                System.out.println("Acesso Permitido");
                tag = false;
            } catch (Exception e) {
                System.out.println("Senha Invalida");
            }
        }while(tag);
    }
}
