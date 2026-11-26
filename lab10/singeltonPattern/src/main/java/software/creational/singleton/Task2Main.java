/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.creational.singleton;

public class Task2Main {
    public static void main(String[] args) {
        SoftwareLab1 lab1 = new SoftwareLab1();
        NetworkingLab2 lab2 = new NetworkingLab2();

        System.out.println("Same spooler instance: " + (lab1.getSpooler() == lab2.getSpooler()));

        lab1.submitJobs();
        lab2.submitJobs();

        System.out.println("Pending jobs: " + lab1.getSpooler().getPendingJobCount());

        PrintSpooler spooler = PrintSpooler.getInstance();
        while (spooler.getPendingJobCount() > 0) {
            spooler.processNextJob();
        }
        System.out.println("Pending jobs after processing: " + spooler.getPendingJobCount());
    }
}