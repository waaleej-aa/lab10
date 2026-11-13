/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.university.lab.lab7t2;

/**
 *
 * @author waleeja
 */
public class Lab7t2 {

    public static void main(String[] args) {
        DataBox<String> nameBox = new DataBox<>("Ali Khan");
        DataBox<Integer> idBox = new DataBox<>(12345);

        String name = nameBox.getValue();   // no cast needed
        int id = idBox.getValue();
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        
    }
}
