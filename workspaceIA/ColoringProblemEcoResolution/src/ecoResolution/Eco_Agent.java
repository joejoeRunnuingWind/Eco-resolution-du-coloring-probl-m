package ecoResolution;

import java.util.*;

public abstract class Eco_Agent {
	

	private boolean sat;		
	
	abstract boolean satisfait();
	
	abstract void fuir(String s);
	
	abstract void attaquer();
	public Eco_Agent(){
		
	}
	

}
