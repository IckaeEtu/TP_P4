import javafx.application.Application;
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

    @Override
    private void init() {
        this.btnFermé=new Button();
        this.btnLancer = new Button();
        this.btnConnexion = new Button();
        this.btnSkin = new Button();
        this.text= new Label();
        this.panelCentral= new BorderPane();
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

        Label l1 = new Label("Jeu du pendu");
        bp.setLeft(l1);

        HBox hb = new HBox();

        Button home = new Button();
        ImageView image1 = new ImageView("file:img/home.png");
        //home.setOnAction("");
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
        //info.setOnAction();
        info.setGraphic(image3);
        image3.setFitHeight(40);
        image3.setFitWidth(40);

        hb.getChildren().addAll(home, param, info);
        bp.setRight(hb);
        return bp;
    }


    private void pageAccueil(){
        Stage stage = new Stage();
        stage.setTitle("Puissance 4");

        

        BorderPane bpConnexion= new BorderPane();
        this.btnConnexion= new Button("Connexion");
        bpConnexion.setRight(this.btnConnexion);
        this.btnSkin= new Button("skin");
        panelCentral.setLeft(this.btnSkin);
        panelCentral.setTop(bpConnexion);


        VBox vbox= new VBox();
        Label text= new Label("Bienvenue sur le Puissance 4");
        vbox.getChildren().add(text);
        this.btnLancer = new Button("Lancer la partie");
        vbox.getChildren().add(this.btnLancer);
        this.btnFermé= new Button("quitter");
        vbox.getChildren().add(this.btnFermé);
        
    }

    public void majAffichage() {

    }

    @Override
    public void start (Stage stage){
        stage.setTitle("Puissance 4");
        stage.setScene(this.laScene());
        this.pageAccueil();
        stage.show();
    }
}