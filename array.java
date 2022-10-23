import java.util.*; 
 
public class Main { 
 
    static void reverse(Integer revArray[]) 
    { 
        Collections.reverse(Arrays.asList(revArray)); 
        System.out.println("Array after reversed:" + Arrays.asList(revArray)); 
    } 
 
     public static void main(String[] args) 
    { 
        Integer [] revArray = {1,3,5,7,9}; 
        System.out.println("The correct Array:" + Arrays.asList(revArray));
        reverse(revArray); 
    } 
}
