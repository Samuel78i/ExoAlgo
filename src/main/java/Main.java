import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public void main(String[] args){

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
    }
}
