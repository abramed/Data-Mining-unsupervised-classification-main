package outils;

public class commentaire {

    /*
    public void graphHistogramme2(String nameAttr)
    {


        if(nameAttr.equals("thyroxin")) {

            graphe1.setCategoryGap(0);
            graphe1.setBarGap(0);


            ArrayList<Float> temp = new ArrayList<>();
            ArrayList<Integer> frequenceaa = new ArrayList();
            ArrayList<Float>values = new ArrayList();

            calcFrequenceaa(listrecu,nameAttr,temp,values,frequenceaa);
            ArrayList<Integer> freq_class = new ArrayList<>();
            ArrayList<String> key = new ArrayList<>();

            partitionData(values ,frequenceaa,key,freq_class);

            XYChart.Series series1 = new XYChart.Series();
            for (int i=0; i<key.size(); i++){
                series1.getData().add(new XYChart.Data(key.get(i), freq_class.get(i)));
            }


            //series1.setName("Numero de fichier");

            graphe1.getData().addAll(series1);
            Label labelAnimated1 = new Label();
            graphe1.setAnimated(false);
            graphe1.setLegendVisible(false);

        }else if(nameAttr.equals("triodothyronine")) {

            graphe2.setCategoryGap(0);
            graphe2.setBarGap(0);


            ArrayList<Float> temp = new ArrayList<>();
            ArrayList<Integer> frequenceaa = new ArrayList();
            ArrayList<Float>values = new ArrayList();

            calcFrequenceaa(listrecu,nameAttr,temp,values,frequenceaa);
            ArrayList<Integer> freq_class = new ArrayList<>();
            ArrayList<String> key = new ArrayList<>();

            partitionData(values ,frequenceaa,key,freq_class);

            XYChart.Series series1 = new XYChart.Series();
            for (int i=0; i<key.size(); i++){
                series1.getData().add(new XYChart.Data(key.get(i), freq_class.get(i)));
            }


            //series1.setName("Numero de fichier");

            graphe2.getData().addAll(series1);
            Label labelAnimated1 = new Label();
            graphe2.setAnimated(false);
            graphe2.setLegendVisible(false);

        }else if (nameAttr.equals("T3_resin")){



            graphe.setCategoryGap(0);
            graphe.setBarGap(0);


            ArrayList<Float> temp = new ArrayList<>();
            ArrayList<Integer> frequenceaa = new ArrayList();
            ArrayList<Float>values = new ArrayList();

            calcFrequenceaa(listrecu,nameAttr,temp,values,frequenceaa);
            ArrayList<Integer> freq_class = new ArrayList<>();
            ArrayList<String> key = new ArrayList<>();

            partitionData(values ,frequenceaa,key,freq_class);

            XYChart.Series series1 = new XYChart.Series();
            for (int i=0; i<key.size(); i++){
                series1.getData().add(new XYChart.Data(key.get(i), freq_class.get(i)));
            }


            //series1.setName("Numero de fichier");

            graphe.getData().addAll(series1);
            Label labelAnimated1 = new Label();
            graphe.setAnimated(false);
            graphe.setLegendVisible(false);

        }
        else if (nameAttr.equals("Total Serum thyroxin")){



            graphe3.setCategoryGap(0);
            graphe3.setBarGap(0);


            ArrayList<Float> temp = new ArrayList<>();
            ArrayList<Integer> frequenceaa = new ArrayList();
            ArrayList<Float>values = new ArrayList();

            calcFrequenceaa(listrecu,nameAttr,temp,values,frequenceaa);
            ArrayList<Integer> freq_class = new ArrayList<>();
            ArrayList<String> key = new ArrayList<>();

            partitionData(values ,frequenceaa,key,freq_class);

            XYChart.Series series1 = new XYChart.Series();
            for (int i=0; i<key.size(); i++){
                series1.getData().add(new XYChart.Data(key.get(i), freq_class.get(i)));
            }


            //series1.setName("Numero de fichier");

            graphe3.getData().addAll(series1);
            Label labelAnimated1 = new Label();
            graphe3.setAnimated(false);
            graphe3.setLegendVisible(false);

        }
        else if (nameAttr.equals("Total serum triiodothyronine")){



            graphe4.setCategoryGap(0);
            graphe4.setBarGap(0);


            ArrayList<Float> temp = new ArrayList<>();
            ArrayList<Integer> frequenceaa = new ArrayList();
            ArrayList<Float>values = new ArrayList();

            calcFrequenceaa(listrecu,nameAttr,temp,values,frequenceaa);
            ArrayList<Integer> freq_class = new ArrayList<>();
            ArrayList<String> key = new ArrayList<>();

            partitionData(values ,frequenceaa,key,freq_class);

            XYChart.Series series1 = new XYChart.Series();
            for (int i=0; i<key.size(); i++){
                series1.getData().add(new XYChart.Data(key.get(i), freq_class.get(i)));
            }


            //series1.setName("Numero de fichier");

            graphe4.getData().addAll(series1);
            Label labelAnimated1 = new Label();
            graphe4.setAnimated(false);
            graphe4.setLegendVisible(false);

        }

    }
    */

