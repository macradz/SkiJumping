import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tournament {
    private ArrayList<Jumper> list;
    private int roundCounter;
    private Random random;
    
    public Tournament(){
        this.list =  new ArrayList<Jumper>();
        this.roundCounter = 1;
        this.random = new Random();
    }
    
    public void addJumper(Jumper jumper){
        list.add(jumper);
    }
    
    public int getRoundCounter(){
        return this.roundCounter;
    }
    
    public ArrayList<Jumper> getplayerList(){
        return this.list;
    }
    
    public void round(){
        sortPlayers(this.list);
        this.roundCounter++;
    }
    
    public void sortPlayers(ArrayList<Jumper> l){
        Collections.sort(l);
        for (Jumper jumper : l){
            randomizePoints(jumper);
        
        }
    }
   
    public void calculatePoints(){
       for (Jumper jumper : this.list){
           jumper.calculatePoints();
       } 
    }
    
    public void sort(){
        Collections.sort(this.list);
    }
    public void reverseSort(){
        sort();
        Collections.reverse(this.list);
    }
    public void randomizePoints(Jumper player){
        int value1= random.nextInt(60) + 60;
        player.addJump(value1);
        ArrayList<Integer> votes = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++){
            int vote = random.nextInt(10)+10;
            votes.add(vote);
        }
        player.setLJLV(value1, votes);
    }


}
