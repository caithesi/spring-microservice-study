package com.optimagrowth.license.service;

import java.util.Locale;
import java.util.Random;

import com.optimagrowth.license.config.ServiceConfig;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.repository.LicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.optimagrowth.license.model.License;

@Service
@AllArgsConstructor
public class LicenseService {
	
	private final MessageSource messages;
	private final LicenseRepository licenseRepository;
	private final ServiceConfig serviceConfig;

	public License getLicense(String licenseId, String organizationId){
		var license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId).get();
		return license.withComment(serviceConfig.property());
	}

	public String createLicense(License license, String organizationId, Locale locale){
		String responseMessage = null;
		if(!StringUtils.isEmpty(license)) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format(messages.getMessage("license.create.message",null,locale), license.toString());
		}

		return responseMessage;
	}

	public String updateLicense(License license, String organizationId){
		String responseMessage = null;
		if(!StringUtils.isEmpty(license)) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format(messages.getMessage("license.update.message", null, null), license.toString());
		}

		return responseMessage;
	}

	public String deleteLicense(String licenseId, String organizationId){
		String responseMessage = null;
		responseMessage = String.format(messages.getMessage("license.delete.message", null, null),licenseId, organizationId);
		return responseMessage;

	}

	public License getLicense(String organizationId, String licenseId, String clientType) {
		License license = new License();
		license.setOrganizationId(organizationId);
		license.setLicenseId(licenseId);
		Organization organization = retrieveOrganizationInfo(organizationId, clientType);
		if (organization != null) {
			license.setOrganizationName(organization.getName());
			license.setContactName(organization.getContactName());
			license.setContactEmail(organization.getContactEmail());
			license.setContactPhone(organization.getContactPhone());
		}
		return license;
	}

	public Organization retrieveOrganizationInfo(String organizationId,
												 String clientType){
		return new Organization();
	}
}
