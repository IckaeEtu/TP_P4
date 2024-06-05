import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


public class Menu extends Application{
    private Button btnLancer;
    private Button btnFermé;
    private Button  btnConnexion;
    private Button btnSkin;
    private Label text;
    private BorderPane panelCentral;
    private Chronometre chrono;

    @Override
    public void init() {
        this.btnFermé=new Button();
        this.btnLancer = new Button();
        this.btnConnexion = new Button();
        this.btnSkin = new Button();
        this.text= new Label();
        this.panelCentral= new BorderPane();
        this.chrono= new Chronometre();
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }



    public Pane titre(){
        Stage stage = new Stage();
        stage.setTitle("Puissance 4");

        BorderPane bp = new BorderPane();

        Label l1 = new Label("  Jeu du puissance 4");
        bp.setLeft(l1);

        HBox hb = new HBox();

        Button home = new Button();
        ImageView image1 = new ImageView("file:img/home.png");
        home.setOnAction((ActionEvent event) ->{
            this.pageAccueil();
        });
        home.setGraphic(image1);
        image1.setFitHeight(40);
        image1.setFitWidth(40);

        Button param = new Button();
        ImageView image2 = new ImageView("file:img/parametres.png");
        image2.setFitHeight(40);
        image2.setFitWidth(40);

        
        param.setGraphic(image2);

        Button info = new Button();
        ImageView image3 = new ImageView("file:img/info.png");
        info.setOnAction((ActionEvent event) ->{
            this.popUpReglesDuJeu().showAndWait();
        });
        info.setGraphic(image3);
        image3.setFitHeight(40);
        image3.setFitWidth(40);

        hb.getChildren().addAll(home, param, info);
        bp.setRight(hb);
        bp.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        return bp;
    }


    private void pageAccueil(){
        Stage stage = new Stage();
        stage.setTitle("Puissance 4");

        

        this.btnConnexion= new Button("Connexion");
        this.btnSkin= new Button("Skin");
        panelCentral.setLeft(this.btnSkin);
        panelCentral.setRight(btnConnexion);


        VBox vbox= new VBox();
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        this.btnLancer = new Button("Lancer la partie");
        vbox.getChildren().add(this.btnLancer);
        this.btnFermé= new Button("Quitter");
        btnFermé.setOnAction((ActionEvent event) ->{
            Platform.exit();
        });
        vbox.getChildren().add(this.btnFermé);
        
        vbox.setSpacing(50);
        this.panelCentral.setCenter(vbox);
        this.panelCentral.setPadding(new Insets(15, 12, 15, 12));
        
        
        
    }

    public void majAffichage() {
        
    }

    public void lancePartie(){
        pageAccueil();
        this.chrono.resetTime();
        this.chrono.start();
    }

    public Alert popUpPartieEnCours() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popUpReglesDuJeu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Règle du p4");
        alert.setContentText("PLACEZ LES JETONS SUR LES CASES EN BAS DE LA GRILLE ET AYEZ UNE LIGNE DE 4 POUR GAGNER");
        return alert;
    }

    public Alert popUpMessageGagne() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vous avez gagné !!!");
        this.chrono.stop();
        alert.setContentText("Félicitation");
        return alert;
    }

    public Alert popUpMessagePerdu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Perdu");
        this.chrono.stop();
        alert.setContentText(" Peut mieux faire");
        return alert;
    }

    

    @Override
    public void start (Stage stage){
        stage.setTitle("Puissance 4");
        stage.setScene(this.laScene());
        this.pageAccueil();
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}