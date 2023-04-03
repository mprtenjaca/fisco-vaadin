package com.mcode.fisco.backend.dto;

import com.mcode.fisco.backend.enums.InvoiceType;
import com.mcode.fisco.backend.enums.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OutputInvoiceDTO {

    private Integer invoiceNumber;
    private InvoiceType invoiceType;
    private PaymentMethod paymentMethod;
    private LocalDateTime dateAndTime;
    private LocalDate deliveryDate;
}
