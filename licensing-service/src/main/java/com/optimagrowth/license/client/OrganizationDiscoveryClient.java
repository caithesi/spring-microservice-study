package com.optimagrowth.license.client;

import com.optimagrowth.license.model.Organization;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class OrganizationDiscoveryClient {
    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplateCustom;
    private final RestTemplate restTemplate;
    private final OrganizationFeign organizationFeign;
    /**
     * call getOrganization using {@link DiscoveryClient}
     * <br/ >
     * this is just a proof of concept function, and not encourage on real project due to :
     * <br />
     * 1. do not take advantage of spring cloud client-side load balancer. Call directly to
     * {@link DiscoveryClient} -> user take responsibility to choose which returned server instance will be invoked
     * <br />
     * 2. too much work
     *
     * @param organizationId
     * @return
     */
    public Organization getOrganization(String organizationId) {

        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("organization-service");
        if (instances.isEmpty()) {
            return null;
        }
        log.info("found {} instance", instances.size());
        String serviceUri = String.format("%s/v1/organization/%s", instances.getFirst().getUri().toString(), organizationId);
        Organization restExchange = restTemplate.getForObject(serviceUri, Organization.class, organizationId);
        return restExchange;
    }

    public Organization getOrganizationByRest(String organizationId) {
        Organization restExchange = restTemplate.getForObject("http://organization-service/v1/organization/{organizationId}", Organization.class, organizationId);
        for (int i = 0; i < 100; i++) {
            Thread.ofVirtual().start(() -> {
                var x = restTemplateCustom.getForObject("http://organization-service/v1/organization/{organizationId}", Organization.class, organizationId);
                assert x != null;
                log.info(x.getContactEmail());
            });
        }
        return restExchange;
    }

    public Organization getOrganizationByFeign(String organizationId) {
        Organization restExchange = organizationFeign.getOrganizationById( organizationId);
        for (int i = 0; i < 100; i++) {
            Thread.ofVirtual().start(() -> {
                var x = organizationFeign.getOrganizationById( organizationId);
                assert x != null;
                log.info(x.getContactEmail());
            });
        }
        return restExchange;
    }
}
