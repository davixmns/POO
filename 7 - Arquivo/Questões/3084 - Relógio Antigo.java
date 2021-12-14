import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/3084

public class Main {
    static class ConversorDeHorario {
        public String hora;
        public String minuto;

        public void converterHora(double valor) {
            this.hora = String.valueOf(Math.round((valor / 360) * 12));
        }

        public void converterMinuto(double valor) {
            this.minuto = String.valueOf(Math.round(valor / 6));
        }

        public String executar(double hora, double minuto) {
            converterHora(hora);
            converterMinuto(minuto);

            if (this.hora.length() == 1 && this.minuto.length() == 1) {
                return "0" + this.hora + ":0" + this.minuto;
            } else if (this.hora.length() == 1 && this.minuto.length() > 1) {
                return "0" + this.hora + ":" + this.minuto;
            } else if (this.hora.length() > 1 && this.minuto.length() == 1) {
                return this.hora + ":0" + this.minuto;
            } else if (this.hora.length() > 1 && this.minuto.length() > 1) {
                return this.hora + ":" + this.minuto;
            }
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ConversorDeHorario conversor = new ConversorDeHorario();
        double hora;
        double minuto;

        while (bufferedReader.ready()) {
            String[] strings = bufferedReader.readLine().split(" ");
            hora = Double.parseDouble(strings[0]);
            minuto = Double.parseDouble(strings[1]);
            System.out.println(conversor.executar(hora, minuto));
        }
    }
}
