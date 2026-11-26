package software.creational.singleton;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {
    private static PrintSpooler instance;
    private final Queue<String> jobs = new LinkedList<>();

    private PrintSpooler() {
        System.out.println("[Spooler] Created once.");
    }

    public static PrintSpooler getInstance() {
        if (instance == null) {
            instance = new PrintSpooler();
        }
        return instance;
    }

    public void addPrintJob(String labName, String documentName) {
        jobs.add(labName + " -> " + documentName);
        System.out.println("[Queued] " + labName + " -> " + documentName);
    }

    public void processNextJob() {
        String job = jobs.poll();
        if (job == null) {
            System.out.println("[Spooler] No jobs to process.");
        } else {
            System.out.println("[Printing] " + job);
        }
    }

    public int getPendingJobCount() {
        return jobs.size();
    }
}