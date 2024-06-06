import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class AppliP4 extends Application {
    private Grille modeleGrille;

    @FXML private HBox lignePlacement;
    
    @FXML private StackPane stackPane;
    @FXML private GridPane grille;
    @FXML private Shape grilleBackground;

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        modeleGrille = new Grille(6, 7);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Création d'une instance de FXMLLoader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FenetreJeu.fxml"));
        
        // Définir ce contrôleur comme celui utilisé par le fichier FXML
        loader.setController(this);
        
        // Chargement du fichier FXML
        BorderPane root = loader.load();

        // Création de la scène
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Puissance 4");
        primaryStage.show();

        // Creation du plateau
        placerTrous();
    }

    private void placerTrous() {
        for (int i = 0; i < modeleGrille.getNbLignes(); i++) {
            for (int j = 0; j < modeleGrille.getNbColonnes(); j++) {
                float rayon = 20;
                Circle trou = new Circle(rayon, new Color(0.5, 0.5, 0.5, 0.5));
                trou.setCenterX(rayon);
                trou.setCenterY(rayon);
                grille.add(trou, j, i);
                grilleBackground = Path.subtract(grilleBackground, trou);
                trou.visibleProperty().set(true);
            }
        }

        //stackPane.getChildren().set(0, grilleBackground);
    }
}
