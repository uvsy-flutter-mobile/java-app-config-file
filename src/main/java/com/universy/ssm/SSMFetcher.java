package com.universy.ssm;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClient;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersResult;
import com.universy.parameters.ParameterName;

import java.util.List;

public class SSMFetcher {

    private final String stage;
    private final String region;
    private final String profile;

    public SSMFetcher(String stage, String region, String profile) {
        this.stage = stage;
        this.region = region;
        this.profile = profile;
    }

    public GetParametersResult fetch() {

        AWSSimpleSystemsManagement systemsManagement = AWSSimpleSystemsManagementClient.builder()
                .withRegion(region)
                .withCredentials(new ProfileCredentialsProvider(profile))
                .build();

        return systemsManagement.getParameters(new GetParametersRequest().withNames(getParameters(stage)));
    }

    private List<String> getParameters(String stage) {
        return ParameterName.getFormattedPaths(stage);
    }
}
