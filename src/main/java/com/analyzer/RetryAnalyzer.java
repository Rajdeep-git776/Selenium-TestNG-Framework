package com.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int retry = 3;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<retry){
            counter++;
            return true;
        }

        return false;



    }
}
