package securigo.main;

import securigo.chemins.CheminRepertoires;
import securigo.chemins.LireTxtRep;
import securigo.domaine.Agent;
import securigo.infrastructure.agentFichierStockage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class run {
    public static void main() throws IOException {
        File listeAgents= LireTxtRep.TxtFiles(CheminRepertoires.repAbsolue)[1];
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        List<String> materiel=new ArrayList();
        String libelle="";
        try
        {
            //todo remplacer l'index 0 par le le basename
            lecteurAvecBuffer = new BufferedReader(new FileReader(listeAgents));
        }
        catch(FileNotFoundException exc)
        {
            System.out.println("Erreur d'ouverture");
        }
        String refe;
        agentFichierStockage a=new agentFichierStockage();
        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            refe=ligne;
            Agent elouane=a.recupererAgent(refe);
            System.out.println("infos de "+refe+" : "+elouane.getIdentifiant()+" ; "+elouane.getNom()+" ; "+elouane.getPrenom()+" ; "+elouane.getUrlImage()+" ; "+elouane.getMission().getNom()+" ; ");
            for(int i=0;i<+elouane.getMaterielAffecte().size();i++) System.out.println("les materiaux de "+refe+" : " +elouane.getMaterielAffecte().get(i).getIdentifiant()+" ; "+elouane.getMaterielAffecte().get(i).getLibelle() );
        }
    }


}
