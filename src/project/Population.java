package project;
import java.util.*;

public class Population{
    public static int population;
    HashMap<Character,Integer> state;

    public Population(){
        population=0;
        state=new HashMap<>();
        state.put('F',0);
        state.put('P',0);
        state.put('C',0);
        state.put('S',0);
    }

    public List<Human> generate(String gender) {
        List<Population.Human> humans = new ArrayList<>();
        char types[] = new char[2];
        Random rand = new Random();
        if (gender == "Men") {
            types[0] = 'F';
            types[1] = 'P';
            for (int i = 0; i < 50; i++) {
                int r = rand.nextInt(2);
                Men man = new Men(types[r]);
                humans.add(man);
                state.put(types[r],state.get(types[r])+1);
            }
        }
        else {
            types[0] = 'C';
            types[1] = 'S';
            for (int i = 0; i < 50; i++) {
                int r = rand.nextInt(2);
                Women woman = new Women(types[r]);
                humans.add(woman);
                state.put(types[r],state.get(types[r])+1);
            }
        }
        return humans;
    }


    public static class Human extends Thread{
        int xp;
        char type;
        String name;

        public Human(String gender, char type, int counter) {
            this.name = gender + counter;
            this.type = type;
            xp=0;
            population++;
        }
    }
}
