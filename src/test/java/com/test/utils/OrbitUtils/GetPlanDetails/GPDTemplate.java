package com.test.utils.OrbitUtils.GetPlanDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;


@Getter
@Accessors(fluent=true)
@Setter
@Builder(toBuilder = true)
public class GPDTemplate {

    public String schemeCode;
    public String reference;
    public String companyCode;
    public String planCategory;
    public String status;
    public String acceptanceDate;
    public String renewalDate;
    public String fee;
    public String excessAmount;
    public String firstName;
    public String surname;
    public String addressLine1;
    public String addressLine2;
    public String addressLine3;
    public String postCode;
}