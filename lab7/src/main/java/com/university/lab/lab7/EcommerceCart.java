/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab7;

/**
 *
 * @author waleeja
 */
public class EcommerceCart {
    private final PaymentMethod paymentMethod;
public EcommerceCart( PaymentMethod paymentMethod )
{
    this.paymentMethod=paymentMethod;
}
  public void checkout(double total) {
        if (paymentMethod.pay(total)) System.out.println("Order confirmed.\n");
        else System.out.println("Payment failed.\n");
    }
}


