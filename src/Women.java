import java.util.List;

public class Women extends Population.Human {
    public static List<Women>women_list;
    public Women(String name, char type) {
        super(name, type);
    }

    public void birth(Women w){
        women_list.add(w);
    }

    public static void run(){

    }
}
