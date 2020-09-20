package com.Artless;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class ListenersTestNG implements ITestListener, IReporter {

    @Override
    public void onTestFailure(ITestResult result) {
        // skip all others methods in context


        // code that save screenshots of steps into a file or reproduce steps with screenshots
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {}

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    }

}
