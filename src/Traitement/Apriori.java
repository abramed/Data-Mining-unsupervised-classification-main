package Traitement;

import com.jfoenix.controls.JFXTextArea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Apriori {
	static TreeMap <String, Double> FreqItemSetMap = new TreeMap<String, Double>();
	static TreeMap <String, Double> AssociationRuleMap = new TreeMap<String, Double>();
	static TreeMap <Integer, ArrayList<String>> nonFreqItemSetMap = new TreeMap<Integer, ArrayList<String>>();
	static TreeMap <Integer, ArrayList<String>> prevFreqGroupsMap = new TreeMap<Integer, ArrayList<String>>();
	static ArrayList<String> listOfItems = new ArrayList<String>();
	static ArrayList<String> candidateItemSets = new ArrayList<String>();
	static HashMap<String , ArrayList<ArrayList<String>>> data= new HashMap<>();
	static String path;

	static double supportReq=0;
	static double confidenceReq=0;
	static String dataFile="";
	static int totalTransCount=0;
	static int maxDepthOfFreqSets=0;
		
	public static void getInputValues(){
		//***** Getting support & Confidence
		
		// create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);
	    
	    //Getting support
	    System.out.print("Enter Minimum Support in Percent: ");
	    supportReq = scanner.nextDouble();
	    
	    //Getting confidence
	    System.out.print("Enter Minimum Confidence in Percent: ");
	    confidenceReq = scanner.nextDouble();
	}
	
	//**** Getting Distinct Elements of Transaction Database
		public static void getDistinctTransactElem()    {
			
	        	//inputStream = new BufferedReader(new FileReader(dataFile));
	        	//String transReader; //File pointer for Transaction file
	    		data=getData();
	    		for(int i=0;i<data.get("Hypo").size();i++)
				 {
					 for(int j=0;j<data.get("Hypo").get(i).size();j++)
					 {
						 if(!listOfItems.contains(data.get("Hypo").get(i).get(j))){
	    					 listOfItems.add(data.get("Hypo").get(i).get(j));
	    				 }
						
					 }
					 totalTransCount++;
				 }
	    		for(int i=0;i<data.get("Hyper").size();i++)
				 {
					 for(int j=0;j<data.get("Hyper").get(i).size();j++)
					 {
						 if(!listOfItems.contains(data.get("Hyper").get(i).get(j))){
	    					 listOfItems.add(data.get("Hyper").get(i).get(j));
	    				 }
						
					 }
					 totalTransCount++;
				 }
	    		for(int i=0;i<data.get("Normal").size();i++)
				 {
					 for(int j=0;j<data.get("Normal").get(i).size();j++)
					 {
						 if(!listOfItems.contains(data.get("Normal").get(i).get(j))){
	    					 listOfItems.add(data.get("Normal").get(i).get(j));
	    				 }
						
					 }
					 totalTransCount++;
				 }
	    		Collections.sort(listOfItems);
	    		 
		}
		
		
		//**** Getting Single elements of Candidate Item sets
		public static ArrayList<String> getDistinctSingleElementsOfCandidateSet(ArrayList <String> prevFreqcandItems,int setDepth){
			ArrayList<String> distinctItemsList = new ArrayList<String>();
			for(int i=0;i<prevFreqcandItems.size();i++){
				String[] tempArray = prevFreqcandItems.get(i).split("-");
				for(String tItems:tempArray){
					 if(!distinctItemsList.contains(tItems)){
						 distinctItemsList.add(tItems);
					 }
				 }
			}// Outer for loop ends
			Collections.sort(distinctItemsList);
			return distinctItemsList;
		}
		
	//**** Getting Frequent Item sets
		public static void getFrequentItemSets(ArrayList <String> candidateItems,int totalItems,int setDepth, double supportReq) {
			ArrayList<String> tempFreqItemsList = new ArrayList<String>();
			ArrayList<String> tempNonFreqGroups = new ArrayList<String>();
			//***** Checking transactions for one item set
	   	 	//Loop through elements.
	   	 	
	   	 		for (int i = 0; i < candidateItems.size(); i++) {
	   	 			int countOccurence=0;
	   	 			double support=0;
	   	 			String value = candidateItems.get(i);
		 		   for(int x=0;x<data.get("Normal").size();x++)
					 {
						 for(int j=0;j<data.get("Normal").get(x).size();j++)
						 {
							 int elemOccurence=0;
							 String[] tempArray = value.split("-");
							 for(String tItems:tempArray){
			 						if(data.get("Normal").get(x).get(j).indexOf(tItems) != -1){	
				 		            	elemOccurence++;
									 }
			 					 } //for loop end
			 					if(elemOccurence==setDepth){
			 						countOccurence++;
			 					}
							
						 }
						 
					 }
		 		  for(int x=0;x<data.get("Hyper").size();x++)
					 {
						 for(int j=0;j<data.get("Hyper").get(x).size();j++)
						 {
							 int elemOccurence=0;
							 String[] tempArray = value.split("-");
							 for(String tItems:tempArray){
			 						if(data.get("Hyper").get(x).get(j).indexOf(tItems) != -1){	
				 		            	elemOccurence++;
									 }
			 					 } //for loop end
			 					if(elemOccurence==setDepth){
			 						countOccurence++;
			 					}
							
						 }
						 
					 }
		 		  
		 		 for(int x=0;x<data.get("Hypo").size();x++)
				 {
					 for(int j=0;j<data.get("Hypo").get(x).size();j++)
					 {
						 int elemOccurence=0;
						 String[] tempArray = value.split("-");
						 for(String tItems:tempArray){
		 						if(data.get("Hypo").get(x).get(j).indexOf(tItems) != -1){	
			 		            	elemOccurence++;
								 }
		 					 } //for loop end
		 					if(elemOccurence==setDepth){
		 						countOccurence++;
		 					}
						
					 }
					 
				 }
		 		 
		 		 
			    support=((double)countOccurence/(double)totalItems) * 100;
			    if(support >= supportReq){
		    	  tempFreqItemsList.add(value);
		    	  FreqItemSetMap.put(value, support); //adding support
			    }
			  
		 	 } //*** for loop ends
		 		 
			
	   	 	//Saving Non-Freq Groups
	   	 	tempNonFreqGroups=candidateItems;
	   	 	tempNonFreqGroups.removeAll(tempFreqItemsList);
	   	 	nonFreqItemSetMap.put(setDepth, tempNonFreqGroups);	
	   	 	// Saving Freq Groups
	   	 	prevFreqGroupsMap.put(setDepth, tempFreqItemsList);
		}
		
		
		
		//**** Start Candidate Item generation
	
 public static void startCandidateItemSetGen(){
	//Get Candidate Item Sets
 	candidateItemSets=listOfItems;
 	int totalElements=listOfItems.size();
	for(int i=1;i<=totalElements;i++){
   	 	ArrayList<String> depthListofItems = new ArrayList<String>(); // for holding distinct item sets at i-th depth
   	 	if(i>1){
   	 		depthListofItems=getDistinctSingleElementsOfCandidateSet(prevFreqGroupsMap.get(i-1),i);
   	 	}else{
   	 		depthListofItems=candidateItemSets;
   	 	}
		if(depthListofItems.size()>i){
			if(i>1){
 				String[] arr = new String[depthListofItems.size()];
 				for(int l = 0; l < depthListofItems.size(); l++) arr[l] = depthListofItems.get(l);
 				
 				//Getting Candidate Item Sets with non_freq superSets Removed
 				candidateItemSets.clear();
 				getCandidateItemSets(arr, i, 0, new String[i]);
			}
			//get Frequent Items sets
			getFrequentItemSets(candidateItemSets,totalTransCount,i,supportReq);
		}else{
			break;
		}
	} // Main for loop ends
 }

		//**** Getting Candidate Item sets
		
	 public static void getCandidateItemSets(String[] arr, int len, int startPosition, String[] result){
	       if (len == 0){
	        	//System.out.println("called");
	        	String cleme=String.join("-", result);
	        	int addFlag=1;
	        	int setDepth=result.length;
	        	if(setDepth>2){ //calling only if nonFreq has two element sets
	        		ArrayList<String> prevNonFreqList = new ArrayList<String>();
	        		String[] tempNonFreqSetElements;
	        		int ncCount=0;
	        		//*** Next removing supersets of non-freq sets
	        		for(int h=0;h<prevNonFreqList.size();h++){ // looping non-freq. array ABC etc
	        		  tempNonFreqSetElements=prevNonFreqList.get(h).split("-"); //Splittng each element of non freq AC or frigdeTV
	        		  for(String ncelem:tempNonFreqSetElements){
	        			  if(cleme.contains(ncelem)){
	        				  ncCount++;
	        			  }
	        		    } //For Loop ends
	            		 if(ncCount==(setDepth-1)){ //even if it is a superset of one neglect
	            			addFlag=0;
	            			break;
	            		 }
	            		 
	            	 }
		        	
	        	}//Super-Set check if closed
	        	if(addFlag==1){
	        		candidateItemSets.add(cleme);
	        	}
	        	return;
	        }       
	       
	        for (int i = startPosition; i <= arr.length-len; i++){
	            result[result.length - len] = arr[i];
	            getCandidateItemSets(arr, len-1, i+1, result);
	        }
	       
	    }
						  /*************************************
						  *********PRINTING ASSOCIATIONS********
						  *************************************/
	 
	 public static String[] permuteSets(int i) {
			int length = (int) Math.pow(2, i);
			length--;
			String temp = Integer.toBinaryString(length);
			length = temp.length();
			String[] arr = new String[(int) (Math.pow(2, i) - 2)];
			for (int j = 0; j < arr.length; j++) {

				arr[j] = Integer.toBinaryString(j + 1);
				int alen = length - arr[j].length();
				for (int k = 0; k < alen; k++) {
					arr[j] = "0".concat(arr[j]);
				}
			}
			return arr;
		}
	 public static void startPrintingAssoRules(){
		 try{
		 for(int j=2;j<=maxDepthOfFreqSets;j++){ //Outer Map
			 ArrayList<String> FreqItemsSetAssc = new ArrayList<String>();
			 FreqItemsSetAssc=prevFreqGroupsMap.get(j); // FreqItem set of depth j
			 String[] permutationsOfDepth;
			 permutationsOfDepth=permuteSets(j);
			 for(int indElemInSet=0;indElemInSet<FreqItemsSetAssc.size();indElemInSet++){
				 double confidence=0;
				 String[] FreqGroupElemSplit=FreqItemsSetAssc.get(indElemInSet).split("-");
				 for(int k=0;k<permutationsOfDepth.length;k++){ //Permutations
					 //Array for Left Strings
					 ArrayList<String> leftGroupAsso = new ArrayList<String>();
					 ArrayList<String> rightgroupAsso = new ArrayList<String>();
					 String leftGroup="";
					 String rightGroup="";
					 String[] elementsOfEachPermuteString;
					 elementsOfEachPermuteString=permutationsOfDepth[k].split("");
					 for(int l=0;l<elementsOfEachPermuteString.length;l++){ //Permuted Elements
						 if(elementsOfEachPermuteString[l].equals("0")){
							 leftGroupAsso.add(FreqGroupElemSplit[l]);
						 }else if(elementsOfEachPermuteString[l].equals("1")){
							 rightgroupAsso.add(FreqGroupElemSplit[l]);
						 }
					 } //Permuted Elements ForLoop ends
					 for(int m=0;m<leftGroupAsso.size();m++){
						 leftGroup+=leftGroupAsso.get(m)+"-";
					 }
					 for(int n=0;n<rightgroupAsso.size();n++){
						 rightGroup+=rightgroupAsso.get(n)+"-";
					 }
					 if (leftGroup != null && leftGroup.length() > 0 && leftGroup.charAt(leftGroup.length()-1)=='-') {
						 leftGroup = leftGroup.substring(0, leftGroup.length()-1);
					    }
					 if (rightGroup != null && rightGroup.length() > 0 && rightGroup.charAt(rightGroup.length()-1)=='-') {
						 rightGroup = rightGroup.substring(0, rightGroup.length()-1);
					    }
					 //**** Checking Confidence and add to TreeMap
					 confidence=FreqItemSetMap.get(FreqItemsSetAssc.get(indElemInSet))/FreqItemSetMap.get(leftGroup)*100;
					 if(confidence>confidenceReq){
						 AssociationRuleMap.put(leftGroup+"--->"+rightGroup, confidence);
					 }
				 	} //Permute ForLoop ends
			 } // Each Group of Freq Set Split loop
		 } //Outer Map ForLoop ends
		}catch(Exception e){
			//System.out.println("Exception in Assoc rule gen: "+ e.getMessage());
		}
	 }
	 
	 
	 
	 // classification des données du dataset
	 
	 public static HashMap<String, ArrayList<ArrayList<String>>> getData()
	 {
		 HashMap<String , ArrayList<ArrayList<String>>> DataSet =new HashMap<>();
		 ArrayList<ArrayList<String>> Class= new ArrayList<ArrayList<String>>();
		 ArrayList<ArrayList<String>> Class2= new ArrayList<ArrayList<String>>();
		 ArrayList<ArrayList<String>> Class3= new ArrayList<ArrayList<String>>();
			try{
				InputStream ips=new FileInputStream(path);
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				int i;
				ligne=br.readLine();
				while (ligne!=null && (ligne.startsWith("1")))// on recherche les lignes ou les attributs sont décris
				{
						ArrayList<String> List= new ArrayList<String>();
						
						String[] TabL=ligne.split(",");
						List.add(TabL[1]);
						List.add(TabL[2]);
						List.add(TabL[3]);
						List.add(TabL[4]);
						List.add(TabL[5]);
						Class.add(List);
						ligne=br.readLine();
						
				}
				DataSet.put("Normal", Class);
				while (ligne!=null && (ligne.startsWith("2")))// on recherche les lignes ou les attributs sont décris
				{
						ArrayList<String> List= new ArrayList<String>();
					    
						String[] TabL=ligne.split(",");
						List.add(TabL[1]);
						List.add(TabL[2]);
						List.add(TabL[3]);
						List.add(TabL[4]);
						List.add(TabL[5]);
						Class2.add(List);
						ligne=br.readLine();
						
				}
				DataSet.put("Hyper", Class2);
				while (ligne!=null && (ligne.startsWith("3")))// on recherche les lignes ou les attributs sont décris
				{
						
						ArrayList<String> List= new ArrayList<String>();
						String[] TabL=ligne.split(",");
						List.add(TabL[1]);
						List.add(TabL[2]);
						List.add(TabL[3]);
						List.add(TabL[4]);
						List.add(TabL[5]);
						Class3.add(List);
						ligne=br.readLine();
						
				}
				DataSet.put("Hypo", Class3);
				
				 br.close(); 
			}		
			
		catch (Exception e){
			System.out.println(e.toString());
		}
			/*
			//bining 
			 for(int i=0;i<DataSet.get("Normal").size();i++)
			 {
				 for(int j=0;j<DataSet.get("Normal").get(i).size();j++)
				 {
					 if(DataSet.get("Normal").get(i).get(j).contains(".")) 
					 {
						 String[] value=DataSet.get("Normal").get(i).get(j).split("\\.");
						 DataSet.get("Normal").get(i).set(j, value[0]);
					 }
					 
				 }
			 }
			 for(int i=0;i<DataSet.get("Hypo").size();i++)
			 {
				 for(int j=0;j<DataSet.get("Hypo").get(i).size();j++)
				 {
					 if(DataSet.get("Hypo").get(i).get(j).contains(".")) 
					 {
						 String[] value=DataSet.get("Hypo").get(i).get(j).split("\\.");
						 DataSet.get("Hypo").get(i).set(j, value[0]);
					 }
					
				 }
			 }
			 for(int i=0;i<DataSet.get("Hyper").size();i++)
			 {
				 for(int j=0;j<DataSet.get("Hyper").get(i).size();j++)
				 {
					 if(DataSet.get("Hyper").get(i).get(j).contains(".")) 
					 {
						 String[] value=DataSet.get("Hyper").get(i).get(j).split("\\.");
						 DataSet.get("Hyper").get(i).set(j, value[0]);
					 }
					 
				 }
			 }
			*/
			 return DataSet;
	 }
	 // fin de la procedure


	 public static String runAlgo(String path_file, float msp, float mcp){
	 	 String txt = "";
		 supportReq = msp;
		 confidenceReq = mcp;
		 //Getting Distinct Transaction Elements
		 path = path_file;
		 getDistinctTransactElem();

		 //Starting Candidate Item Set Generation
		 startCandidateItemSetGen();

		 //**** Printing Generated  Frequent Item Sets
		 txt = "*******************************************************************\n";
		 txt+="Frequent Item Sets in Increasing order of Set-Depth:\n";
		 txt+="*******************************************************************\n";
		 for (Map.Entry<Integer, ArrayList<String>> entry : prevFreqGroupsMap.entrySet()) {
			 maxDepthOfFreqSets++;
			 txt+="Set "+entry.getKey()+" : "+entry.getValue()+"\n";
		 }

		 txt+="*******************************************************************\n";
		 txt+="Frequent Item Sets with Support:\n";
		 txt+="*******************************************************************\n";
		 for (Map.Entry<String, Double> entry : FreqItemSetMap.entrySet()) {
			  txt+="ElementGroup: "+entry.getKey()+"; Support: "+entry.getValue()+"\n";
		 }

		 //**** if only One item sets Print no Association rule
		 if(maxDepthOfFreqSets==1){
			 txt+="No Association rules can be generated. Only one Item sets are Frequent\n";
		 }else if(maxDepthOfFreqSets>1){
			 //**** Starting Association Rule Printing
			 startPrintingAssoRules();
			 //Printing Rules
			 txt+="*******************************************************************\n";
			 txt+="Generated Association Rules:\n";
			 txt+="*******************************************************************\n";
			 for (Map.Entry<String, Double> entry : AssociationRuleMap.entrySet()) {
				 txt+="Association Rule: "+entry.getKey()+"; Confidence: "+entry.getValue()+"\n";
			 }

		 }
		return txt;
	 }

}




