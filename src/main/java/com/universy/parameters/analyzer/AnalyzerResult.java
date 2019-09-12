package com.universy.parameters.analyzer;

import java.util.List;
import java.util.Optional;

public class AnalyzerResult {
    private final List<String> missingParameters;

    public AnalyzerResult(List<String> missingParameters) {
        this.missingParameters = missingParameters;
    }

    public List<String> getMissingParameters() {
        return missingParameters;
    }

    public boolean isValid(){
        return Optional.ofNullable(missingParameters)
                .map(List::isEmpty)
                .orElse(Boolean.TRUE);
    }
}
