package project;
import java.util.List;


public class Main {

    public static void main(String args[]){
        Population pop=new Population();
        List <Men> men = (List<Men>)(List<?>)pop.generate("Men");
        List <Men> women = (List<Men>)(List<?>)pop.generate("Women");
        System.out.println(pop.state);
        System.out.println(pop.population);
    }
}
