package com.gfar.java.basics.thread.multithreading.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBean {
    private String appId;
    private long syncTime;
    private UserVO lastUser;
    private List<UserVO> userVOList = Collections.synchronizedList(new ArrayList<>());

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public long getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(long syncTime) {
        this.syncTime = syncTime;
    }

    public List<UserVO> getUserVOList() {
        return userVOList;
    }

    public void setUserVOList(List<UserVO> userVOList) {
        this.userVOList = userVOList;
    }

    public UserVO getLastUser() {
        return lastUser;
    }

    public void setLastUser(UserVO lastUser) {
        this.lastUser = lastUser;
    }
}
