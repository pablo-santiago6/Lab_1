package orderedStructures;
import java.lang.Math;


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
		double value = this.firstValue();
		double exp =(double)( i - 1);
		double cF = Math.pow(this.commonFactor , exp);

		return value*cF;

	}

	public boolean equals(Geometric p){
		return (this.commonFactor == p.commonFactor && this.firstValue() == p.firstValue());
	}

}
