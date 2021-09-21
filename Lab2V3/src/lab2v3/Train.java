package lab2v3;
import java.util.ArrayList;

public class Train {
    private ArrayList<Wagon> wagons;
    
    public Train(){
        this.wagons = new ArrayList<>();
    }
    public Train(ArrayList<Wagon> c){
        this.wagons = new ArrayList<>(c);
    }
    
    public void addWagon(Wagon w){
        this.wagons.add(w);
    }
    
    public ArrayList<Wagon> getWagons(){
        return wagons;
    }
    
    public void remove(String type){
        int index = 0;
        for(int i = 0; i < wagons.size(); i++){
            Wagon w = wagons.get(i);
            if(w.getProductType().equals(type)) index = i;
        }
        wagons.remove(index);
    }
    public void remove(int index){
        wagons.remove(index);
    }
}
