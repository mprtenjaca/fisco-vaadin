package com.mcode.fisco.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcode.fisco.backend.enums.MeasureUnit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "service_details")
public class ServiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceDescription;
    @Enumerated(EnumType.STRING)
    private MeasureUnit measureUnit;
    private Integer amount;
    private Integer discount;
    private Integer taxRate;
    private BigDecimal price;
    private BigDecimal finalPrice;

//    @OneToOne(mappedBy = "serviceDetails")
//    @JoinColumn(name = "output_invoice_id")
//    @JsonIgnore
//    private OutputInvoice outputInvoice;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "output_invoice_id", referencedColumnName = "id")
//    private OutputInvoice outputInvoice;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
