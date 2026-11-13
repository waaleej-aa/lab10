/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab7;

/**
 *
 * @author waleeja
 */
public class JazzCashPayment implements PaymentMethod{
     public boolean pay(double amount){
        if(amount<=0)return false;
        System.out.println("Paid RS"+ amount+"using Jazz cash");
return true;}  }