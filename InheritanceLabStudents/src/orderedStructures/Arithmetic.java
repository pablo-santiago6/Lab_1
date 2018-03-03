package orderedStructures;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}


    public Arithmetic add(Arithmetic a) {
        return new Arithmetic(a.firstValue()+this.firstValue(),+ a.commonDifference+this.commonDifference);
    }


    public Arithmetic substract(Arithmetic a, Arithmetic b) {
        return null;
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
	
	public boolean equals(Arithmetic p){
		return (this.commonDifference == p.commonDifference && this.firstValue() == p.firstValue());
	}



}
