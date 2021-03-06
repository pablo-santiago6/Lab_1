package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		if(s.length() == 0) { return true; }
		SLLStack<Character> stack1 = new SLLStack<>();
		
		for(int i = 0; i< s.length();i++){
		
			char c = (s.charAt(i));
			
			if(Character.isLetter(c)){
			
				if(Character.isUpperCase(c)){
				
					stack1.push(c);
				}
				
				else if(stack1.isEmpty()) {
					return false;
				}
				
				else{
					char t = stack1.top();
					if(t == Character.toUpperCase(c))stack1.pop();
					else return false;
				}
			}
			else{
				return false;
			}
		}
		if(stack1.isEmpty())return true;
		else{
			if(stack1.top() == Character.toUpperCase(s.charAt(s.length()-1)))return true;
		}
		return false;
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		if(!this.isValidContent())return null;
		String result = new String();
		for(int i = 0; i < s.length();i++){
			if(Character.isUpperCase(s.charAt(i))) result+=("<"+s.charAt(i)+"\t");
			else result+=(s.charAt(i)+">"+"\t");
		}
		return result;
	}

}
