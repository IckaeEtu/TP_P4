import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurBoutonJeu {

    private Grille modeleP4;
    /**
     * vue du jeu
     **/
    private Menu vueMenu;

    private int col;

    public ControleurBoutonJeu(Grille mP4,Menu vMenu,int col){
        this.modeleP4=mP4;
        this.vueMenu=vMenu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modeleP4.jouer(col);

    }
    
}
