package Traitement;

import Traitement.Cluster2;
import Traitement.Instance;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.util.ArrayList;
import java.util.Random;

public class K_Medoids {

    public static void K_Medoids_Algorithme(int k, ArrayList<Instance> all_instances, JFXTextArea textArea, JFXTextField textField,JFXTextField cout){
        ArrayList<Instance> current_node = new ArrayList<Instance>();
        ArrayList<Cluster2> clusters = new ArrayList<>();
        ArrayList<Integer> instances_numbers=new ArrayList<>();

        Random rand= new Random();

        double starttime = System.currentTimeMillis();

        for (int md = 0; md < k; md++) {
            int r = rand.nextInt(all_instances.size());
            Instance inst = all_instances.get(r);
            current_node.add(inst);
            clusters.add(new Cluster2(md, inst));
        }
        int cp=1;
        double cost = 0;
        boolean change = true;
        while(change){

            change = false;
            cost = 0;
            for (int i = 0; i < k; i++) {
                clusters.get(i).elements.clear();
            }
            cost = fill_clusters(all_instances, current_node, k, cost, clusters, true);
            for (int md = 0; md < current_node.size(); md++) {

                int c = rand.nextInt(clusters.get(md).elements.size());
                Instance alt_med = clusters.get(md).elements.get(c);
                ArrayList<Instance> alt_node = new ArrayList<>(current_node);
                ArrayList<Cluster2> alt_clusters = new ArrayList<>();
                for (int l = 0; l < k; l++) {
                    if (l != md)
                        alt_clusters.add(new Cluster2(clusters.get(l).medoid_nb, clusters.get(l).medoid));
                    else
                        alt_clusters.add(new Cluster2(l, alt_med));
                }
                alt_node.set(md, alt_med);
                double cost2 = 0;
                cost2 = fill_clusters(all_instances, alt_node, k, cost2, alt_clusters, true);

                if (cost > cost2) {
                    cost = cost2;
                    current_node = alt_node;
                    clusters = alt_clusters;
                    change = true;
                }
            }
            textArea.appendText("==================== Iteration: "+cp+" ====================");
            textArea.appendText("\n");
            for (int j = 0; j < clusters.size(); j++) {
                textArea.appendText("Cluster "+ (j+1) + ": " );
                ArrayList<Double> d=new ArrayList<>();
                for(int f=0;f<clusters.get(j).medoid.size;f++){d.add(clusters.get(j).medoid.getAtt(f));}
                textArea.appendText("\n");
                textArea.appendText(("Instance K-medoids:"+" ===> "+ d+ "\n"));
                textArea.appendText("\n");
                textArea.appendText("Nombre d'instances :"+String.valueOf(clusters.get(j).elements.size()));
                textArea.appendText("\n");
                textArea.appendText("Liste d'instance : \n");

                for (int l = 0; l < clusters.get(j).elements.size() ; l++) {
                    instances_numbers.add(all_instances.indexOf(clusters.get(j).elements.get(l)));

                }
                textArea.appendText(String.valueOf(instances_numbers));
                textArea.appendText("\n");
                textArea.appendText("\n");
                instances_numbers.clear();

                }
                cp++;

        }

        textField.setText("" + (System.currentTimeMillis()-starttime) + "ms");

        cout.setText(" "+ cost);
    }

    public static double fill_clusters(ArrayList<Instance> all_instances, ArrayList<Instance> bestnodes,
                                       int k, double cost, ArrayList<Cluster2> clusters, boolean p){
        for (int i = 0; i < all_instances.size() ; i++) {
            boolean b = false;
            int m;
            for (m = 0; m < k; m++) {
                if(i == all_instances.indexOf(bestnodes.get(m))){
                    b = true; break;
                }
            }
            if(b)
                continue;

            double distance = all_instances.get(i).distanceEuc(bestnodes.get(0));
            int Cnum =0;
            for (m = 1; m < k; m++) {
                double dst = all_instances.get(i).distanceEuc(bestnodes.get(m));
                if(dst<distance){
                    distance = dst; Cnum = m;
                }
            }
            if (p) clusters.get(Cnum).elements.add(all_instances.get(i));
            cost = cost + distance;
        }
        return cost;
    }
}
