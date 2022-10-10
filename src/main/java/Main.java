import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	List<Sommet> sommets;
    	
    	try {
			sommets = lecture("arbre.txt");
		} catch (IOException e) {
			System.err.println("Erreur dans l'ouverture du fichier.");
			return;
		}
    	List<Sommet> listFinal = new ArrayList<Sommet>();
    	List<Sommet> pile = new ArrayList<Sommet>();
    	
        for (Sommet sommet : sommets) {
			if (!sommet.isMarque()) {
		        pile.add(sommet);
		        while(!pile.isEmpty()){
		            Sommet current = pile.get(pile.size() - 1);
		            if (current.isMarque()) {
		            	pile.remove(current);
		            	continue;
		            }
		            
		            current.marque();
		            listFinal.add(current);
		            pile.remove(current);
		            
		            current.getEnfants().sort(Comparator.comparing(Sommet::getNum).reversed());
		            for (Sommet s : current.getEnfants()) {
						if (!s.isMarque()) {
							pile.add(s);
						}
					}
		        }
			}
		}
        for (Sommet sommet : listFinal) {
			System.out.print(sommet + " ");
		}
        
        
    }
    
    private static List<Sommet> lecture(String chemin) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(chemin));
        
        List<Sommet> sommets = new ArrayList<Sommet>();
        
        String line;
        while ((line = br.readLine()) != null) {
        	Scanner sc = new Scanner(line);
        	sc.useDelimiter(" ");
        	
        	int num = Integer.parseInt(sc.next());
        	
        	
        	Sommet s = getSommet(sommets, num);
        	if (s == null) {
        		s = new Sommet(num);
        		sommets.add(s);
        	}
        	
        	while(sc.hasNext()) {
        		num = Integer.parseInt(sc.next());
        		Sommet enfant = getSommet(sommets, num);
            	if (enfant == null) {
            		enfant = new Sommet(num);
            		sommets.add(enfant);
            	}
        		
            	s.addEnfants(enfant);
        	}
        	sc.close();
        }

        br.close();
        
        return sommets;
    }
    
    
    private static Sommet getSommet(List<Sommet> sommmets, int numSommet) {
    	for (Sommet sommet : sommmets) {
			if (sommet.getNum() == numSommet)
				return sommet;
		}
    	return null;
    }
}
