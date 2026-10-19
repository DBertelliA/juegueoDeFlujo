import java.io.File;
import java.io.IOException;

public class CreadorDeProcesos {
    public static void main(String[] args) {
        try {
            ProcessBuilder pbGen = new ProcessBuilder("java", "src/GeneradorDeConfig.java");
            ProcessBuilder pbF = new ProcessBuilder("java", "src/Recolector.java");

            File fileSol = new File("Archivo.txt");
            fileSol.createNewFile();
            pbGen.redirectOutput(fileSol);

            pbF.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process pf = pbF.start();
            Process pg = pbGen.start();

            int i = pg.waitFor();
            int o = pf.waitFor();

            if(i != 0 || o != 0){
                System.err.println("GGs");
            }


        } catch (InterruptedException | IOException e) {
            System.err.println("Error principal");
            System.err.println(e);
        }
    }

}