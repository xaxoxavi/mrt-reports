package com.mistertransfer.reports.domain;

import lombok.Data;

@Data
public class ReservationData {

    private String reservationReferenceNumber;
    private String passengerName;
    private String pickupDateAndTime;
    private String meetAndGreet;
    private String flightDateAndTime;
    private String pickupPoint;
    private String dropOff;
    private String dropOffAddress;
    private Passengers passengers;
    private String includedLuggage;
    private String vehicle;
    private String[] extras;

    @Data
    public static class Passengers {
        private int adults;
        private int children;
        private int infants;
    }
}
