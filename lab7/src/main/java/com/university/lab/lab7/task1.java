/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab7;

/**
 *
 * @author waleeja
 */
public class task1 {
    public static void main(String[] args) {
        EcommerceCart cart1 = new EcommerceCart(new CreditCardPayment());
        cart1.checkout(2500.0);

        EcommerceCart cart2 = new EcommerceCart(new JazzCashPayment());
        cart2.checkout(1200.0);

        // Cart never knows the concrete type; any PaymentMethod works
        EcommerceCart cart3 = new EcommerceCart(amount -> {
            System.out.println("Paid Rs. " + amount + " via anonymous method");
            return true;
        });
        cart3.checkout(500.0);
    }
    
}
