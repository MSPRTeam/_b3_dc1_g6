package securigo.infrastructure;

import securigo.chemins.CheminRepertoires;
import securigo.chemins.LireTxtRep;
import securigo.domaine.Mission;
import securigo.services.AgentStockageInterface;
import securigo.domaine.Agent;
import securigo.domaine.Materiel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class agentFichierStockage implements AgentStockageInterface {
    @Override
    public Agent recupererAgent(String reference) throws IOException {
        List<Materiel> materielsAffectesAAgent;
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        String ref=reference+".txt";
        File [] repertoire= LireTxtRep.TxtFiles(CheminRepertoires.repFiches);
        //TODO IMAGE...
        String img="usdboou";

        for(int i=0; i<repertoire.length;i++){
            if(repertoire[i].getName().equals(ref)){
                try
                {
                    lecteurAvecBuffer = new BufferedReader(new FileReader(repertoire[i]));
                }
                catch(FileNotFoundException exc)
                {
                    System.out.println("Erreur d'ouverture");
                }
            }

        }
        Boolean nom=false;
        Boolean prenom=false;
        Boolean poste=false;
        Boolean materiel=false;
        Boolean mission=false;
        Boolean password=false;
        List<String> agent= new ArrayList();
        if(lecteurAvecBuffer!=null){
            while ((ligne = lecteurAvecBuffer.readLine()) != null) {
                if (nom!=true){
                    agent.add(ligne);
                    nom=true;
                    continue;
                }
                if (prenom!=true){
                    agent.add(ligne);
                    prenom=true;
                    continue;
                }
                if (poste!=true){
                    agent.add(ligne);
                    poste=true;
                    continue;
                }
                if(password!=true){
                    password=true;
                    continue;
                }
                if(ligne.strip().equals("")){
                    continue;
                }
                agent.add(ligne);

            }
            lecteurAvecBuffer.close();
        }
        Agent agents=new Agent(reference,agent.get(0),agent.get(1),img);
        Mission m=new Mission(agent.get(2));
        agents.setMission(m);

        List<Materiel> materiels=new ArrayList();
        MaterielFichierStockage mat=new MaterielFichierStockage();
        for(int i=3;i<agent.size();i++){
            materiels.add(mat.recupererMateriel(agent.get(i)));
        }
        agents.setMaterielAffecte(materiels);
        return agents;
    }
}
/// doPost(request)
