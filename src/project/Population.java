package project;
import java.util.*;

public class Population{
    public static final int A=5;
    public static final int B=20;
    public static final int C=3;
    public static int population;
    static HashMap<Character,Integer> state;
    static HashMap<Character,Integer>type_count;

    public Population(){
        population=0;
        state=new HashMap<>();
        state.put('F',0);
        state.put('P',0);
        state.put('C',0);
        state.put('S',0);
        type_count=new HashMap<>();
        type_count.put('F',0);
        type_count.put('P',0);
        type_count.put('C',0);
        type_count.put('S',0);
    }

    public void generate(String gender) {
        char types[] = new char[2];
        Random rand = new Random();
        if (gender == "Men") {
            types[0] = 'F';
            types[1] = 'P';
            for (int i = 0; i < 50; i++) {
                int r = rand.nextInt(2);
                Men man = new Men(types[r]);
            }
        }
        else {
            types[0] = 'C';
            types[1] = 'S';
            for (int i = 0; i < 50; i++) {
                int r = rand.nextInt(2);
                Women woman = new Women(types[r]);
            }
        }
    }

    public static void update_hp(Men m, Women w){
        if (m.type=='F' && w.type=='C'){
            w.hp+=A-B/2-C;
            m.hp+=A-B/2-C;
        }
        else if (m.type=='F' && w.type=='S'){
            w.hp+=A-B/2;
            m.hp+=A-B/2;
        }
        else if (m.type=='P' && w.type=='S'){
            w.hp+=A-B;
            m.hp+=A;
        }
        check_hp(m,w);
    }
    public static void check_hp(Men m,Women w){
        if (m.hp<1){
            m.interrupt();
        }
        if (w.hp<1){
            w.interrupt();
        }
    }


    public static class Human extends Thread{
        int hp;
        char type;
        String name;

        public Human(String gender, char type, int counter) {
            super(Main.group,"some");
            this.name = gender + counter;
            this.type = type;
            hp = 25;
            population++;
            type_count.replace(type,type_count.get(type)+1);
            int pop=0;
            for (Character c:type_count.keySet()){
                pop+=type_count.get(c);
            }
            for (Character c:state.keySet()) {
                state.replace(c, Math.round(type_count.get(c) * 100 / (float) pop));
            }
        }
    }
}
