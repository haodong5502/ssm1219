package com.newer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;
import java.sql.Timestamp;


public class Member implements Serializable {
    private Integer mid;
    private String mname;
    private String mphone;
    private Integer mlevel;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp minTime;
    private String mcardNo;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public Integer getMlevel() {
        return mlevel;
    }

    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }

    public Timestamp getMinTime() {
        return minTime;
    }

    public void setMinTime(Timestamp minTime) {
        this.minTime = minTime;
    }

    public String getMcardNo() {
        return mcardNo;
    }

    public void setMcardNo(String mcardNo) {
        this.mcardNo = mcardNo;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mlevel=" + mlevel +
                ", minTime=" + minTime +
                ", mcardNo='" + mcardNo + '\'' +
                '}';
    }
}
