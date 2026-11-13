/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab7t2;

/**
 *
 * @author waleeja
 */
public class DataBox<T> {
    private T value;

    public DataBox(T value) { this.value = value; }

    public T getValue() { return value; }
}

