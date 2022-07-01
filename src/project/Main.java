package project;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static ThreadGroup group=new ThreadGroup("ThreadGroup");
    public static void main(String args[]) throws InterruptedException {
        Population pop = new Population();
        pop.generate("Men");
        pop.generate("Women");
        List<Integer>prev_state=new ArrayList<>();
        prev_state=Utils.copy(prev_state);
        System.out.println("Initial state:"+Population.state+'\n');
        int it=1;
        for (int i = 0; i < Women.women_list.size(); i++) {
            Women.women_list.get(i).start();
        }
        for (int i = 0; i < Men.men_list.size(); i++) {
            Men.men_list.get(i).start();
        }
        while (Utils.cos_sim(prev_state,pop.state)<0.9999 || it==1) {
            prev_state = Utils.copy(prev_state);
            Thread.currentThread().sleep(200);
            System.out.println("Iteration " + it + ": " + Utils.cos_sim(prev_state, pop.state));
            it++;
        }

        for (int i = 0; i <50 ; i++) {
            group.interrupt();
        }
        Thread.currentThread().sleep(2000);
        System.out.println("\nFinal state:"+Population.state);
    }
}
