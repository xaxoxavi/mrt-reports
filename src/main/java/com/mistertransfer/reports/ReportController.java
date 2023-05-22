package com.mistertransfer.reports;

import com.mistertransfer.reports.domain.ReceiptData;
import com.mistertransfer.reports.domain.ReservationData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {

    @GetMapping("/generate-receipt")
    public ModelAndView generateReceipt(@RequestBody ReceiptData receiptData) {

        ModelAndView modelAndView = new ModelAndView("receipt-template");
        modelAndView.addObject("receiptNumber", receiptData.getReceiptNumber());
        modelAndView.addObject("datePaid", receiptData.getDatePaid());
        modelAndView.addObject("locataList", receiptData.getLocataList());
        modelAndView.addObject("amount", receiptData.getAmount());
        modelAndView.addObject("currency", receiptData.getCurrency());

        return modelAndView;
    }

    @GetMapping("/fill-template")
    public ModelAndView generateClientReceipt(@RequestBody ReservationData data) {
        ModelAndView modelAndView = new ModelAndView("client-receipt-template");
        modelAndView.addObject("reservationReferenceNumber", data.getReservationReferenceNumber());
        modelAndView.addObject("passengerName", data.getPassengerName());
        modelAndView.addObject("pickupDateAndTime", data.getPickupDateAndTime());
        modelAndView.addObject("meetAndGreet", data.getMeetAndGreet());
        modelAndView.addObject("flightDateAndTime", data.getFlightDateAndTime());
        modelAndView.addObject("pickupPoint", data.getPickupPoint());
        modelAndView.addObject("dropOff", data.getDropOff());
        modelAndView.addObject("dropOffAddress", data.getDropOffAddress());
        modelAndView.addObject("passengers", data.getPassengers());
        modelAndView.addObject("includedLuggage", data.getIncludedLuggage());
        modelAndView.addObject("vehicle", data.getVehicle());
        modelAndView.addObject("extras", data.getExtras());
        modelAndView.addObject("cancellationPolicy", data.getCancellationPolicy());
        modelAndView.addObject("whatsappChannel", data.getWhatsappChannel());

        return modelAndView;
    }
}
