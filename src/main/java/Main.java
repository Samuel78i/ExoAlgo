import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void main(String[] args) throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("example.txt"));
        String line = scanFile.nextLine();

        while (scanFile.hasNext()){
            line = scanFile.nextLine();

        }
        scanFile.close();


        List<Sommet> pile = new ArrayList<>();
        List<Sommet> sommetMarque = new ArrayList<>();
        Sommet s = new Sommet(1);
        pile.add(s);
        while(!pile.isEmpty()){
            Sommet cur = pile.get(pile.size() - 1);
            cur.marque();
            sommetMarque.add(cur);
            pile.remove(cur);
            cur.getEnfants().sort(Comparator.comparing(Sommet::getNum));
            pile.addAll(cur.getEnfants());
        }
        for(Sommet mar : sommetMarque){
            System.out.println(mar.getNum());
        }
    }
}
