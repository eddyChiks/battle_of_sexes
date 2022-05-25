package project;
import java.lang.invoke.TypeDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static double cos_sim(int[]i,int[]j){
        int sum=0;
        float norm_i=0;
        float norm_j=0;
        for(int k=0;k<i.length;k++){
            sum+=i[k]*j[k];
            norm_i+=Math.pow(i[k],2);
            norm_j+=Math.pow(j[k],2);
        }
        return sum/(Math.sqrt(norm_i)*Math.sqrt(norm_j));
    }

}
