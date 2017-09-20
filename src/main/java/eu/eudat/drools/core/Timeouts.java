package eu.eudat.drools.core;

public class Timeouts {
    private Long fileDownload;
    private Long checkInterval;
    private Long volumeInspection;
    private Long jobExecution;
    private Long dataStaging;
    private Long preparation;

    public Long getFileDownload() {
        return fileDownload;
    }

    public void setFileDownload(Long fileDownload) {
        this.fileDownload = fileDownload;
    }

    public Long getCheckInterval() {
        return checkInterval;
    }

    public void setCheckInterval(Long checkInterval) {
        this.checkInterval = checkInterval;
    }

    public Long getVolumeInspection() {
        return volumeInspection;
    }

    public void setVolumeInspection(Long volumeInspection) {
        this.volumeInspection = volumeInspection;
    }

    public Long getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(Long jobExecution) {
        this.jobExecution = jobExecution;
    }

    public Long getDataStaging() {
        return dataStaging;
    }

    public void setDataStaging(Long dataStaging) {
        this.dataStaging = dataStaging;
    }

    public Long getPreparation() {
        return preparation;
    }

    public void setPreparation(Long preparation) {
        this.preparation = preparation;
    }

}
