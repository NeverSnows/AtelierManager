package com.company.atelier_manager.structure;

import java.util.Date;
import java.util.List;

public class Estimate {
    private final long id;
    private User user;
    private Customer customer;
    private Date date;
    private List<OrderItem> orderItems;
    private double totalPrice;
    private String observations;

    public Estimate(long id, User user, Customer customer, Date date, List<OrderItem> orderItems, double totalPrice, String observations) {
        this.id = id;
        this.user = user;
        this.customer = customer;
        this.date = date;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.observations = observations;
        updateTotalPrice();
    }
    public Estimate(User user, Customer customer, Date date, List<OrderItem> orderItems, String observations) {
        this.id = -1;
        this.user = user;
        this.customer = customer;
        this.date = date;
        this.orderItems = orderItems;
        this.observations = observations;
        updateTotalPrice();
    }

    private void updateTotalPrice(){
        totalPrice = 0;
        for(OrderItem orderItem : orderItems){
            totalPrice += orderItem.getTotalPrice();
        }
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    //Novamente, getter atualisa o preço total, pois a referencia a lsita de itens enviada pelo getter pode ser alterada com .add() e .remove().
    public List<OrderItem> getOrderItems() {
        updateTotalPrice();
        return orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getObservations() {
        return observations;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        updateTotalPrice();
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //Funções de interface abaixo
    public String getCustomerName(){
        return customer.getName();
    }

    public String getUserName(){
        return user.getName();
    }
}
