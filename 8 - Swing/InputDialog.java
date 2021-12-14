import javax.swing.JOptionPane;

public class InputDialog {
    private int pi;

    public void setPi(String pi) {
        this.pi = Integer.parseInt(pi);
    }

    public int getPi() {
        return pi;
    }

    public static void main(String[] args) {
        InputDialog obj = new InputDialog();

        obj.setPi(JOptionPane.showInputDialog("Numero do pi"));

        System.out.printf("%s", obj.getPi());

    }
}
