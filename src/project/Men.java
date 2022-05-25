package project;
import java.util.List;
import java.util.Random;

public class Men extends Population.Human {
    public static int counter=1;
    public static List<Men>men_list;
    public Men(char type) {
        super("project.Men ", type, counter);
        counter++;
    }

    public void birth(Men m){
        men_list.add(m);
    }

    public synchronized void run(){
        Random rand = new Random();
        try {
            for (int i =0;i<10;i++){
                if (isInterrupted()) throw new InterruptedException();
                sleep(rand.nextInt(40));
                Women couple = Women.w_queue.remove();
                couple.meeting(type);
            }
        }
        catch (InterruptedException e){

        }
    }
}
