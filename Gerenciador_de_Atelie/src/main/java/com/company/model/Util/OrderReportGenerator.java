package com.company.model.Util;

import com.company.dao.EntityManager;
import com.company.model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderReportGenerator {
    private static final String REPORT_DIRECTORY = System.getProperty("user.home") + File.separator + "Downloads" + File.separator;

    public static void generateOrderReport(Order order) {
        StringBuilder reportContent = new StringBuilder();

        reportContent.append("Customer name: ").append(order.getCustomer().getName()).append("\n");
        reportContent.append("Payment date: ").append(order.getPaymentDate()).append("\n");
        reportContent.append("Was it paid out? ").append(order.getPaidOut()).append("\n\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_DIRECTORY + "order_report_" + order.getCustomer().getName() + ".txt"))) {
            writer.write(reportContent.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while generating the report: " + e.getMessage());
        }
    }
}
