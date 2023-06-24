package com.company.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Pedido")
public class Order extends Estimate implements Identificavel {


    private Long orderId;

    @Column(name = "pago")
    private Boolean paidOut;

    @Column(name = "data_pagamento")
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private PaymentOption paymentOption;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Estimate estimate, Long orderId, Date paymentDate, boolean paidOut, PaymentOption paymentOption, OrderStatus orderStatus) {
        super(estimate.getId(), estimate.getUser(), estimate.getCustomer(), estimate.getDate(), estimate.getOrderItems(), estimate.getObservations());
        this.paymentDate = paymentDate;
        this.paidOut = paidOut;
        this.paymentOption = paymentOption;
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }
    public Order(Estimate estimate, Date paymentDate, Boolean paidOut,
                 PaymentOption paymentOption, OrderStatus orderStatus) {
       super(estimate.getId(), estimate.getUser(), estimate.getCustomer(), estimate.getDate(),
               estimate.getOrderItems(), estimate.getObservations());
        this.paymentDate = paymentDate;
        this.paidOut = paidOut;
        this.paymentOption = paymentOption;
        this.orderStatus = orderStatus;
    }



    public Boolean getPaidOut() {
        return paidOut;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void  setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Long getId() {        return orderId;    }

    public void setOrderId(Long orderId) {        this.orderId = orderId;}
}