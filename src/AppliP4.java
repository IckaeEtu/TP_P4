import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private ModeleP4 modeleP4;
    
    @FXML private StackPane stackPane;
    @FXML private GridPane grille;
    @FXML private Shape grilleBackground;

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        modeleP4= new ModeleP4();
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
        root.setBottom(ajoutBoutonJouer());
        Chronometre chrono= new Chronometre();
        root.setRight(chrono);
        chrono.start();
        
        // Creation du plateau
        placerTrous();
    }

    private void placerTrous() {
        for (int i = 0; i < modeleGrille.getNbLignes(); i++) {
            for (int j = 0; j < modeleGrille.getNbColonnes(); j++) {
                float rayon = 10;
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

    public HBox ajoutBoutonJouer(){
        GridPane grilleBoutonJeu= new GridPane();
        BorderPane bPane= new BorderPane();
        GridPane panel= new GridPane();
        float rayon = 10;
        HBox hbox= new HBox();
        Button col1 = new Button("col1");
        Button col2 = new Button("col2");
        Button col3 = new Button("col3");
        Button col4 = new Button("col4");
        Button col5 = new Button("col5");
        Button col6 = new Button("col6");
        Button col7 = new Button("col7");
        col1.setOnAction(new ControleurBoutonJeu(modeleP4, this, 0));
        col2.setOnAction(new ControleurBoutonJeu(modeleP4, this, 1));
        col3.setOnAction(new ControleurBoutonJeu(modeleP4, this,2));
        col4.setOnAction(new ControleurBoutonJeu(modeleP4, this, 3));
        col5.setOnAction(new ControleurBoutonJeu(modeleP4, this, 4));
        col6.setOnAction(new ControleurBoutonJeu(modeleP4, this, 5));
        col7.setOnAction(new ControleurBoutonJeu(modeleP4, this, 6));


        


        hbox.getChildren().addAll(col1,col2,col3,col4,col5,col6,col7);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);

        return hbox;
    }
}
