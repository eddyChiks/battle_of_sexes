package project;
import java.util.List;

public class Women extends Population.Human {
    public static int counter=1;
    public static List<Women>women_list;
    public Women(char type) {
        super("Woman ", type, counter);
        counter++;
    }

    public void birth(Women w){
        women_list.add(w);
    }

    public void run(){

    }
}
