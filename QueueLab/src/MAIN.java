import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MAIN {
	
	public static void main(String args[]){

		Queue<Integer[]> input = new LinkedList<>();
		Queue<Integer[]> processing = new LinkedList<>();
		ArrayList<Integer[]> terminatedJobs = new ArrayList<>();
		
		int time = 0;
		
		Scanner sc = new Scanner(System.in);
		int ix = 0;
		while(ix<7){
			Integer[] tempJob = {sc.nextInt(),sc.nextInt()};
			input.add(tempJob);
			ix++;
		}
		sc.close();
		
		while(!input.isEmpty() || !processing.isEmpty()){
			if(!processing.isEmpty()){
				Integer[] tempJob = processing.poll();
				
				if(tempJob[1] == 1){
					tempJob[0] = time;
					terminatedJobs.add(tempJob);
				}
				
				else {
					tempJob[1]--;
					processing.add(tempJob);
				}
			}
			
			if(!input.isEmpty() && input.peek()[0]==time){
				Integer[] tempJob = input.poll();
				processing.add(tempJob);
			}
			
			time++;
		}
	
		double sumOfTimes = 0.0;
		
		for(int i = 0;i < terminatedJobs.size();i++){
			sumOfTimes += terminatedJobs.get(i)[0];
		}
		double result = sumOfTimes/(terminatedJobs.size());
		System.out.println("Average Time in System is: "+result);
	}
}


