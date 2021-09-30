import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

//Problema: https://www.urionlinejudge.com.br/judge/pt/problems/view/2708

public class Main {
    static class Jeep {
        private String jeepMovement;
        private int touristInJeep;

        public Jeep(String movement, int touristInJeep) {
            this.jeepMovement = movement;
            this.touristInJeep = touristInJeep;
        }

        public String getJeepMovement() {
            return jeepMovement;
        }

        public void setJeepMovement(String jeepMovement) {
            this.jeepMovement = jeepMovement;
        }

        public int getTouristInJeep() {
            return touristInJeep;
        }

        public void setTouristInJeep(int touristInJeep) {
            this.touristInJeep = touristInJeep;
        }
    }

    static class Traffic {
        private int jeepsNumberOutside;
        private int touristsNumberOutside;

        public Traffic() {
            this.jeepsNumberOutside = 0;
            this.touristsNumberOutside = 0;
        }

        public int getJeepsNumberOutside() {
            return jeepsNumberOutside;
        }

        public void setJeepsNumberOutside(int jeepsNumberOutside) {
            this.jeepsNumberOutside += jeepsNumberOutside;
        }

        public int getTouristsNumberOutside() {
            return touristsNumberOutside;
        }

        public void setTouristsNumberOutside(int touristsNumberOutside) {
            this.touristsNumberOutside += touristsNumberOutside;
        }

        public void controlTraffic(Jeep jeep) {
            if (jeep.getJeepMovement().equals("SALIDA")) {
                setJeepsNumberOutside(+1);
                setTouristsNumberOutside(jeep.getTouristInJeep());
            } else if (jeep.getJeepMovement().equals("VUELTA")) {
                setJeepsNumberOutside(-1);
                setTouristsNumberOutside(-jeep.getTouristInJeep());
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Traffic traffic = new Traffic();

        String jeepMovement = scanner.next();
        int touristInJeep;

        while (!Objects.equals(jeepMovement, "ABEND")) {
            touristInJeep = scanner.nextInt();

            Jeep jeep = new Jeep(jeepMovement, touristInJeep);
            traffic.controlTraffic(jeep);

            jeepMovement = scanner.next();
        }

        System.out.println(traffic.getTouristsNumberOutside());
        System.out.println(traffic.getJeepsNumberOutside());
    }
}