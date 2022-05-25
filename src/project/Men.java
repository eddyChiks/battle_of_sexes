package project;
import java.util.List;

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

    public void run(){

    }
}
