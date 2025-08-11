package com.example.Insurance.Controller;


import java.time.LocalDate;

public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    private String Title;
    private String Description;
    private Long Userid;

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size, String Title, String Description, Long Userid) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
        this.Title=Title;
        this.Description=Description;
        this.Userid= Userid;
    }

    public UploadFileResponse(Long string, String fileDownloadUri, long size, LocalDate auditClaimDate, String reasonForClaim, LocalDate auditSettlementDate, String claimStatus, Long policyId) {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTitle(){
        return Title;
    }

    public void setTitle(String Title){
        this.Title=Title;
    }

    public String getDescription(){
        return Description;
    }

    public void setDescription(String Description){
        this.Description=Description;
    }

    public Long getUserid(){
        return Userid;
    }

    public void setUserid(Long Userid){
        this.Userid=Userid;
    }
}

