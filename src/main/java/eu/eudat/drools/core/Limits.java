package eu.eudat.drools.core;

public class Limits {
    private Long memory;
    private Long memorySwap;
    private Long CPUPeriod;
    private Long CPUQuota;
    private Long CPUShares;

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(Long memorySwap) {
        this.memorySwap = memorySwap;
    }

    public Long getCPUPeriod() {
        return CPUPeriod;
    }

    public void setCPUPeriod(Long CPUPeriod) {
        this.CPUPeriod = CPUPeriod;
    }

    public Long getCPUQuota() {
        return CPUQuota;
    }

    public void setCPUQuota(Long CPUQuota) {
        this.CPUQuota = CPUQuota;
    }

    public Long getCPUShares() {
        return CPUShares;
    }

    public void setCPUShares(Long CPUShares) {
        this.CPUShares = CPUShares;
    }

}
