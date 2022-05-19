import java.util.List;

public class Men extends Population.Human {
    public static List<Men>men_list;
    public Men(String name, char type) {
        super(name, type);
    }

    public void birth(Men m){
        men_list.add(m);
    }

    public static void run(){

    }
}
