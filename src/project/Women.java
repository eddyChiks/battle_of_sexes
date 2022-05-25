package project;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Women extends Population.Human {
    public static int counter=1;
    public static List<Women>women_list;
    public static Queue<Women> w_queue;
    public Women(char type) {
        super("Woman ", type, counter);
        counter++;
    }
    public synchronized void meeting(char type){
        Random rand = new Random();
        int r = rand.nextInt(2);
        if (r==0){
            Men man = new Men(type);
            Men.men_list.add(man);
        }
        else{
            Women woman = new Women(this.type);
            Women.women_list.add(woman);
        }
        notify();
    }

    public synchronized void run(){
        try {
            for (int i = 0; i < 10; i++) {
                if (isInterrupted()) throw new InterruptedException();
                w_queue.add(this);
                wait();
                System.out.println(getName()+": just met her love");
            }
        }
        catch(InterruptedException e){

        }

    }
}
