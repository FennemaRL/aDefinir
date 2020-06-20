package com.Servify.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScopeManager {

    public static final List<ScopeService> SCOPE_SERVICES = new ArrayList<>();

    static {
        SCOPE_SERVICES.add(new ScopeService("CABA"));
        SCOPE_SERVICES.add(new ScopeService("GBASUR"));
        SCOPE_SERVICES.add(new ScopeService("GBANORTE"));
        SCOPE_SERVICES.add(new ScopeService("GBAESTE"));
        SCOPE_SERVICES.add(new ScopeService("GBAOESTE"));
    }

    public static List<ScopeService> scopes() {
        return SCOPE_SERVICES;
    }

    public static ScopeService getScope(String scope) throws InvalidScopeError {
        List<ScopeService> scopeServices = scopes().stream().filter(scopeService -> scopeService.getScopeName().equals(scope)).collect(Collectors.toList());
        assertNotEmpty(scopeServices,scope);
        return scopeServices.get(0);
    }

    private static void assertNotEmpty(List<ScopeService> scopeServices, String scope) throws InvalidScopeError{
        if (scopeServices.isEmpty()) {
            throw new InvalidScopeError(scope);
        }
    }
}