    /*
    public void press_btn_graphe() {

        if (((String)this.attributeGraph.getSelectionModel().getSelectedItem()).equals("thyroxin")) {


            attributeGraph1.setValue("thyroxin");
            graphePane1.toFront();
            graphe.toBack();
            graphePane.toBack();
            if(bolG1<=0) {
                graphHistogramme("thyroxin");
                bolG1++;
            }


        }else if(((String)this.attributeGraph.getSelectionModel().getSelectedItem()).equals("triodothyronine"))
        {
            attributeGraph2.setValue("triodothyronine");
            graphePane2.toFront();
            graphe.toBack();
            graphePane.toBack();
            if(bolG2<=0) {
                graphHistogramme("triodothyronine");
                bolG2++;
            }

        }
        else if(((String)this.attributeGraph.getSelectionModel().getSelectedItem()).equals("Total Serum thyroxin"))
        {
            attributeGraph3.setValue("Total Serum thyroxin");
            graphePane3.toFront();
            graphe.toBack();
            graphePane.toBack();
            if(bolG3<=0) {
                graphHistogramme("Total Serum thyroxin");
                bolG3++;
            }

        }
        else if(((String)this.attributeGraph.getSelectionModel().getSelectedItem()).equals("Total serum triiodothyronine"))
        {
            attributeGraph4.setValue("Total serum triiodothyronine");
            graphePane4.toFront();
            graphe.toBack();
            graphePane.toBack();
            if(bolG4<=0) {
                graphHistogramme("Total serum triiodothyronine");
                bolG4++;
            }

        }
        else if(((String)this.attributeGraph.getSelectionModel().getSelectedItem()).equals("T3_resin")){

            System.out.println("");
        }

    }

    public void press_btn_graphe1() {

        if (((String)this.attributeGraph1.getSelectionModel().getSelectedItem()).equals("thyroxin")) {

            System.out.println("");



        }else if(((String)this.attributeGraph1.getSelectionModel().getSelectedItem()).equals("triodothyronine"))
        {
            attributeGraph2.setValue("triodothyronine");
            graphePane2.toFront();
            graphePane1.toBack();
            graphe1.toBack();
            if(bolG2<=0) {
                graphHistogramme("triodothyronine");
                bolG2++;

            }

        }else if(((String)this.attributeGraph1.getSelectionModel().getSelectedItem()).equals("T3_resin"))
        {

            attributeGraph.setValue("T3_resin");
            graphePane.toFront();
            graphePane1.toBack();
            graphe1.toBack();

        }
        else if(((String)this.attributeGraph1.getSelectionModel().getSelectedItem()).equals("Total Serum thyroxin"))
        {
            attributeGraph3.setValue("Total Serum thyroxin");
            graphePane3.toFront();
            graphePane1.toBack();
            graphe1.toBack();
            if(bolG3<=0) {
                graphHistogramme("Total Serum thyroxin");
                bolG3++;

            }

        }
        else if(((String)this.attributeGraph1.getSelectionModel().getSelectedItem()).equals("Total serum triiodothyronine"))
        {
            attributeGraph4.setValue("Total serum triiodothyronine");
            graphePane4.toFront();
            graphePane1.toBack();
            graphe1.toBack();
            if(bolG4<=0) {
                graphHistogramme("Total serum triiodothyronine");
                bolG4++;

            }

        }

    }

    public void press_btn_graphe2() {

        if (((String)this.attributeGraph2.getSelectionModel().getSelectedItem()).equals("thyroxin")) {


            attributeGraph1.setValue("thyroxin");
            graphePane1.toFront();
            graphe2.toBack();
            graphePane2.toBack();
            if(bolG1<=0) {
                graphHistogramme("thyroxin");
                bolG1++;
            }


        }else if(((String)this.attributeGraph2.getSelectionModel().getSelectedItem()).equals("triodothyronine"))
        {
            System.out.println("");
        }
        else if(((String)this.attributeGraph2.getSelectionModel().getSelectedItem()).equals("T3_resin")){

            attributeGraph.setValue("T3_resin");
            graphePane.toFront();
            graphePane2.toBack();
            graphe2.toBack();

        }
        else if(((String)this.attributeGraph2.getSelectionModel().getSelectedItem()).equals("Total Serum thyroxin"))
        {
            attributeGraph3.setValue("Total Serum thyroxin");
            graphePane3.toFront();
            graphePane2.toBack();
            graphe2.toBack();
            if(bolG3<=0) {
                graphHistogramme("Total Serum thyroxin");
                bolG3++;

            }

        }
        else if(((String)this.attributeGraph2.getSelectionModel().getSelectedItem()).equals("Total serum triiodothyronine"))
        {
            attributeGraph4.setValue("Total serum triiodothyronine");
            graphePane4.toFront();
            graphePane2.toBack();
            graphe2.toBack();
            if(bolG4<=0) {
                graphHistogramme("Total serum triiodothyronine");
                bolG4++;

            }

        }

    }
    public void press_btn_graphe3() {

        if (((String)this.attributeGraph3.getSelectionModel().getSelectedItem()).equals("thyroxin")) {


            attributeGraph1.setValue("thyroxin");
            graphePane1.toFront();
            graphe3.toBack();
            graphePane3.toBack();
            if(bolG1<=0) {
                graphHistogramme("thyroxin");
                bolG1++;
            }


        }else if(((String)this.attributeGraph3.getSelectionModel().getSelectedItem()).equals("triodothyronine"))
        {
            attributeGraph2.setValue("triodothyronine");
            graphePane2.toFront();
            graphePane3.toBack();
            graphe3.toBack();
            if(bolG2<=0) {
                graphHistogramme("triodothyronine");
                bolG2++;

            }
        }
        else if(((String)this.attributeGraph3.getSelectionModel().getSelectedItem()).equals("T3_resin")){

            attributeGraph.setValue("T3_resin");
            graphePane.toFront();
            graphePane3.toBack();
            graphe3.toBack();

        }
        else if(((String)this.attributeGraph3.getSelectionModel().getSelectedItem()).equals("Total Serum thyroxin"))
        {
            System.out.println("");

        }
        else if(((String)this.attributeGraph3.getSelectionModel().getSelectedItem()).equals("Total serum triiodothyronine"))
        {
            attributeGraph4.setValue("Total serum triiodothyronine");
            graphePane4.toFront();
            graphePane3.toBack();
            graphe3.toBack();
            if(bolG4<=0) {
                graphHistogramme("Total serum triiodothyronine");
                bolG4++;

            }

        }

    }
    public void press_btn_graphe4() {

        if (((String)this.attributeGraph4.getSelectionModel().getSelectedItem()).equals("thyroxin")) {


            attributeGraph1.setValue("thyroxin");
            graphePane1.toFront();
            graphe4.toBack();
            graphePane4.toBack();
            if(bolG1<=0) {
                graphHistogramme("thyroxin");
                bolG1++;
            }


        }else if(((String)this.attributeGraph4.getSelectionModel().getSelectedItem()).equals("triodothyronine"))
        {
            attributeGraph2.setValue("triodothyronine");
            graphePane2.toFront();
            graphePane4.toBack();
            graphe4.toBack();
            if(bolG2<=0) {
                graphHistogramme("triodothyronine");
                bolG2++;

            }
        }
        else if(((String)this.attributeGraph4.getSelectionModel().getSelectedItem()).equals("T3_resin")){

            attributeGraph.setValue("T3_resin");
            graphePane.toFront();
            graphePane2.toBack();
            graphe2.toBack();

        }
        else if(((String)this.attributeGraph4.getSelectionModel().getSelectedItem()).equals("Total Serum thyroxin"))
        {
            attributeGraph3.setValue("Total Serum thyroxin");
            graphePane3.toFront();
            graphePane4.toBack();
            graphe4.toBack();
            if(bolG3<=0) {
                graphHistogramme("Total Serum thyroxin");
                bolG3++;

            }

        }
        else if(((String)this.attributeGraph4.getSelectionModel().getSelectedItem()).equals("Total serum triiodothyronine"))
        {
            System.out.println("");

        }

    }

     */

