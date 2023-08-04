package JavaConcepts;

public class ParameterizedConstructorDemo extends ParameterizedConstructorDemoSuper{
	int i; // this is class variable
	public ParameterizedConstructorDemo(int i) { //Parameter passed here is instance variable
		super(i);
		this.i=i;
		//this indicates current class variable
	}
	
	//Note that since we have defined parameterized constructor, we do not need to pass parameter to these methods explicitly
	public int increment() {
		i=i+1;
		return i;
	}
	
	public int decrement() {
		i=i-1;
		return i;
	}
}
