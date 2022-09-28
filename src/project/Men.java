package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Men extends Population.Human {
    public static int counter=1;
    public static List<Men>men_list=new ArrayList<>();
    public Men(char type) {
    super("Men ", type, counter);
        counter++;
        men_list.add(this);
    }

    public synchronized void run(){
        Random rand = new Random();
        try {
            for (int i=0;i<100;i++){
                if (isInterrupted()) throw new InterruptedException();
                sleep(rand.nextInt(40));
                Women couple = Women.w_queue.extract();
                couple.date(this);
            }
        }
        catch (InterruptedException e){
        }
    }
}
