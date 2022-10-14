package sample;

import Traitement.DataSet;
import Traitement.Traitement;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Traitement.row2;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import Traitement.Instance;


import Traitement.*;



public class Controller2 implements Initializable {

        @FXML
        private AnchorPane description;

        @FXML
        private AnchorPane kmeansAnchor,kmedoidAnchor,clarans,aprioriAnchor,comparaisonAnchor;

        @FXML
        private StackPane home;

        private DataSet DataS;
        private DataSet Data;
        private String path_file;
        @FXML
        TextField add_file;
        @FXML
        JFXTextArea affich_kmeans,affich_kmeans1,affich_clarens,affich_apriori;

        @FXML
        JFXTextField nombre_cluster,nombre_cluster1,numlocal,max_neigbors,nombre_cluster2,cout2,cout1,cout,mcp,msp;

        @FXML
        JFXTextField temps_execution_cluster2,temps_execution_cluster1,temps_execution_cluster;

        @FXML
        TableView<Row> table;
        @FXML
        TableColumn Class_attribute;
        @FXML
        TableColumn T3_resin ;
        @FXML
        TableColumn thyroxin ;
        @FXML
        TableColumn triodothyronine ;
        @FXML
        TableColumn TSH ;
        @FXML
        TableColumn Max_TSH ;

        @FXML
        private Label sizeInstance;
        @FXML
        private Label sizeAttribut;
        @FXML
        private Label sizeClass;

        private int bolTest;


    @FXML
    private JFXComboBox attributeAlgo;


    ArrayList<Instance> all_instances;

    public void descriptionData()
        {
            if(bolTest==0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez importez le dataset d'abord!");
                alert.show();
            }else {
                description.toFront();
                sample.Main.stage.setTitle("Data description");
            }
        }
        public void getdata()
        {
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);

             all_instances = new ArrayList<Instance>();

