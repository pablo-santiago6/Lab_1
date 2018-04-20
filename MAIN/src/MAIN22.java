import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MAIN22 {

    public static void main(String args[]) {

        Queue<Integer[]> input = new LinkedList<>();
        Queue<Integer[]> processing = new LinkedList<>();
        ArrayList<Integer[]> terminatedJobs = new ArrayList<>();

        int time = 0;

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            int index =line.indexOf(",");
            Integer timeEntered = Integer.parseInt(line.substring(0,index));
            Integer processTime = Integer.parseInt(line.substring(index+2,line.length()));
            Integer[] tempJob = {timeEntered,processTime,0};
            input.add(tempJob);
        }

        while(!input.isEmpty() || !processing.isEmpty()){
            if(!processing.isEmpty()){
                Integer[] tempJob = processing.poll();

                tempJob[1]--;

                if(tempJob[1] == 0){
                    tempJob[2] = time;
                    terminatedJobs.add(tempJob);
                }

                else {
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
            int timeTaken = terminatedJobs.get(i)[2]-terminatedJobs.get(i)[0];
            sumOfTimes += timeTaken;
        }
        double result = sumOfTimes/terminatedJobs.size();
        System.out.println("Average Time in System is: "+result);
    }
}