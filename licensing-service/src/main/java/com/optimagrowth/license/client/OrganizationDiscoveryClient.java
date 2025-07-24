package com.optimagrowth.license.client;

import com.optimagrowth.license.model.Organization;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class OrganizationDiscoveryClient {
    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

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

        String serviceUri = String.format("%s/v1/organization/%s", instances.getFirst().getUri().toString(), organizationId);
        Organization restExchange = restTemplate.getForObject(serviceUri, Organization.class, organizationId);
        return restExchange;
    }

    public Organization getOrganizationByRest(String organizationId) {
        Organization restExchange = restTemplate.getForObject("http://organization-service/v1/organization/{organizationId}", Organization.class, organizationId);

        return restExchange;
    }
}
