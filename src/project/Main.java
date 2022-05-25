package project;
import java.util.List;


public class Main {

    public static void main(String args[]){
        Population pop=new Population();
        List <Men> men = (List<Men>)(List<?>)pop.generate("Men");
        Men.men_list=men;
        List <Women> women = (List<Women>)(List<?>)pop.generate("Women");
        Women.women_list=women;
//        System.out.println(pop.state);
//        System.out.println(pop.population);

    }
}
