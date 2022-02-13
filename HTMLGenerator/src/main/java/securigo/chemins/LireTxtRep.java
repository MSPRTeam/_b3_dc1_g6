package securigo.chemins;

import java.io.File;
import java.io.FileFilter;

/***
 * prend un path en argument
 * et renvoi une list file qui contient tous le sfichiers txt du rep
 */
public abstract class LireTxtRep {
    public static File [] TxtFiles(String rep){
        //TODO récupérer les infos du matériel
        // répertoire de recherche
        // construction d'un fichier sur ce répertoire
        File repFile =  new File(rep) ;

        // filtrage du contenu de ce répertoire
        // on passe en paramètre une instance de classe anonyme
        File [] fichiersJava = repFile.listFiles(new FileFilter() {

            // cette interface n'a qu'une unique méthode
            public  boolean accept(File pathname) {
                // on récupère le nom de ce fichier...
                String fileName = pathname.getName() ;

                // ... et on teste s'il se termine par .java
                return fileName.endsWith(".txt") ;
            }

        }) ;
        return fichiersJava;
    }

}
