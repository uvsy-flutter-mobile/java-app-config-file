package com.universy.ssm;

import com.amazonaws.services.simplesystemsmanagement.model.GetParametersResult;
import com.amazonaws.services.simplesystemsmanagement.model.Parameter;
import com.universy.parameters.ParameterFiller;
import com.universy.parameters.Parameters;
import com.universy.parameters.ParametersProvider;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SSMParametersProvider implements ParametersProvider {

    private final String stage;
    private final String region;
    private final String profile;

    public SSMParametersProvider(String stage, String region, String profile) {
        this.stage = stage;
        this.region = region;
        this.profile = profile;
    }

    @Override
    public Parameters getParameters() {

        SSMFetcher ssmFetcher = new SSMFetcher(stage, region, profile);
        GetParametersResult getParametersResult = ssmFetcher.fetch();

        Map<String, String> parameterMap = getParameterValueMap(getParametersResult);

        Parameters parameters = new Parameters(stage);
        parameters.getFillers().forEach(parameterFiller -> Optional.of(parameterFiller)
                .map(ParameterFiller::getParamPath)
                .map(parameterMap::get)
                .ifPresent(parameterFiller.getParamConsumer()));
        return parameters;
    }

    private Map<String, String> getParameterValueMap(GetParametersResult getParametersResult) {
        return getParametersResult.getParameters().stream().collect(Collectors.toMap(
                Parameter::getName,
                Parameter::getValue
        ));
    }
}
