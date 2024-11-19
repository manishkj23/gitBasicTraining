package com.test.utils.OrbitJobImports.Whirlpool;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent=true)
@Builder(toBuilder = true)
public class JobImportWhirlpoolTemplate {

    @Builder.Default
    private String recordType = "BODY";

    @Builder.Default
    private String transactionType = "NEW REPAIR";

    @Builder.Default
    private String repairUniqueID = "123123123";// fakeRepairUniqueID;

    @lombok.NonNull
    private String schemeCode;
    @lombok.NonNull
    private String planNumber;
    @Builder.Default
    private String repairType="BREAKDOWN";
    @Builder.Default
    private String authorityNumber="";
    @Builder.Default
    private String repairCustomerID = "0053721623";
    @Builder.Default
    private String custTitle="MR";
    @Builder.Default
    private String custForenames="Fran";
    @Builder.Default
    private String custSurname="REPAIRPLUSONE";
    @Builder.Default
    private String custAddrLine1="2 test lane";
    private String custAddrLine2;
    private String custAddrLine3;
    private String custAddrLine4;
    @Builder.Default
    private String custPostCode="PE2 7AB";
    @Builder.Default
    private String custFirstContactDate="07-07-2022";//getCurrentDate();
    private String custContactEmail;
    private String custContactHomePhone;
    private String custContactMobile;
    @Builder.Default
    private String customerApplianceUniqueID="116916953";
    @Builder.Default
    private String applianceUniqueID="F035033";
    @Builder.Default
    private String applicanceType="AW";
    @Builder.Default
    private String applianceManufacturer="WHIRLPOOL";
    @Builder.Default
    private String applianceModel="WASHING MACHINE";
    private String applianceSerialNo;
    private String iMEI;
    @Builder.Default
    private String appliancePurchaseDate="01-09-2021";
    private String isApplianceFunctioning;
    @Builder.Default
    private String faultCode1="COT00059";
    @Builder.Default
    private String faultCode1Desc="ELECTRICAL LEAKAGE";
    @Builder.Default
    private String faultCode2="18715";
    @Builder.Default
    private String faultCode2Desc="Tripped house electrics - power cut-out";
    private String faultCode3;
    private String faultCode3Desc;
    private String custDescFault;
    private String dateApplianceWrittenOff;
    private String dateApplianceRepaired;
    private String dateApplianceDespatched;
    private String dateJobClosed;
    private String jobCompletionRef;
    @Builder.Default
    private String dateFirstAppointment="";//getCurrentDate();
    private String timeFirstAppointment;
    @Builder.Default
    private String engineerApptDate="";//getCurrentDate();
    @Builder.Default
    private String engineerApptFromTime="05:00";
    @Builder.Default
    private String engineerApptToTime="20:00";
    private String engineerContactPhone;
    private String apptNotes;
    @Builder.Default
    private String appointmentRef="123123123";//fakeRepairUniqueID;
    @Builder.Default
    private String visitNo="1";
    private String partsRequired;
    private String partNumber;
    private String partDesc;
    private String partQuantity;
    private String partsOrderedDate;
    private String partsETADate;
    private String partsRecdDate;
    private String partsUsedDate;
    @Builder.Default
    private String repairStatus="LIVE";
    private String repairStatusChangedDateTime;
    private String repairStatusChangeReason;
    private String repairStatusNotes;

    @Override
    public String toString() {
        return
                this.recordType + ";" +
                        this.transactionType + ";" +
                        this.repairUniqueID + ";" +
                        this.schemeCode + ";" +
                        this.planNumber + ";" +
                        this.repairType + ";" +
                        this.authorityNumber + ";" +
                        this.repairCustomerID + ";" +
                        this.custTitle + ";" +
                        this.custForenames + ";" +
                        this.custSurname + ";" +
                        this.custAddrLine1 + ";" +
                        this.custAddrLine2 + ";" +
                        this.custAddrLine3 + ";" +
                        this.custAddrLine4 + ";" +
                        this.custPostCode + ";" +
                        this.custFirstContactDate + ";" +
                        this.custContactEmail + ";" +
                        this.custContactHomePhone + ";" +
                        this.custContactMobile + ";" +
                        this.customerApplianceUniqueID + ";" +
                        this.applianceUniqueID + ";" +
                        this.applicanceType + ";" +
                        this.applianceManufacturer + ";" +
                        this.applianceModel + ";" +
                        this.applianceSerialNo + ";" +
                        this.iMEI + ";" +
                        this.appliancePurchaseDate + ";" +
                        this.isApplianceFunctioning + ";" +
                        this.faultCode1 + ";" +
                        this.faultCode1Desc + ";" +
                        this.faultCode2 + ";" +
                        this.faultCode2Desc + ";" +
                        this.faultCode3 + ";" +
                        this.faultCode3Desc + ";" +
                        this.custDescFault + ";" +
                        this.dateApplianceWrittenOff + ";" +
                        this.dateApplianceRepaired + ";" +
                        this.dateApplianceDespatched + ";" +
                        this.dateJobClosed + ";" +
                        this.jobCompletionRef + ";" +
                        this.dateFirstAppointment + ";" +
                        this.timeFirstAppointment + ";" +
                        this.engineerApptDate + ";" +
                        this.engineerApptFromTime + ";" +
                        this.engineerApptToTime + ";" +
                        this.engineerContactPhone + ";" +
                        this.apptNotes + ";" +
                        this.appointmentRef + ";" +
                        this.visitNo + ";" +
                        this.partsRequired + ";" +
                        this.partNumber + ";" +
                        this.partDesc + ";" +
                        this.partQuantity + ";" +
                        this.partsOrderedDate + ";" +
                        this.partsETADate + ";" +
                        this.partsRecdDate + ";" +
                        this.partsUsedDate + ";" +
                        this.repairStatus + ";" +
                        this.repairStatusChangedDateTime + ";" +
                        this.repairStatusChangeReason + ";" +
                        this.repairStatusNotes;

    }

}