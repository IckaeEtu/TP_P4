import java.util.ArrayList;
import java.util.List;

public class Grille {
    /*liste de liste de pions dans le plateau */
    private List<List<Integer>> plateau;

    private int nbLignes;
    private int nbColonnes;

    /*la grille de notre plateau */
    public Grille(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.plateau = new ArrayList<>();
    }
    /**
     * @return le nombre de ligne du plateau
     */
    public int getNbLignes() { return nbLignes; }
    /**
     * @return le nombre de colonne du plateau
     */
    public int getNbColonnes() { return nbColonnes; }
}
