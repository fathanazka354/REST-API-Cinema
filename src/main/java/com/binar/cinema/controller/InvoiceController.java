package com.binar.cinema.controller;

import com.binar.cinema.dto.Invoice;
import com.binar.cinema.service.InvoiceService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long orderId){
        return new ResponseEntity<>(invoiceService.getInvoiceById(orderId), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}/pdf")
    public String generatePdf(@PathVariable Long orderId){
        JRBeanArrayDataSource jrBeanArrayDataSource = new JRBeanArrayDataSource(new Invoice[]{invoiceService.getInvoiceById(orderId)});
        try {
            System.out.println(jrBeanArrayDataSource.getData().length);
            JasperReport compileManager =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/invoice.jrxml"));
            HashMap<String, Object> map = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileManager, map, jrBeanArrayDataSource);
            System.out.println(jasperPrint);
            JRPdfExporter exporter = new JRPdfExporter();

            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(
                    new SimpleOutputStreamExporterOutput("invoice.pdf"));

            SimplePdfReportConfiguration reportConfig
                    = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            SimplePdfExporterConfiguration exportConfig
                    = new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("Fathan");
            exportConfig.setEncrypted(true);
            exportConfig.setAllowedPermissionsHint("PRINTING");

            exporter.setConfiguration(reportConfig);
            exporter.setConfiguration(exportConfig);

            exporter.exportReport();
            return "generated";
        } catch (JRException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
