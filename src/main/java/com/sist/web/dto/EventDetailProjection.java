package com.sist.web.dto;

public interface EventDetailProjection {

    String getEventStartdate();
    String getEventEnddate();
    String getSponsor1();
    String getSponsor2();
    String getPlaytime();
    String getCharge();
    String getSpendtime();
    String getAgelimit();
    String getPrice();
    String getPriceInfo();

    Integer getInfo_id();
    Integer getContent_id();
    String getInfoname();
    String getInfotext();

    String getTitle();
    String getFirst_image();
    String getAddr1();
    Double getMapy();
    Double getMapx();
    String getTel();
}
