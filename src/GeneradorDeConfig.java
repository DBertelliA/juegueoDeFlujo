import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GeneradorDeConfig {
    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Entro al generador");
            ProcessBuilder pbCommand = new ProcessBuilder("ip" ,"-c" , "a");

            Process p = pbCommand.start();

            p.waitFor();
            Scanner sc = new Scanner(p.getInputStream());

            String linea;
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                if(linea.contains("inet")) {
                    System.out.println(linea);
                }
            }
            sc.close();
        } catch (InterruptedException | IOException e) {
            System.err.println("Error del generador");
            System.err.println(e);
        }




    }

}