            if (selectedFile != null) {

                table.setVisible(true);
                path_file=selectedFile.getPath();
                add_file.setText(selectedFile.getPath());

                Data= Traitement.RecupDonnees(path_file);
                sizeInstance.setText(String.valueOf(Data.getContenu().size()));
                sizeAttribut.setText(String.valueOf(Data.getContenu().get(0).getSet().size()-1));
                sizeClass.setText("3");

                ArrayList<Row> row = new ArrayList<>();
                for(row2 r: Data.getContenu())
                {
                    Row i = new Row(r.getSet());
                    row.add(i);
                    Instance inst = new Instance(r.getSet().get(0), r.getSet().get(1), r.getSet().get(2), r.getSet().get(3), r.getSet().get(4), r.getSet().get(5));
                    all_instances.add(inst);
                }

                ObservableList<Row> listObservable = FXCollections.observableArrayList(row);
                table.setItems(listObservable);
                bolTest++;
            }
        }
        public void affiche_kmeans()
        {
            if(bolTest==0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez importez le dataset d'abord!");
                alert.show();
            }else
            kmeansAnchor.toFront();
        }
        public void affiche_kmedoid()
        {
            if(bolTest==0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez importez le dataset d'abord!");
                alert.show();
            }else
            kmedoidAnchor.toFront();
        }
        public void affiche_home()
        {

            home.toFront();
        }
        public void affiche_clarans()
        {
            if(bolTest==0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez importez le dataset d'abord!");
                alert.show();
            }else
            clarans.toFront();
        }

        public void affiche_apriori()
        {
            if(bolTest==0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez importez le dataset d'abord!");
                alert.show();
            }else
                aprioriAnchor.toFront();
        }

        public void affiche_comparaison(){
                if(bolTest==0)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Alerte");
                    // Header Text: null
                    alert.setHeaderText(null);
                    alert.setX(630);
                    alert.setY(360);
                    alert.setContentText("Veuillez importez le dataset d'abord!");
                    alert.show();
                }else
                    comparaisonAnchor.toFront();
        }

        public void calculer()
        {
            double xx = 9999999.99;
            double [] min = new double[6];
            double [] max = new double[6];

            for (int i = 0; i < min.length; i++) {
                min[i] = xx;
                max[i] = -xx;
            }
            /*
            DataS=Data;
            long debut = System.currentTimeMillis();
            Kmeans.ClassificationKmeans(DataS,Integer.parseInt(nombre_cluster.getText()),affich_kmeans);
            temps_execution_cluster.setText(" "+((float)(System.currentTimeMillis()-debut)/1000)+"s");
             */
            K_Means.K_MEANS_ALgorithme(Integer.parseInt(nombre_cluster.getText()), min, max, all_instances,affich_kmeans,temps_execution_cluster,cout);
        }

        public void calculer2()
        {
            /*
            DataS=Data;
            long debut2 = System.currentTimeMillis();
            Kmedoids.ClassificationKmedoids(DataS, 2,affich_kmeans1);
            temps_execution_cluster1.setText(" "+((float)(System.currentTimeMillis()-debut2)/1000)+"s");
            */
            K_Medoids.K_Medoids_Algorithme(Integer.parseInt(nombre_cluster1.getText()), all_instances,affich_kmeans1,temps_execution_cluster1,cout1);

        }

        public void calculer3() throws IOException {


            Clarans.CLARANS_Algorithme(Integer.parseInt(nombre_cluster2.getText()), Integer.parseInt(numlocal.getText()), Integer.parseInt(max_neigbors.getText()), all_instances,affich_clarens,cout2,temps_execution_cluster2);
        }


        public void calculerApriori(){
        try {
            if (Float.parseFloat(msp.getText())>100){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez introduire un min sup < ou = à 100!");
                alert.show();
                return;
            }else if (Float.parseFloat(mcp.getText())>100) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerte");
                // Header Text: null
                alert.setHeaderText(null);
                alert.setX(630);
                alert.setY(360);
                alert.setContentText("Veuillez introduire un min conf < ou = à 100!");
                alert.show();
                return;
            }

            discritization dsc = new discritization();
            dsc.path = path_file;
            ArrayList<ArrayList<Float>> dataset = dsc.readDataset(dsc.path);
            // descritisation
            for(int i = 1 ; i <=5 ; i++) {
                ArrayList<ArrayList<Float>> column = dsc.getColumn(dataset, i);
                ArrayList<ArrayList<Float>> bined = dsc.bining(column, 8);
                dataset = dsc.smoothing(dataset, bined, i);
            }
            dataset = dsc.delDup(dataset);
            DataSet d = dsc.ConvertToAprioriData(dataset);

            //affich_apriori.setText(Apriori.runAlgo(path_file,Float.parseFloat(msp.getText()),Float.parseFloat(mcp.getText())));
            affich_apriori.setText(AprioriAlgo.ExtractionItems(d,Integer.parseInt(mcp.getText()),Integer.parseInt(msp.getText())));

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez introduire un nombre!");
            alert.show();
        }

        }

    public void retour() throws IOException {

        //primaryStage.initStyle(StageStyle.UNDECORATED);
        // définir et ouvrir la fenetre d'acceuil comme fenetre parent
        Parent parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parent);
        sample.Main.stage.setScene(scene);
        sample.Main.stage.show();
        sample.Main.stage.setResizable(false);

        // Sauvegarder la fenetre d'acceuil
        sample.Main.stage.setOnCloseRequest(e->e.consume());
        sample.Main.stage.setY(101.0);
        sample.Main.stage.setX(195.0);
        sample.Main.stage.setTitle("Accueil");
        sample.Main.stage.show();// le titre de la fenetre d'acceuil.
    }
    public void exit()
    {
        sample.Main.stage.close();
    }


    @FXML
    TableView<CompRow> table_comp;
    @FXML
    TableColumn k;
    @FXML
    TableColumn cout_algo;
    @FXML
    TableColumn temps_exe;


    public ArrayList<CompRow> comparaison(String method){
        ArrayList<CompRow> row = new ArrayList<>();
        ArrayList<Instance> all_instances_clone = (ArrayList<Instance>) all_instances.clone();
        for (int i = 2;i<6;i++){
            if (method.equals("Clrans")) {
                Clarans.CLARANS_Algorithme(i, 2, 4, all_instances_clone, affich_clarens, cout2, temps_execution_cluster2);
                row.add(new CompRow(
                                i,
                                cout2.getText(),
                                temps_execution_cluster2.getText()
                        )
                );
            }else if(method.equals("K-mediods")) {


                K_Medoids.K_Medoids_Algorithme(i, all_instances_clone, affich_kmeans1, temps_execution_cluster1, cout1);
                row.add(new CompRow(
                                i,
                                cout1.getText(),
                                temps_execution_cluster1.getText()
                        )
                );
            }else {
                double xx = 9999999.99;
                double [] min = new double[6];
                double [] max = new double[6];
                for (int j = 0; j < min.length; j++) {
                    min[j] = xx;
                    max[j] = -xx;
                }
                K_Means.K_MEANS_ALgorithme(i, min, max,
                        all_instances,
                        affich_kmeans,
                        temps_execution_cluster,
                        cout
                );
                row.add(new CompRow(
                                i,
                                cout.getText(),
                                temps_execution_cluster.getText()
                        )
                );
            }
        }
        affich_clarens.setText("");
        cout2.setText("");
        temps_execution_cluster2.setText("");
        affich_kmeans1.setText("");
        cout1.setText("");
        temps_execution_cluster1.setText("");
        affich_kmeans.setText("");
        cout.setText("");
        temps_execution_cluster.setText("");
        return row;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        attributeAlgo.getItems().addAll( "K-means","K-mediods","Clrans");
        attributeAlgo.setValue("K-means");

        table.setVisible(false);
        home.toFront();
        bolTest=0;

        Class_attribute.setCellValueFactory(new PropertyValueFactory<>("Class_attribute"));
        T3_resin.setCellValueFactory(new PropertyValueFactory<>("T3_resin"));
        thyroxin.setCellValueFactory(new PropertyValueFactory<>("thyroxin"));
        triodothyronine.setCellValueFactory(new PropertyValueFactory<>("triodothyronine"));
        TSH.setCellValueFactory(new PropertyValueFactory<>("TSH"));
        Max_TSH.setCellValueFactory(new PropertyValueFactory<>("Max_TSH"));


        k.setCellValueFactory(new PropertyValueFactory<>("k"));
        cout_algo.setCellValueFactory(new PropertyValueFactory<>("cout_algo"));
        temps_exe.setCellValueFactory(new PropertyValueFactory<>("temps_exe"));

    }

    @FXML
    void choiseMethod(ActionEvent actionEvent){
        ArrayList<CompRow> compRows = comparaison(attributeAlgo.getSelectionModel().getSelectedItem().toString());
        ObservableList<CompRow> listObs = FXCollections.observableArrayList(compRows);
        table_comp.setItems(listObs);
    }
}
