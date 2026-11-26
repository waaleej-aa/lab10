/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.creational.singleton;
public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private static int constructorCount = 0;

    private DatabaseConnectionManager() {
        constructorCount++;
        System.out.println("[DB] Connection opened. Constructor executions: " + constructorCount);
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public void executeQuery(String moduleName, String sql) {
        System.out.println("[" + moduleName + "] Executing: " + sql);
    }

    public static int getConstructorCount() {
        return constructorCount;
    }
}