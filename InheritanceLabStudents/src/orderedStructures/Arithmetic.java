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
		double temp = (((double)i -1.0)*this.commonDifference);
		return value + temp;
		
	}
	
	@Override 
	public String toString(){
		return "Arith(" + (int)this.firstValue() + "," + (int)this.commonDifference + ")";
		
	}

}
