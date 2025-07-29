package com.optimagrowth.license.client;

import com.optimagrowth.license.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("organization-service")
public interface OrganizationFeign {
    @GetMapping(value = "/v1/organization/{organizationId}", consumes = "application/json")
    Organization getOrganizationById(
            @PathVariable("organizationId") String organizationId
    );
}
