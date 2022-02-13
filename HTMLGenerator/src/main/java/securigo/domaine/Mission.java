package securigo.domaine;

import java.util.Objects;

public class Mission {
    private String nom;

    public Mission(String nom) {
        this.nom = Objects.requireNonNull(nom);
    }

    public String getNom() {
        return nom;
    }
}
