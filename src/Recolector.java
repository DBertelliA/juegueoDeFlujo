import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Recolector {
    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Entro al recolector");

            FileReader flR = new FileReader("Archivo.txt");
            BufferedReader bfR = new BufferedReader(flR);

            String linea;
            while((linea = bfR.readLine()) != null){
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.err.println("Error del recolector");
            System.err.println(e);
        }
    }
}