    /*
    public static void partitionData(ArrayList<Float> values ,ArrayList<Integer> frequenceaa, ArrayList<String> key, ArrayList<Integer> freq_class){
        float min = values.get(0);
        float max = values.get(values.size()-1);
        int k = (int) (1+(10/3)*Math.log10(max-min));
        System.out.println("le k est");
        System.out.println(k);
        int batchSize = values.size()/k;
        System.out.println("le batchSize est");
        System.out.println(batchSize);
        System.out.println("le size du vecteur est");
        System.out.println(values.size());




        for (int j=0;j<values.size();j+=batchSize) {
            int s = 0;int i =0;
                                   // j=0;j<99;i=0;i<19;
                                   // j=19;j<99;i=19;i<38;
                                   // j=38;j<99;i=38;i<57;
                                   // j=57;57<99;i=57;i<76;
                                   // j=76;76<99;i=76;i<95;
                                   // j=95;95<99;i=95;i<114
                i = j;k=j + batchSize;
                while (i < k && k<values.size()) {
                    s += frequenceaa.get(i);
                    i++;
                }
                if(k<values.size()) {
                    int born_min = values.get(j).intValue();
                    int born_max = values.get(j + batchSize - 1).intValue();
                    key.add("[" + born_min + "-" + born_max + "]");
                    freq_class.add(s);
                }

        }


    }

     */


}
