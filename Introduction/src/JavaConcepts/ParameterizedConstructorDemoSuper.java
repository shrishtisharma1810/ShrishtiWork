package JavaConcepts;

public class ParameterizedConstructorDemoSuper {
	int i; // this is class variable
	public ParameterizedConstructorDemoSuper(int i) { //Parameter passed here is instance variable
		this.i=i;
		//this indicates current class variable
	}
	
	//Note that since we have defined parameterized constructor, we do not need to pass parameter to these methods explicitly
	public int multiplyTwo() {
		i=i*2;
		return i;
	}
	
	public int multiplyThree() {
		i=i*3;
		return i;
	}
}
