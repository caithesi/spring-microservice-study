package com.optimagrowth.license.controller;

import com.optimagrowth.license.client.OrganizationDiscoveryClient;
import com.optimagrowth.license.model.Organization;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/organization-call/{organizationId}/")
public class CallToOrganization {

    private final OrganizationDiscoveryClient organizationDiscoveryClient;

    @GetMapping("/discovery-client")
    public ResponseEntity<Organization> byDiscoveryClient(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(organizationDiscoveryClient.getOrganization(organizationId));
    }

    @GetMapping("/rest-template")
    public ResponseEntity<Organization> byRestTemplate(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(organizationDiscoveryClient.getOrganizationByRest(organizationId));
    }

    @GetMapping("/feign")
    public ResponseEntity<Organization> byFeign(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(organizationDiscoveryClient.getOrganizationByRest(organizationId));
    }
}
