import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Jumper implements Comparable<Jumper>{

    private String name;
    private int points;
    private int lastJump;
    private ArrayList<Integer> lastVotes;
    private ArrayList<Integer> jumps;

    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.lastJump = 0;
        this.lastVotes = new ArrayList<Integer>();
        this.jumps = new ArrayList<Integer>();
    }

    public void addPoints(int value) {
        this.points += value;
    }

    public void addJump(int jump){
        this.jumps.add(jump);
    }
    
    public ArrayList<Integer> getJumps(){
        return this.jumps;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLJ(){
        return this.lastJump;
    }
    
    public ArrayList<Integer> getLV(){
        return this.lastVotes;
    }

    public void setLJLV(int value1, ArrayList<Integer> l){
        this.lastJump = value1;
        this.lastVotes = l;
    }
    
    public void calculatePoints(){
        Collections.sort(this.lastVotes);
        int result = this.lastJump + this.lastVotes.get(1) + this.lastVotes.get(2) +
                this.lastVotes.get(3);
        this.points += result;
    }
    
    @Override
    public int compareTo(Jumper jumper){
        return this.getPoints()-jumper.getPoints();
    }
    
    public String toString(){
        return this.name + " (" + this.points + " points)";
    }
}
