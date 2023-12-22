package com.mobileAutomationFinalPractice.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviders {
    CredentialGenerator credentialGenerator = new CredentialGenerator();

    @DataProvider(name="credentials")
    public Object[][] createEmailData(){
        return  new Object[][]{
            {credentialGenerator.generateEmail(), credentialGenerator.getPassword()}
        };
    }
}
