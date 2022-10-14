package sample;



import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import java.io.File;

import java.io.IOException;
import java.net.URL;

import java.util.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import org.jfree.data.general.Dataset;
import org.jfree.ui.RefineryUtilities;
import outils.*;



import static outils.TraitementData.*;

public class Controller implements Initializable {


    @FXML
    TableView<Row> table;
    @FXML
    TableView<Stat> tableStat;
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
    TableColumn moyenne;
    @FXML
    TableColumn mediane;
    @FXML
    TableColumn mode;

    @FXML
    AnchorPane accueil;
    @FXML
    VBox vbox1;

    @FXML
    VBox vbox2;

    @FXML
    private Label sizeInstance;
    @FXML
    private Label sizeAttribut;
    @FXML
    private Label sizeClass;

    @FXML
    private AnchorPane description;
    @FXML
    private AnchorPane stat;
    @FXML
    private StackPane home;

    @FXML
    private AnchorPane dispretionGraph;

    @FXML
    private AnchorPane graphePane;

    @FXML
    private JFXComboBox statAttribute;

    @FXML
    private JFXComboBox attributeGraph3;


    @FXML
    private JFXComboBox attribut1;

    @FXML
    private JFXComboBox attribut2;

    @FXML
    private AnchorPane CorrPane;

    @FXML
    TableView<CorrelationRow> tableCorrelation;
    @FXML
    TableColumn attribute_Correlation;
    @FXML
    TableColumn T3_resin_Correlation ;
    @FXML
    TableColumn thyroxin_Correlation ;
    @FXML
    TableColumn triodothyronine_Correlation;
    @FXML
    TableColumn TSH_Correlation ;
    @FXML
    TableColumn Max_TSH_Correlation ;

    @FXML
    TextField add_file;


    HistogrammeModel H;
    DispersionGraph D;


    ArrayList<ArrayList<Float>> listrecu;
    String path_file;
    int active=0;
    static BoxAndWhisker demo;
    int activeBAM=0;
    int activeHistogramme=0;
    int activeDispertion=0;





