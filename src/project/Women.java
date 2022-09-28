package project;
import java.util.*;

public class Women extends Population.Human {
    public static int counter=1;
    public static List<Women>women_list=new ArrayList<>();
    public static SynQueue w_queue=new SynQueue();
    public Women(char type) {
        super("Woman ", type, counter);
        counter++;
        women_list.add(this);
    }
    public synchronized void date(Men m){
        birth(m);
        notify();
    }

    public void birth(Men father) {
        Random rand = new Random();
        int r = rand.nextInt(2);
        if (r == 0) {
            Men man = new Men(father.type);
            man.start();
        } else {
            Women woman = new Women(this.type);
            woman.start();
        }
        Population.update_hp(father,this);
    }
    public synchronized void run(){
        try {
            for (int i=0;i<100;i++){
                if (isInterrupted()) throw new InterruptedException();
                w_queue.insert(this);
                sleep(15);
                wait();
            }
        }
        catch(InterruptedException e){

           //System.out.println(name+" is out of game!");
        }

    }
}
