package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvReader {
    private List<String[]> classe = new ArrayList<>();

    public csvReader(String dossier) {
        loadClasse(dossier);
    }

    private void loadClasse(String dossier) {
        try (BufferedReader fichier = new BufferedReader(new FileReader(dossier))) {
            String line;
            fichier.readLine();
            line = fichier.readLine();
            while (line != null) {
                classe.add(line.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String[]> getClasse() {
        return classe;
    }
}
