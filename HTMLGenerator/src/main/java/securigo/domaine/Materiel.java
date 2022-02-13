package securigo.domaine;

import java.util.Objects;

public class Materiel {
    private String identifiant;
    private String libelle;

    public Materiel(String identifiant, String libelle) {
        this.identifiant = Objects.requireNonNull(identifiant);
        this.libelle = Objects.requireNonNull(libelle);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getLibelle() {
        return libelle;
    }
}
