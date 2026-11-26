/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.creational.singleton;

public class AuditLogger {
    private static AuditLogger instance;

    private AuditLogger() { }

    public static AuditLogger getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(50); // simulates initialization latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            instance = new AuditLogger();
        }
        return instance;
    }
}