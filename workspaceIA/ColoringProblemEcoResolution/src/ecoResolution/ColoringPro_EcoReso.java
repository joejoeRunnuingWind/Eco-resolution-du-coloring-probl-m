package ecoResolution;

import java.util.*;

public class ColoringPro_EcoReso extends Eco_Resolution {
	
	public Sommet s;
	public ArrayList<Sommet> arrayS;
	public int iteration;
	
	public void initialiser(){
		
		Scanner read = new Scanner(System.in);
		s = new Sommet();
		arrayS = new ArrayList<Sommet>();
		String couleurl;
		int id;
		int nombreCouleur;
		String couleur;
		ArrayList<String> listeCouleur = new ArrayList<String>();
		ArrayList<Sommet> sommetsDependants = new ArrayList<Sommet>();
		int idD;
		String flag = "N";
		System.out.println("Nombre de couleur");
		nombreCouleur = read.nextInt();
		System.out.println("Liste couleur");
		for(int n=0;n<nombreCouleur;n++ ){
			couleurl = read.next(); 
			listeCouleur.add(couleurl);
		}
		System.out.println("Nombre d'iterations");
		iteration = read.nextInt();		
		while(flag.equals("N")){
			System.out.println("sommet suivant:");
			System.out.println("id de sommet:");
			id = read.nextInt();
			couleur = listeCouleur.get(0);
			sommetsDependants = new ArrayList<Sommet>();
			s = new Sommet(id, couleur, sommetsDependants, listeCouleur, false);
			arrayS.add(s);
			System.out.println("Fin de graphe? Y/N");
			flag = read.next();
		}
		
		for(int i=0;i<arrayS.size();i++){
			System.out.print("Entrer les sommets depandents de ");
			System.out.println(arrayS.get(i).getId());
			String flagC = "c";
			while(flagC.equals("c")){
				idD = read.nextInt();
				arrayS.get(i).getDependances().add(arrayS.get(idD));
				//System.out.print(arrayS.get(i).getDependances().size());
				System.out.println("continuer/finir : c/f");
				flagC = read.next();
			}
			System.out.println("finir");
		}
		
	}
	
	public void afficher(){
		if(arrayS == null){
			System.out.print("pas de graphe");
		}
		//System.out.print(arrayS.size());
		for(int i=0; i<arrayS.size();i++){
			System.out.print("id:");
			System.out.println(arrayS.get(i).getId());
			System.out.print("couleur:");
			System.out.println(arrayS.get(i).getCouleur());
			if(arrayS.get(i).getDependances() == null){
				System.out.print("pas de sommet dependant");
			}
			//for(int j=0; j<arrayS.get(i).getDependances().size();j++){
				
				//System.out.println(arrayS.get(i).getDependances().get(j).getCouleur());
			//}
		}
		
	}

	public ColoringPro_EcoReso(){
		super();
	}

}
