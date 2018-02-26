package orderedStructures;

public class Geometric extends Progression {

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() {
		current = current * commonFactor; 
		return current;
	}
	
	@Override 
	public String toString(){
		return "Geom(" + (int)this.firstValue() + "," + (int)this.commonFactor + ")";
		
	}
	
	@Override
	public double getTerm(int i){
		int q = 1;
		double value = this.firstValue();
		while(q < i){
			value = value*this.commonFactor;
			q++;
		}
		return value;

	}

}
