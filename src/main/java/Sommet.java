import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private int num;
    private List<Sommet> enfants;
    private boolean marque;

    public Sommet (int num, List<Sommet> enfants){
        this.num = num;
        this.enfants = enfants;
        marque = false;
    }

    public Sommet (int num){
        this.num = num;
        enfants = new ArrayList<>();
        marque = false;
    }

    public int getNum() {
        return num;
    }

    public List<Sommet> getEnfants() {
        return enfants;
    }

    public void addEnfants (Sommet s){
        enfants.add(s);
    }

    public boolean isMarque() {
        return marque;
    }

    public void marque() {
        this.marque = true;
    }
}
