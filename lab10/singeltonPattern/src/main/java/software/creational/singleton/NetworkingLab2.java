/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.creational.singleton;

public class NetworkingLab2 {
    private final PrintSpooler spooler = PrintSpooler.getInstance();

    public PrintSpooler getSpooler() { return spooler; }

    public void submitJobs() {
        spooler.addPrintJob("NetworkingLab2", "Subnetting Worksheet.pdf");
    }
}