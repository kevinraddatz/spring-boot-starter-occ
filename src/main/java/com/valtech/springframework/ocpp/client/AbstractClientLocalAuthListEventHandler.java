package com.valtech.springframework.ocpp.client;

import eu.chargetime.ocpp.feature.profile.ClientLocalAuthListEventHandler;
import eu.chargetime.ocpp.model.localauthlist.GetLocalListVersionConfirmation;
import eu.chargetime.ocpp.model.localauthlist.GetLocalListVersionRequest;
import eu.chargetime.ocpp.model.localauthlist.SendLocalListConfirmation;
import eu.chargetime.ocpp.model.localauthlist.SendLocalListRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingBean(ClientLocalAuthListEventHandler.class)
public class AbstractClientLocalAuthListEventHandler implements ClientLocalAuthListEventHandler {

    public GetLocalListVersionConfirmation handleGetLocalListVersionRequest(GetLocalListVersionRequest getLocalListVersionRequest) {
        return null;
    }

    public SendLocalListConfirmation handleSendLocalListRequest(SendLocalListRequest sendLocalListRequest) {
        return null;
    }
}
