package ecoResolution;

import java.util.Collections;

public class Console {

	public static void main(String[] arg){
		ColoringPro_EcoReso res = new ColoringPro_EcoReso();
		res.initialiser();
		res.afficher();
		int flagS = 1;
		for(int i=0;i<res.iteration;i++){
			System.out.print("iteration:");
			System.out.println(i);
			Collections.shuffle(res.arrayS);
			flagS = 1;
			for(int j=0;j<res.arrayS.size();j++){
			
				boolean bool =  res.arrayS.get(j).satisfait();
				System.out.println(bool);
				if(bool == false){
					flagS = 0;
					String couleurOccupee = res.arrayS.get(j).getCouleur();
					for(int k=0;k<res.arrayS.get(j).getDependances().size();k++){
						res.arrayS.get(j).getDependances().get(k).fuir(couleurOccupee);
					}
				}
			}
			//System.out.println(flagS);
			if(flagS == 1){
				break;
			}	
		}
		
		System.out.println("Apres la programmation");
		if(flagS == 0){
			System.out.println("Pas de solution convergente");
		}
		else{
			System.out.println("Trouver une solution");
			res.afficher();
		}
		
	}	
	
}
