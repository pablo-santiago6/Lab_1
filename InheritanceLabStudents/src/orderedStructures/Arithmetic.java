package orderedStructures;

public class Arithmetic extends Progression {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() {
		current = current + commonDifference; 
		return current;
	}
	
	@Override
	public double getTerm(int i){
		double value = this.firstValue();
		for (int j  = 0; j < i ; j++){
			value += this.commonDifference;
		}
		return value;
		
	}
	
	@Override 
	public String toString(){
		return "Arith(" + (int)this.firstValue() + "," + (int)this.commonDifference + ")";
		
	}

}
