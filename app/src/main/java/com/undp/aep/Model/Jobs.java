package com.undp.aep.Model;

public class Jobs {
   public String jobName=""; //اسم العمل
   public String companyName=""; //الجهة
   public String jobPeriodFrom=""; //الفترة
    public String jobPeriodTo=""; //الفترة
    public   String leaveReasons=""; // اسباب ترك العمل

    public Jobs(){}

    public Jobs( String jobName, String companyName, String jobPeriodFrom, String jobPeriodTo, String leaveReasons) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.jobPeriodFrom = jobPeriodFrom;
        this.jobPeriodTo=jobPeriodTo;
        this.leaveReasons = leaveReasons;
    }

    @Override
    public String toString() {
        return
                jobName
                + companyName  + jobPeriodFrom + jobPeriodTo
                 + leaveReasons;
    }
}

