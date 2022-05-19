import java.util.HashMap;
import java.util.List;

public class Population extends Thread {
    public static int counter;
    HashMap<Character,Integer> state;

    public void Population(){
        counter=0;
        state.put('F',0);
        state.put('P',0);
        state.put('C',0);
        state.put('S',0);
    }


    public static class Human {
        int xp;
        int id;
        char type;
        String name;

        public Human(String name, char type) {
        }

        public void Human(String name, char type) {
            this.name = name;
            this.type = type;
            xp=0;
            counter++;
        }
    }
}
