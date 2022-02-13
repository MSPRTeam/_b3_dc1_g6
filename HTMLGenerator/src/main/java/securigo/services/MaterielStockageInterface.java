package securigo.services;


import securigo.domaine.Materiel;

import java.io.IOException;

public interface MaterielStockageInterface {
    public Materiel recupererMateriel(String reference) throws IOException;
}
