package securigo.domaine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Agent {
    private String identifiant;
    private String nom;
    private String prenom;
    private String urlImage;
    private List<Materiel> materielAffecte;
    private Mission mission;

    public Agent(String identifiant, String nom, String prenom, String urlImage) {
        this.identifiant = Objects.requireNonNull(identifiant);
        this.nom = Objects.requireNonNull(nom);
        this.prenom = Objects.requireNonNull(prenom);
        this.urlImage = Objects.requireNonNull(urlImage);
        this.materielAffecte = new ArrayList<Materiel>();
        this.mission = null;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public List<Materiel> getMaterielAffecte() {
        return materielAffecte;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMaterielAffecte(List<Materiel> materielAffecte) {
        this.materielAffecte = materielAffecte;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}