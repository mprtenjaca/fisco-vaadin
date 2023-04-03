package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.models.OutputInvoice;

import java.util.List;
import java.util.Optional;

public interface OutputInvoiceService {
    List<OutputInvoice> getAll();
    List<OutputInvoice> getOutputInvoicesByUserId(Long id);
    Optional<OutputInvoice> getOutputInvoiceById(Long id);
    List<OutputInvoice> findByCustomerId(Long id);
    List<OutputInvoice> findByServiceModelId(Long id);
    OutputInvoice save(OutputInvoice outputInvoice);
    Optional<OutputInvoice> update(Long id, OutputInvoice outputInvoice);
    void delete(Long id);
}
