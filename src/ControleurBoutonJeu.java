import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControleurBoutonJeu implements EventHandler<ActionEvent>{
    /*
    * le modele du jeu
    */
    private ModeleP4 modeleP4;
    /*
     * vue du jeu
     */
    private AppliP4 vue;
    /*
    *le numéro de la colonne
    */
    private int col;
     /*
     * Constructeur du contrôleur du bouton de jeu
     * @param mP4 le modele de notre p4
     * @param vMenu l'application de notre jeu
     * @param col le numéro de la colonne.
     */
    public ControleurBoutonJeu(ModeleP4 mP4,AppliP4 vMenu,int col){
        this.modeleP4=mP4;
        this.vue=vMenu;
        this.col=col;
    }


    /**
     * Actions à effectuer à tous les couts du joueur
     * regarde si le joueur peut jouer et si il a gagné
     * @param actionEvent événement Action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        int ligne= modeleP4.ligneVide(col);
        modeleP4.jouer(col);
        modeleP4.victoire(ligne, col);

    }    
}
