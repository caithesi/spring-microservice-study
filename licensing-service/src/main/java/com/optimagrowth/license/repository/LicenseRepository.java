package com.optimagrowth.license.repository;

import com.optimagrowth.license.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Random;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    /**
     * skeleton implement for repository, will replace with real implement later with posgressql rdbms
     * @param organizationId
     * @param licenseId
     * @return
     */
    default Optional<License> findByOrganizationIdAndLicenseId(String organizationId, String licenseId) {
        License license = new License();
        license.setId(new Random().nextLong(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");

        return Optional.of(license);
    }
}
