import java.util.Scanner;

public class MAIN {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int input = (sc.nextInt());
		String ans;
		if(input!=1)ans = po2(input);
		else ans = "Yes";
		System.out.println(ans);
	}
	
	public static String po2( int input){
		if((input/2.0)==2)return "Yes";
		else if(input>2.0)return po2((int) (input/2.0));
		else return "No";
	}
}