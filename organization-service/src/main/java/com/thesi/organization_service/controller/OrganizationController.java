package com.thesi.organization_service.controller;

import com.thesi.organization_service.model.Organization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/organization/")
public class OrganizationController {
    @GetMapping("/{organizationId}")
    public Organization getById(@PathVariable("organizationId") String organizationId) {
        Organization organization = new Organization();
        organization.setId(organizationId);
        organization.setName("org name");
        organization.setContactEmail("o@m.com");
        organization.setContactName("si");
        organization.setContactPhone("000 000 000");


        return organization;
    }
}
