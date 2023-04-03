package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.models.InputInvoice;

import java.util.List;
import java.util.Optional;


public interface InputInvoiceService {
    List<InputInvoice> getAll();
    List<InputInvoice> getInputInvoicesByUserId(Long id);
    Optional<InputInvoice> getInputInvoiceById(Long id);
    InputInvoice save(InputInvoice outputInvoice);
    Optional<InputInvoice> update(Long id, InputInvoice outputInvoice);
    void delete(Long id);
}
