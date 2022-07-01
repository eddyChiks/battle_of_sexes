package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    public static double cos_sim(List<Integer>prev, HashMap<Character,Integer>h){
        List<Integer>current=new ArrayList<>();
        for(Character c : h.keySet()){
            current.add(h.get(c));
        }
        int sum=0;
        float norm_i=0;
        float norm_j=0;
        for(int i=0;i< current.size();i++){
            sum+=current.get(i)*prev.get(i);
            norm_i+=Math.pow(current.get(i),2);
            norm_j+=Math.pow(prev.get(i),2);
        }
        return sum/(Math.sqrt(norm_i)*Math.sqrt(norm_j));
    }
    public static List<Integer> copy(List<Integer> l){
        List<Integer>res=new ArrayList<>();
        for (Character c:Population.state.keySet()){
            res.add(Population.state.get(c));
        }
        return res;
    }

}
