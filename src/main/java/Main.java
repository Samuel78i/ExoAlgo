import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("example.txt"));
        String line = scanFile.nextLine();
        Sommet first = new Sommet(Integer.parseInt(line.substring(0, 1)));
        List<Sommet> allPastSommet = new ArrayList<>();
        allPastSommet.add(first);
        List<Sommet> allCurrentSommet = new ArrayList<>();
        while (scanFile.hasNext()){
            line = scanFile.nextLine();
            for(int i = 0; i<line.length(); i++){
                int compteurLecture = 0;
                int compteurEnfant = 0;
                int parseInt = Integer.parseInt(line.substring(compteurLecture, i));
                if(line.charAt(i) == ','){
                    Sommet s = new Sommet(parseInt);
                    allCurrentSommet.add(s);
                    allPastSommet.get(compteurEnfant).addEnfants(s);
                }
                if(line.charAt(i) == ';'){
                    Sommet s = new Sommet(parseInt);
                    allCurrentSommet.add(s);
                    allPastSommet.get(compteurEnfant).addEnfants(s);
                    compteurEnfant++;
                }
            }
            allPastSommet = allCurrentSommet;
            allCurrentSommet.clear();
        }
        scanFile.close();


        List<Sommet> pile = new ArrayList<>();
        List<Sommet> sommetMarque = new ArrayList<>();
        pile.add(first);
        while(!pile.isEmpty()){
            Sommet current = pile.get(pile.size() - 1);
            current.marque();
            sommetMarque.add(current);
            pile.remove(current);
            current.getEnfants().sort(Comparator.comparing(Sommet::getNum));
            pile.addAll(current.getEnfants());
        }
        for(Sommet mar : sommetMarque){
            System.out.println(mar.getNum());
        }
    }
}
