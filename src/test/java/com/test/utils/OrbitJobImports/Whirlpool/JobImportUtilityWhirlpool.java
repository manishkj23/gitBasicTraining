package com.test.utils.OrbitJobImports.Whirlpool;

import au.com.bytecode.opencsv.CSVWriter;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JobImportUtilityWhirlpool {

    public JobImportWhirlpoolTemplate whirlpoolRecord;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public void createSetOfNewRepairRecord(String transactionType, String scheme, String planNo,String whpRefNo, String status,String apptDate) {
        this.whirlpoolRecord = JobImportWhirlpoolTemplate.builder()
                .transactionType(transactionType)
                .schemeCode(scheme)
                .planNumber(planNo)
                .repairUniqueID(whpRefNo)
                .appointmentRef(whpRefNo)
                .repairStatus(status)
                .engineerApptDate(apptDate)
                .build();
    }

    public JobImportWhirlpoolTemplate getWhirlpoolRecord() {
        return this.whirlpoolRecord;
    }

    @SneakyThrows
    public void createImportFile(String transactionType, String scheme, String planNo,String whpRefNo, String status, String totalRecords,String apptDate) {
//        boolean recordExist = false;
        try {
            createSetOfNewRepairRecord(transactionType,scheme,planNo,whpRefNo, status,apptDate);
            if (!getWhirlpoolRecord().planNumber().isEmpty()) {
//                    recordExist = true;
                File csvNewFile = new File(System.getProperty("user.dir") + "\\target\\importfile.csv");
                File file = new File(String.valueOf(csvNewFile));
                FileWriter outputfile = new FileWriter(file);
                CSVWriter writer = new CSVWriter(outputfile,CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER);
                // adding data to csv
                writer.writeNext(new String[]{"RecordType;RecordCount;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"});
                writer.writeNext(new String[]{"HEADER;INDE;GB;UTC;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"});
                writer.writeNext(new String[]{"RecordType;TransactionType;RepairUniqueID;SchemeCode;PlanNumber;RepairType;AuthorityNumber;RepairCustomerID;" +
                        "CustTitle;CustForenames;CustSurname;CustAddrLine1;CustAddrLine2;CustAddrLine3;CustAddrLine4;CustPostCode;CustFirstContactDate;" +
                        "CustContactEmail;CustContactHomePhone;CustContactMobile;CustomerApplianceUniqueID;ApplianceUniqueID;ApplicanceType;ApplianceManufacturer;" +
                        "ApplianceModel;ApplianceSerialNo;IMEI;AppliancePurchaseDate;IsApplianceFunctioning;FaultCode1;FaultCode1Desc;FaultCode2;FaultCode2Desc;" +
                        "FaultCode3;FaultCode3Desc;CustDescFault;DateApplianceWrittenOff;DateApplianceRepaired;DateApplianceDespatched;DateJobClosed;JobCompletionRef;" +
                        "DateFirstAppointment;TimeFirstAppointment;EngineerApptDate;EngineerApptFromTime;EngineerApptToTime;EngineerContactPhone;ApptNotes;" +
                        "AppointmentRef;VisitNo;PartsRequired;PartNumber;PartDesc;PartQuantity;PartsOrderedDate;PartsETADate;PartsRecdDate;PartsUsedDate;" +
                        "RepairStatus;RepairStatusChangedDateTime;RepairStatusChangeReason;RepairStatusNotes"});

                writer.writeNext(new String[]{whirlpoolRecord.toString().replaceAll("null","")});
                writer.writeNext(new String[]{"RecordType;RecordCount;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"});
                writer.writeNext(new String[]{"TRAILER;" + totalRecords + ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"});
                writer.close();
            } else {
                LOGGER.error("ERROR : Unable to create a record to process Whirlpool Job Import");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}