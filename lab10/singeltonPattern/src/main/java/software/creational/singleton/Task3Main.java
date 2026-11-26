/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.creational.singleton;

public class Task3Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int id = i + 1;
            threads[i] = new Thread(() -> {
                AuditLogger logger = AuditLogger.getInstance();
                System.out.println("Thread-" + id + " hash: " + System.identityHashCode(logger));
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
    }
}