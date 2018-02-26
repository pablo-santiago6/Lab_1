import java.lang.Math;
import java.util.Scanner;

public class area {

        public static void main(String[] args){

                Scanner sn = new Scanner(System.in);
                System.out.println("Enter radius of the circle: ");
                float radius = sn.nextFloat();
                System.out.println("The area is " + 3.14*radius*radius);
                sn.close();
        }

}

