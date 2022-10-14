package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{

        //primaryStage.initStyle(StageStyle.UNDECORATED);
        // définir et ouvrir la fenetre d'acceuil comme fenetre parent
        Parent parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        // Sauvegarder la fenetre d'acceuil
        stage = primaryStage;
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setOnCloseRequest(e->e.consume());
        stage.setY(101.0);
        stage.setX(195.0);
        stage.setTitle("Accueil");
        stage.show();// le titre de la fenetre d'acceuil.
    }

    public static void main(String[] args) {
        launch(args);




    }
}
