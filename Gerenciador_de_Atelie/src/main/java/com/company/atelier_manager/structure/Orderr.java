package com.company.atelier_manager.structure;

public class Orderr extends Estimatee {
/*
    private final long orderId;
    private Date paymentDate;
    private boolean paidOut;
    private PaymentOption paymentOption;
    private OrderStatus orderStatus;
    public Orderr(Estimatee estimate, long orderId, Date paymentDate, boolean paidOut, PaymentOption paymentOption, OrderStatus orderStatus) {
        super(estimate.getId(), estimate.getUser(), estimate.getCustomer(), estimate.getDate(), estimate.getOrderItems(), estimate.getTotalPrice(), estimate.getObservations());
        this.paymentDate = paymentDate;
        this.paidOut = paidOut;
        this.paymentOption = paymentOption;
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }

    public Orderr(Estimatee estimate, Date paymentDate, boolean paidOut, PaymentOption paymentOption, OrderStatus orderStatus) {
        super(estimate.getId(), estimate.getUser(), estimate.getCustomer(), estimate.getDate(), estimate.getOrderItems(), estimate.getTotalPrice(), estimate.getObservations());
        this.paymentDate = paymentDate;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
    }*/
}
