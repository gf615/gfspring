package com.gfar.java.gateway.server.common;

public class GateConfiguration {
    private boolean nio = false;
    private Integer coreThreadSize;
    private Integer maxThreadSize;
    private Integer workQueueSize;
    private Integer threadTimeOut;

    public boolean isNio() {
        return nio;
    }

    public void setNio(boolean nio) {
        this.nio = nio;
    }

    public Integer getCoreThreadSize() {
        return coreThreadSize;
    }

    public void setCoreThreadSize(Integer coreThreadSize) {
        this.coreThreadSize = coreThreadSize;
    }

    public Integer getMaxThreadSize() {
        return maxThreadSize;
    }

    public void setMaxThreadSize(Integer maxThreadSize) {
        this.maxThreadSize = maxThreadSize;
    }

    public Integer getWorkQueueSize() {
        return workQueueSize;
    }

    public void setWorkQueueSize(Integer workQueueSize) {
        this.workQueueSize = workQueueSize;
    }

    public Integer getThreadTimeOut() {
        return threadTimeOut;
    }

    public void setThreadTimeOut(Integer threadTimeOut) {
        this.threadTimeOut = threadTimeOut;
    }
}
