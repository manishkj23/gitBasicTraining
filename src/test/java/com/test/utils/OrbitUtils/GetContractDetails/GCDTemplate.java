package com.test.utils.OrbitUtils.GetContractDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;


@Getter
@Accessors(fluent=true)
@Setter
@Builder(toBuilder = true)
public class GCDTemplate {

    public String channelCode;
    public String channelGroupCode;
    public String companyCode;
    public String schemeCode;
    public String reference;
    public String PolicyStatus;
    public String StatusDescription;
    public String AcceptanceDate;
    public String RenewalDate;
    public String Fee;
    public String Initial;
    public String FirstName;
    public String Surname;
    public Object PreferredName;
    public String Title;
    public String Gender;
    public String MaritalStatus;
    public Date Dob;
    public Object Language;
    public Object HomeTel;
    public Object MobTel;
    public Object WorkTel;
    public String EmailAddr;
    public String EmailHome;
    public String EmailWork;
    public String AddressLine1;
    public String AddressLine2;
    public String AddressLine3;
    public String PostalCode;
}