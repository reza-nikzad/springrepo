package com.reza.flightreservation.dto;


import com.reza.flightreservation.entity.Flight;

import java.util.Date;
public class ReservationRequest {
    private Long flightId;
    private String passengerFirstName;
    private String passengerLastName;
    private String passengerMiddleName;
    private String passengerEmail;
    private String passengerPhone;
    private String passengerCardName;
    private String passengerCardNo;
    private String expDate;
    private String cvv2;
    private String cCPass;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }
    public String getPassengerMiddleName() {
        return passengerMiddleName;
    }

    public void setPassengerMiddleName(String passengerMiddleName) {
        this.passengerMiddleName = passengerMiddleName;
    }
    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getPassengerCardName() {
        return passengerCardName;
    }

    public void setPassengerCardName(String passengerCardName) {
        this.passengerCardName = passengerCardName;
    }

    public String getPassengerCardNo() {
        return passengerCardNo;
    }

    public void setPassengerCardNo(String passengerCardNo) {
        this.passengerCardNo = passengerCardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getcCPass() {
        return cCPass;
    }

    public void setcCPass(String cCPass) {
        this.cCPass = cCPass;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "flightId=" + flightId +
                ", passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerMiddleName='" + passengerMiddleName + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                ", passengerPhone='" + passengerPhone + '\'' +
                ", passengerCardName='" + passengerCardName + '\'' +
                ", passengerCardNo='" + passengerCardNo + '\'' +
                ", expDate='" + expDate + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", cCPass='" + cCPass + '\'' +
                '}';
    }
}
