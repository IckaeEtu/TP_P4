import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControleurBoutonJeu implements EventHandler<ActionEvent>{

    private ModeleP4 modeleP4;
    /**
     * vue du jeu
     **/
    private AppliP4 vue;

    private int col;

    public ControleurBoutonJeu(ModeleP4 mP4,AppliP4 vMenu,int col){
        this.modeleP4=mP4;
        this.vue=vMenu;
        this.col=col;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int ligne= modeleP4.ligneVide(col);
        modeleP4.jouer(col);
        modeleP4.victoire(ligne, col);

    }    
}
