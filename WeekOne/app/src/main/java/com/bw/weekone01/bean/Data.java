package com.bw.weekone01.bean;

public class Data {
   /* "commodityId": 109,
            "commodityName": "新款奢华镶钻镜面iphone xs max手机壳苹果7plusl软边时尚保护套",
            "masterPic"*/
   private String commodityId;
   private String commodityName;
   private String masterPic;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    @Override
    public String toString() {
        return "Data{" +
                "commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                '}';
    }
}
