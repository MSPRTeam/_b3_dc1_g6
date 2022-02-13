package securigo.infrastructure;

import securigo.chemins.CheminRepertoires;
import securigo.chemins.LireTxtRep;
import securigo.services.MaterielStockageInterface;
import securigo.domaine.Materiel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaterielFichierStockage implements MaterielStockageInterface {
    @Override
    public Materiel recupererMateriel(String reference) throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        List<String> materiel=new ArrayList();
        String libelle="";
        try
        {
            //todo remplacer l'index 0 par le le basename
            lecteurAvecBuffer = new BufferedReader(new FileReader(LireTxtRep.TxtFiles(CheminRepertoires.repAbsolue)[0]));
        }
        catch(FileNotFoundException exc)
        {
            System.out.println("Erreur d'ouverture");
        }
        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
           // System.out.println(ligne);
            if(ligne.contains(reference)){
                String[] split = ligne.split(" ");
                materiel.add(split[0]);
                int len= split.length;
                for (int i=1; i<len;i++){
                    libelle=libelle+" "+split[i];
                }
                libelle=libelle.strip();
                materiel.add(libelle);
                break;
            }

        }
        lecteurAvecBuffer.close();

        return new Materiel(materiel.get(0), materiel.get(1));
    }
}
/// doPost(request)
