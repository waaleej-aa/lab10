/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.creational.singleton;

public class AuditLogger {
    private static volatile AuditLogger instance;

    private AuditLogger() { }

    public static AuditLogger getInstance() {
        if (instance == null) {                  // 1st check, no lock
            synchronized (AuditLogger.class) {
                if (instance == null) {          // 2nd check, with lock
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    instance = new AuditLogger();
                }
            }
        }
        return instance;
    }
}