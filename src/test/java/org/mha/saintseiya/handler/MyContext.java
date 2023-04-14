package org.mha.saintseiya.handler;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class MyContext implements Context {

    @Override
    public String getAwsRequestId() {
        throw new UnsupportedOperationException("Unimplemented method 'getAwsRequestId'");
    }

    @Override
    public String getLogGroupName() {
        throw new UnsupportedOperationException("Unimplemented method 'getLogGroupName'");
    }

    @Override
    public String getLogStreamName() {
        throw new UnsupportedOperationException("Unimplemented method 'getLogStreamName'");
    }

    @Override
    public String getFunctionName() {
        throw new UnsupportedOperationException("Unimplemented method 'getFunctionName'");
    }

    @Override
    public String getFunctionVersion() {
        throw new UnsupportedOperationException("Unimplemented method 'getFunctionVersion'");
    }

    @Override
    public String getInvokedFunctionArn() {
        throw new UnsupportedOperationException("Unimplemented method 'getInvokedFunctionArn'");
    }

    @Override
    public CognitoIdentity getIdentity() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdentity'");
    }

    @Override
    public ClientContext getClientContext() {
        throw new UnsupportedOperationException("Unimplemented method 'getClientContext'");
    }

    @Override
    public int getRemainingTimeInMillis() {
        throw new UnsupportedOperationException("Unimplemented method 'getRemainingTimeInMillis'");
    }

    @Override
    public int getMemoryLimitInMB() {
        throw new UnsupportedOperationException("Unimplemented method 'getMemoryLimitInMB'");
    }

    @Override
    public LambdaLogger getLogger() {
        throw new UnsupportedOperationException("Unimplemented method 'getLogger'");
    }
    
}
