package com.company.atelier_manager.structure;

import com.company.atelier_manager.structure.enums.OrderStatus;
import com.company.atelier_manager.structure.enums.PaymentOption;

import java.time.LocalDate;

public class Order extends Estimate{

    private final long orderId;
    private LocalDate deliveryDate;
    private boolean paidOut;
    private PaymentOption paymentOption;
    private OrderStatus orderStatus;
    public Order(Estimate estimate, long orderId, LocalDate deliveryDate, boolean paidOut, PaymentOption paymentOption, OrderStatus orderStatus) {
        super(estimate.getId(), estimate.getUser(), estimate.getCustomer(), estimate.getDate(), estimate.getOrderItems(), estimate.getTotalPrice(), estimate.getObservations());
        this.deliveryDate = deliveryDate;
        this.paidOut = paidOut;
        this.paymentOption = paymentOption;
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }

    public Order(Estimate estimate, LocalDate deliveryDate, boolean paidOut, PaymentOption paymentOption, OrderStatus orderStatus) {
        super(estimate.getId(), estimate.getUser(), estimate.getCustomer(), estimate.getDate(), estimate.getOrderItems(), estimate.getTotalPrice(), estimate.getObservations());
        this.deliveryDate = deliveryDate;
        this.paidOut = paidOut;
        this.paymentOption = paymentOption;
        this.orderStatus = orderStatus;
        this.orderId = -1;
    }

    //Ao acessar Order.getId() (proveniente do super), estaremos na verdade puxando o id do orçamento que gerou este pedido.
    //Decidi que era melhor manter o id original para referencias futuras.
    //
    //Nota: Mudar o nome do id de Estimate para estimateId seria possivel, mas não faria sentido da perspectiva de boas praticas,
    // pois ao criar a classe Estimate, ela nao "tem como saber" que sera extendida e que deve possuir um indentificador em seu id,
    // ja que partindo deste princípio, quase toda classe pode ser extendida por outra que tambem possui atributos com nomes conflitantes.
    public long getOrderId() {
        return orderId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isPaidOut() {
        return paidOut;
    }

    public void setPaidOut(boolean paidOut) {
        this.paidOut = paidOut;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}