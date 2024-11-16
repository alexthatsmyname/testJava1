package problema_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    public static List<Publicatie> citestePublicatiiDinCSV(String filePath) {
        List<Publicatie> publicatii = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String titlu = split[0];
                String autor = split[1];
                int anPublicare = Integer.parseInt(split[2]);
                if(!split[3].isEmpty()) {
                    int numarPagini = Integer.parseInt(split[3]);
                    publicatii.add(new Carte(titlu, autor, anPublicare, numarPagini));
                } else {
                    int numarExemplare = Integer.parseInt(split[3]);
                    publicatii.add(new Revista(titlu, autor, anPublicare, numarExemplare));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publicatii;
    }
}
