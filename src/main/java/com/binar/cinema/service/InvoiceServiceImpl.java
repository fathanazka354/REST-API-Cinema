package com.binar.cinema.service;

import com.binar.cinema.dto.Invoice;
import com.binar.cinema.entity.Order;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    OrderService orderService;

    public Order getOrderById(Long orderId){
        return orderService.getOrderById(orderId);
    }

    @Override
    public Invoice getInvoiceById(Long orderId) {
        Invoice invoice = new Invoice();
        Order order = orderService.getOrderById(orderId);
        invoice.setFirstName(order.getCustomer().getFirstName());
        invoice.setCustomerId(order.getCustomer().getCustomerId());
        invoice.setSeatCode(order.getShowTimes().getSeat().getSeatCode());
        invoice.setCash(order.getPayment().getCash());
        invoice.setMovieName(order.getShowTimes().getMovie().getMovieName());
        invoice.setDateShowtime(order.getShowTimes().getDateShowtime());
        return invoice;
    }

//    public String invoice(){
//        JRBeanArrayDataSource jrBeanArrayDataSource = new JRBeanArrayDataSource(new Iterable[]{orderService.getAllOrder()});
//        Connection conn;
//        try {
//            System.out.println(jrBeanArrayDataSource.getData().length);
//            JasperReport compileManager =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/customer.jrxml"));
//            HashMap<String, Object> map = new HashMap<>();
////            JasperPrint jasperPrint = JasperFillManager.fillReport(compileManager, new HashMap<String, Object>(), conn);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(compileManager, map, jrBeanArrayDataSource);
//            System.out.println(jasperPrint);
//            JRPdfExporter exporter = new JRPdfExporter();
//
//            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//            exporter.setExporterOutput(
//                    new SimpleOutputStreamExporterOutput("customer.pdf"));
//
//            SimplePdfReportConfiguration reportConfig
//                    = new SimplePdfReportConfiguration();
//            reportConfig.setSizePageToContent(true);
//            reportConfig.setForceLineBreakPolicy(false);
//
//            SimplePdfExporterConfiguration exportConfig
//                    = new SimplePdfExporterConfiguration();
//            exportConfig.setMetadataAuthor("Fathan");
//            exportConfig.setEncrypted(true);
//            exportConfig.setAllowedPermissionsHint("PRINTING");
//
//            exporter.setConfiguration(reportConfig);
//            exporter.setConfiguration(exportConfig);
//
//            exporter.exportReport();
////            JasperExportManager.exportReportToPdfFile(jasperPrint, "customer.pdf");
//            return "generated";
//        } catch (JRException e) {
//            throw new RuntimeException(e);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }finally {
//
//        }
//    }
}
