package com.binar.cinema.service;

import com.binar.cinema.dto.Invoice;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {
    Invoice getInvoiceById(Long orderId);
}
