package Listenter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub				

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub				

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub				

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.printf("Faiilure TC "+result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub				

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub				

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub				
        System.out.println("Pass TC: "+result.getName());
    }
}