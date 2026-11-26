/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package software.creational.singleton;

/**
 *
 * @author waleeja
 */
public class SingeltonPattern {

    public static void main(String[] args) {
        DatabaseConnectionManager studentPortal = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager feeBillingService = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager attendanceTracker = DatabaseConnectionManager.getInstance();

        System.out.println("StudentPortal hash:      " + System.identityHashCode(studentPortal));
        System.out.println("FeeBillingService hash:  " + System.identityHashCode(feeBillingService));
        System.out.println("AttendanceTracker hash:  " + System.identityHashCode(attendanceTracker));

        studentPortal.executeQuery("StudentPortal", "SELECT * FROM students");
        feeBillingService.executeQuery("FeeBillingService", "SELECT * FROM fee_vouchers");
        attendanceTracker.executeQuery("AttendanceTracker", "SELECT * FROM attendance");

        System.out.println("studentPortal == feeBillingService: " + (studentPortal == feeBillingService));
        System.out.println("feeBillingService == attendanceTracker: " + (feeBillingService == attendanceTracker));
        System.out.println("Total connection objects created: " + DatabaseConnectionManager.getConstructorCount());
    }
}