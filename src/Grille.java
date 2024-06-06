import java.util.ArrayList;
import java.util.List;

public class Grille {
    private List<List<Integer>> plateau;

    private int nbLignes;
    private int nbColonnes;


    public Grille(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.plateau = new ArrayList<>();
    }

    public int getNbLignes() { return nbLignes; }

    public int getNbColonnes() { return nbColonnes; }
}
