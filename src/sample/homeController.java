package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {

    public void partieII() throws IOException {

        //primaryStage.initStyle(StageStyle.UNDECORATED);
        // définir et ouvrir la fenetre d'acceuil comme fenetre parent
        Parent parent = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene scene = new Scene(parent);
        Main.stage.setScene(scene);
        Main.stage.show();
        Main.stage.setResizable(false);

        // Sauvegarder la fenetre d'acceuil
        Main.stage.setOnCloseRequest(e->e.consume());
        Main.stage.setY(101.0);
        Main.stage.setX(195.0);
        Main.stage.setTitle("Accueil");
        Main.stage.show();// le titre de la fenetre d'acceuil.

    }

    public void partieI() throws IOException {

        //primaryStage.initStyle(StageStyle.UNDECORATED);
        // définir et ouvrir la fenetre d'acceuil comme fenetre parent
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(parent);
        Main.stage.setScene(scene);
        Main.stage.show();
        Main.stage.setResizable(false);

        // Sauvegarder la fenetre d'acceuil
        Main.stage.setOnCloseRequest(e->e.consume());
        Main.stage.setY(101.0);
        Main.stage.setX(195.0);
        Main.stage.setTitle("Accueil");
        Main.stage.show();// le titre de la fenetre d'acceuil.


    }

    public void exit()
    {
        sample.Main.stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
