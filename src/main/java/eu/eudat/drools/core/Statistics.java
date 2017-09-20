package eu.eudat.drools.core;

public class Statistics {
    private Integer userRunningJobs;
    private Integer totalRunningJobs;

    public Integer getUserRunningJobs() {
        return userRunningJobs;
    }

    public void setUserRunningJobs(Integer usersRunningJobs) {
        this.userRunningJobs = usersRunningJobs;
    }

    public Integer getTotalRunningJobs() {
        return totalRunningJobs;
    }

    public void setTotalRunningJobs(Integer totalRunningJobs) {
        this.totalRunningJobs = totalRunningJobs;
    }

}
