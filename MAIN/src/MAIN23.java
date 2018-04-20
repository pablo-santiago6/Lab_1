import java.util.*;

public class MAIN23 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numPairs = sc.nextInt();

        ArrayList<Long> arr = new ArrayList<>();

        for (int i = 0; i < numPairs; i++) {
            arr.add(sc.nextLong());
        }

        numberedPairs result = Opairs(arr);
        ArrayList<Long[]> data = result.getPairs();
        System.out.println(result.getN());
        for (int i = 0; i < result.getN(); i++) {
            System.out.println(data.get(i)[0]+" "+data.get(i)[1]);
        }

    }
    public static class numberedPairs {
        private int n;

        public int getN() {
            return n;
        }


        public ArrayList<Long[]> getPairs() {
            return pairs;
        }

        public void addPair(Long x,Long y){
            pairs.add(new Long[]{x, y});
            this.n++;
        }

        private ArrayList<Long[]> pairs;
        numberedPairs(){
            this.n = 0;
            this.pairs = new ArrayList<>();
        }
    }

    public static numberedPairs Opairs(ArrayList<Long> input){
        numberedPairs pairs = new numberedPairs();
        if(input.size()<2)return pairs;
        if (input.size()==2 && (input.get(0) < input.get(1))){
            pairs.addPair(input.get(0),input.get(1));return pairs;}

        else if(input.get(0)< input.get(1)){
            pairs.addPair(input.get(0),input.get(1));
        }
        input.remove(0);
        numberedPairs pairsRec = Opairs(input);
        for (int i = 0; i < pairsRec.getN(); i++) {
            Long[] temp = pairsRec.getPairs().get(i);
            pairs.addPair(temp[0], temp[1]);
            }
        return pairs;
        }
}