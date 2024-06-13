import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Menu extends BorderPane{
    private Button btnLancer;
    private Button btnFermé;
    private Button  btnConnexion;
    private Button btnSkin;
    private Label text;
    private BorderPane panelCentral;
    private Chronometre chrono;

    /**
     * @param le stage que l'on met dans la scene
     */
    public Menu(Stage stage){
        this.btnFermé=new Button();
        this.btnLancer = new Button();
        this.btnConnexion = new Button();
        this.btnSkin = new Button();
        this.text= new Label();
        this.panelCentral= new BorderPane();
        this.chrono= new Chronometre();
        start(stage);
    }
    /**
     * @param le stage et le lancement
     */
    public void start(Stage stage){
        stage.setTitle("Puissance 4");
        stage.setScene(this.laScene());
        this.pageAccueil();
        stage.show();
    }
    /**
     * @return la scene de notre P4
     */
    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }
    /**
     * @return le panel du jeu(bandeau du haut)
     */
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

    /**
     * @return le panel de la page d'accueil 
     */
    private BorderPane pageAccueil(){
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
        return this.panelCentral;
    }
    /*lance la partie et le chrono */
    public void lancePartie(){
        pageAccueil();
        this.chrono.resetTime();
        this.chrono.start();
    }
    /*envoie un message d'alerte */
    public Alert popUpPartieEnCours() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
    /*envoie un message d'alerte */
    public Alert popUpReglesDuJeu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Règle du p4");
        alert.setContentText("PLACEZ LES JETONS SUR LES CASES EN BAS DE LA GRILLE ET AYEZ UNE LIGNE DE 4 POUR GAGNER");
        return alert;
    }
    /*envoie un message d'alerte */
    public Alert popUpMessageGagne() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vous avez gagné !!!");
        this.chrono.stop();
        alert.setContentText("Félicitation");
        return alert;
    }
    /*envoie un message d'alerte */
    public Alert popUpMessagePerdu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Perdu");
        this.chrono.stop();
        alert.setContentText(" Peut mieux faire");
        return alert;
    }
}