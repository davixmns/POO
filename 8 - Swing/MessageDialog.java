import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageDialog {
    BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("arquivo.txt")));

    public MessageDialog() throws IOException {
        String texto = "";
        while (leitor.ready()) {
            texto += leitor.readLine() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto, "Mensagem", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            new MessageDialog();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
