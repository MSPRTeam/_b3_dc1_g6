package securigo.services;


import securigo.domaine.Materiel;

import java.io.IOException;

public class MaterielService {
    public MaterielStockageInterface materielStockageInterface;

    public Materiel recupererMateriel(String reference) throws IOException {
        return materielStockageInterface.recupererMateriel(reference);
    }
}
