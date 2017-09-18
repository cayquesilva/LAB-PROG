package minmax;

/**
 * @author David Félix
 */
public class MinMax {

    public static void main(String[] args) {
        
        int a,b,c,max,min;
        
        a=-9;
        b=9999;
        c=2;
        
        max=a;
        min=a;
        
        while(max<b || max<c){
            if(b>c){
                max = b;
            }else{
                max = c;
            }
        }
        while(min>b || min>c){
            if(b<c){
                min = b;
            }else{
                min = c;
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }  
}