    public void importData()
    {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            active=1;
            //imageSelected.setText(selectedFile.getName());
            path_file=selectedFile.getPath();
            add_file.setText(selectedFile.getPath());
            System.out.println(selectedFile.getPath());


            table.setVisible(true);
            listrecu = TraitementData.RecupDonnees(path_file);
            sizeInstance.setText(String.valueOf(listrecu.size()));
            sizeAttribut.setText(String.valueOf(listrecu.get(0).size()-1));
            sizeClass.setText("3");


            ArrayList<Row> row = new ArrayList<>();
            for(ArrayList<Float> line : listrecu)
            {

                Row i = new Row(line);
                row.add(i);


            }


            ObservableList<Row> listObservable = FXCollections.observableArrayList(row);
            table.setItems(listObservable);


        } else {
            System.out.println("erreur de selection");
        }
    }






    public void retour() throws IOException {

        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }

        //primaryStage.initStyle(StageStyle.UNDECORATED);
        // définir et ouvrir la fenetre d'acceuil comme fenetre parent
        Parent parent = FXMLLoader.load(getClass().getResource("home.fxml"));
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





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        description.toBack();
        stat.toBack();
        graphePane.toBack();
        dispretionGraph.toBack();
        table.setVisible(false);
        home.toFront();




        statAttribute.getItems().addAll("T3_resin", "thyroxin","triodothyronine");
        statAttribute.setValue("T3_resin");

        attributeGraph3.getItems().addAll("T3_resin", "thyroxin","triodothyronine","thyroid-stimulating hormone","Maximal absolute difference of TSH");


        attribut1.getItems().addAll("T3_resin", "thyroxin","triodothyronine","thyroid-stimulating hormone","Maximal absolute difference of TSH");
        attribut2.getItems().addAll("T3_resin", "thyroxin","triodothyronine","thyroid-stimulating hormone","Maximal absolute difference of TSH");


        Class_attribute.setCellValueFactory(new PropertyValueFactory<>("Class_attribute"));
        T3_resin.setCellValueFactory(new PropertyValueFactory<>("T3_resin"));
        thyroxin.setCellValueFactory(new PropertyValueFactory<>("thyroxin"));
        triodothyronine.setCellValueFactory(new PropertyValueFactory<>("triodothyronine"));
        TSH.setCellValueFactory(new PropertyValueFactory<>("TSH"));
        Max_TSH.setCellValueFactory(new PropertyValueFactory<>("Max_TSH"));

        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        mediane.setCellValueFactory(new PropertyValueFactory<>("mediane"));
        mode.setCellValueFactory(new PropertyValueFactory<>("mode"));

        attribute_Correlation.setCellValueFactory(new PropertyValueFactory<>("attribute"));
        T3_resin_Correlation.setCellValueFactory(new PropertyValueFactory<>("T3_resin"));
        thyroxin_Correlation.setCellValueFactory(new PropertyValueFactory<>("thyroxin"));
        triodothyronine_Correlation.setCellValueFactory(new PropertyValueFactory<>("triodothyronine"));
        TSH_Correlation.setCellValueFactory(new PropertyValueFactory<>("TSH"));
        Max_TSH_Correlation.setCellValueFactory(new PropertyValueFactory<>("Max_TSH"));


    }


    /////

    public void BAM()
    {
        if(active==1) {
            ArrayList<ArrayList<Float>> listrecu = TraitementData.RecupDonnees(path_file);
            demo = new BoxAndWhisker(listrecu);
            //demo.setUndecorated(true);
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setBounds(480,137,760,560);
            demo.setAlwaysOnTop(true);
            demo.setVisible(true);
            activeBAM++;
            Main.stage.setTitle("Boite à moustache");


        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez importez le dataset d'abord!");
            alert.show();
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }



    }

    //////

    //////

    public void press_add() {
        ArrayList<Stat> listStat = new ArrayList();
        ArrayList<ArrayList<Float>> listrecu = TraitementData.RecupDonnees(path_file);

        if (((String)this.statAttribute.getSelectionModel().getSelectedItem()).equals("thyroxin")) {

            float x1 = CalculMoyenne(listrecu,"thyroxin");
            float x2 = CalculMediane(listrecu,"thyroxin");
            ArrayList<Float> x3 = CalculMod(listrecu,"thyroxin");
            String modlistSring = "[ ";
            int p=0;
            for (float mod : x3){
                modlistSring+=Float.toString(mod);
                if (p+1<x3.size()){
                    modlistSring+=", ";
                }
                p++;
            }
            modlistSring+=" ]";
            Stat stat = new Stat(Float.toString(x1), Float.toString(x2), modlistSring);
            listStat.add(stat);
            ObservableList<Stat> listObservable2 = FXCollections.observableArrayList(listStat);
            tableStat.setItems(listObservable2);

        }else if(((String)this.statAttribute.getSelectionModel().getSelectedItem()).equals("triodothyronine"))
        {
            float x1 = CalculMoyenne(listrecu,"triodothyronine");
            float x2 = CalculMediane(listrecu,"triodothyronine");
            ArrayList<Float> x3 = CalculMod(listrecu,"triodothyronine");


            String modlistSring = "[ ";
            int p=0;
            for (float mod : x3){
                modlistSring+=Float.toString(mod);
                if (p+1<x3.size()){
                    modlistSring+=", ";
                }
                p++;
            }
            modlistSring+=" ]";
            Stat stat = new Stat(Float.toString(x1), Float.toString(x2), modlistSring);
            listStat.add(stat);
            ObservableList<Stat> listObservable2 = FXCollections.observableArrayList(listStat);
            tableStat.setItems(listObservable2);
        }else {
            float x1 = CalculMoyenne(listrecu,"T3_resin");
            float x2 = CalculMediane(listrecu,"T3_resin");
            ArrayList<Float> x3 = CalculMod(listrecu,"T3_resin");

            String modlistSring = "[ ";
            int p=0;
            for (float mod : x3){
                modlistSring+=Float.toString(mod);
                if (p+1<x3.size()){
                    modlistSring+=", ";
                }
                p++;
            }
            modlistSring+=" ]";
            Stat stat = new Stat(Float.toString(x1), Float.toString(x2), modlistSring);

            listStat.add(stat);
            ObservableList<Stat> listObservable2 = FXCollections.observableArrayList(listStat);
            tableStat.setItems(listObservable2);
        }
    }


    public void affichDesprition() {
        if (!attribut1.getSelectionModel().isEmpty() && !attribut2.getSelectionModel().isEmpty()) {


            try {

                if(activeDispertion>0)
                {
                    D.frame.dispose();activeDispertion--;

                }

                if(!attribut1.getSelectionModel().getSelectedItem().equals(attribut2.getSelectionModel().getSelectedItem())) {
                    D = new DispersionGraph(listrecu, attribut1.getSelectionModel().getSelectedItem().toString(), attribut2.getSelectionModel().getSelectedItem().toString());
                    activeDispertion++;
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Alerte");
                    // Header Text: null
                    alert.setHeaderText(null);
                    alert.setX(750);
                    alert.setY(330);
                    alert.setContentText("Veuillez sellectionnez 2 attributs differents !");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(750);
            alert.setY(330);
            alert.setContentText("Veuillez sellectionnez les 2 attributs !");
            alert.show();
        }

        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }



    }

    public void graphHistogramme(String nameAttr)
    {

        double[] vector = new double[1];
        /*
        if(nameAttr.equals("Class_attribute")) {
            //histogram
            vector= new double[listrecu.size()];
            int i=0;
            for (ArrayList<Float> r : listrecu) {
                vector[i]=new Row(r).getClass_attribute();
                i++;
            }
            }

         */
        if(nameAttr.equals("thyroxin")) {
            //histogram
            vector= new double[listrecu.size()];
            int i=0;
            for (ArrayList<Float> r : listrecu) {
                vector[i]=new Row(r).getThyroxin();
                i++;
            }

        }else if(nameAttr.equals("triodothyronine")) {
            //histogram
            vector= new double[listrecu.size()];
            int i=0;
            for (ArrayList<Float> r : listrecu) {
                vector[i]=new Row(r).getTriodothyronine();
                i++;
            }

        }else if (nameAttr.equals("T3_resin")){

            //histogram
            vector= new double[listrecu.size()];
            int i=0;
            for (ArrayList<Float> r : listrecu) {
                vector[i]=new Row(r).getT3_resin();
                i++;
            }
        }else if (nameAttr.equals("thyroid-stimulating hormone")){

            //histogram
            vector= new double[listrecu.size()];
            int i=0;
            for (ArrayList<Float> r : listrecu) {
                vector[i]=new Row(r).getTSH();
                i++;
            }
        }else if (nameAttr.equals("Maximal absolute difference of TSH")){

            //histogram
            vector= new double[listrecu.size()];
            int i=0;
            for (ArrayList<Float> r : listrecu) {
                vector[i]=new Row(r).getMax_TSH();
                i++;
            }
        }
        int K = (int) (1+ (10/3)*java.lang.Math.log10(vector.length));

        H=new HistogrammeModel(nameAttr, vector, K);

    }

    public void changeHisto() {
        if (!attributeGraph3.getSelectionModel().isEmpty()) {
            try {
                if(activeHistogramme>0)
                {
                    H.frame.dispose();activeHistogramme--;
                }
                graphHistogramme((String) this.attributeGraph3.getSelectionModel().getSelectedItem());
                activeHistogramme++;

            } catch (Exception e) {e.printStackTrace();}

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(750);
            alert.setY(330);
            alert.setContentText("Veuillez sellectionnez un attribut d'abord!");
            alert.show();
        }
        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }



    }




    //////


    public void correlation()
    {
        if(active==1) {
            CorrPane.toFront();
            Main.stage.setTitle("Data correlation");
            ArrayList<CorrelationRow> correlationRows = new ArrayList<>();
            ArrayList<String> listAttr = new ArrayList<String>(Arrays.asList("T3_resin","thyroxin","triodothyronine","thyroid-stimulating hormone","Maximal absolute difference of TSH"));

            for (String attr1:listAttr){
                CorrelationRow i = new CorrelationRow(attr1);
                for (String attr2:listAttr){
                    float cc = coefficientCorrelation(listrecu,attr1,attr2);
                    i.setAttrOf(attr2,cc);
                }
                correlationRows.add(i);
            }

            ObservableList<CorrelationRow> listCorrObservable = FXCollections.observableArrayList(correlationRows);
            tableCorrelation.setItems(listCorrObservable);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez importez le dataset d'abord!");
            alert.show();
        }
        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }


    }
    public void descriptionData()
    {
        if(active==1) {
            description.toFront();
            Main.stage.setTitle("Data description");

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez importez le dataset d'abord!");
            alert.show();
        }
        if(activeBAM>0) {
            demo.dispose();
            activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }
    }
    public void home()
    {
        home.toFront();
        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }
        Main.stage.setTitle("Accueil");


    }
    public void statistique()
    {
        if(active==1) {
            stat.toFront();
            float x1 = CalculMoyenne(listrecu, statAttribute.getSelectionModel().getSelectedItem().toString());
            float x2 = CalculMediane(listrecu,statAttribute.getSelectionModel().getSelectedItem().toString());
            ArrayList<Float> x3 = CalculMod(listrecu, statAttribute.getSelectionModel().getSelectedItem().toString());
            ArrayList<Stat> listStat = new ArrayList();
            String modlistSring = "[ ";
            int p=0;
            for (float mod : x3){
                modlistSring+=Float.toString(mod);
                if (p+1<x3.size()){
                    System.out.println("Hellowfdfdfd");
                    modlistSring+=", ";
                }
                p++;
            }
            modlistSring+=" ]";
            Stat stat = new Stat(Float.toString(x1), Float.toString(x2), modlistSring);
            listStat.add(stat);
            ObservableList<Stat> listObservable2 = FXCollections.observableArrayList(listStat);
            tableStat.setItems(listObservable2);
            Main.stage.setTitle("Statistique");

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez importez le dataset d'abord!");
            alert.show();
        }
        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }
    }
    public void graphePane()
    {
        if(active==1) {
            graphePane.toFront();
            if(activeBAM>0) {
                demo.dispose();activeBAM--;
            }
            if(activeHistogramme>0)
            {
                H.frame.dispose();activeHistogramme--;
            }
            if(activeDispertion>0)
            {
                D.frame.dispose();activeDispertion--;
            }

            Main.stage.setTitle("Histogramme");


        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez importez le dataset d'abord!");
            alert.show();
        }


    }
    public void grapheDispersion() {
        if (active == 1) {
            dispretionGraph.toFront();
            if (activeBAM > 0) {
                demo.dispose();
                activeBAM--;
            }
            if(activeHistogramme>0)
            {
                H.frame.dispose();activeHistogramme--;
            }
            if(activeDispertion>0)
            {
                D.frame.dispose();activeDispertion--;

            }
            Main.stage.setTitle("Diagrammes de dispersion");

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            // Header Text: null
            alert.setHeaderText(null);
            alert.setX(630);
            alert.setY(360);
            alert.setContentText("Veuillez importez le dataset d'abord!");
            alert.show();
        }
    }



    public void exit()
    {
        if(activeBAM>0) {
            demo.dispose();activeBAM--;
        }
        if(activeHistogramme>0)
        {
            H.frame.dispose();activeHistogramme--;
        }
        if(activeDispertion>0)
        {
            D.frame.dispose();activeDispertion--;
        }
        Main.stage.close();

    }

}


