import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton rejouer ou Lancer une partie
 */
public class ControleurLancerPartie implements EventHandler<ActionEvent> {
    /**
     * modèle du jeu
     */
    private Grille modeleP4;
    /**
     * vue du jeu
     **/
    private Menu vueMenu;

    /**
     * @param modelePendu modèle du jeu
     * @param p vue du jeu
     */
    public ControleurLancerPartie(Grille modeleP4, Menu vueMenu) {
        this.modeleP4=modeleP4;
        this.vueMenu=vueMenu;
    }

    /**
     * L'action consiste à recommencer une partie. Il faut vérifier qu'il n'y a pas une partie en cours
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {

    
        Optional<ButtonType> reponse = this.vueMenu.popUpPartieEnCours().showAndWait(); // on lance la fenêtre popup et on attends la réponse
        // si la réponse est oui
        if (reponse.isPresent() && reponse.get().equals(ButtonType.YES)){
            System.out.println("ok !");
            vueMenu.lancePartie();
        }
        else{
            System.out.println("D'ac !");
     
    }
    }
}
