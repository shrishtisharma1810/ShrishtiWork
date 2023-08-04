package ECommerce.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count=0;
		int maxTry=1;
		if(count<maxTry) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
