package com.optimagrowth.license.model.resp;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.optimagrowth.license.model.License;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
public class RepresentationModelLicense extends RepresentationModel<RepresentationModelLicense> {
    @JsonUnwrapped
    private License license;
}
