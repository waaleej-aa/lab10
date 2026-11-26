# Creational Design Patterns: The Singleton Pattern

**Course:** Software Construction
**Institute:** UET Peshawar, Abbottabad Campus
**Language / Tools:** Java, Maven, NetBeans, Git/GitHub

## Objective

Apply creational software construction principles by designing centralized, memory-safe and thread-safe Singleton components that prevent duplicate resource allocation and maintain consistent shared state across modules.

## Project Structure

| File | Task | Purpose |
|------|------|---------|
| `DatabaseConnectionManager.java` | Task 1 | Lazy Singleton with a constructor counter and `executeQuery()` |
| `Task1Main.java` | Task 1 | Simulates three modules and verifies a single instance |
| `PrintSpooler.java` | Task 2 | Singleton wrapping a FIFO `Queue<String>` of print jobs |
| `SoftwareLab1.java` | Task 2 | Client that submits two print jobs |
| `NetworkingLab2.java` | Task 2 | Client that submits one print job |
| `Task2Main.java` | Task 2 | Runs both labs and processes the queue in FIFO order |
| `AuditLogger.java` | Task 3 | Naive lazy Singleton first, then fixed with double-checked locking |
| `Task3Main.java` | Task 3 | Spawns 5 threads that each call `AuditLogger.getInstance()` |

## Task Descriptions

### Task 1: Centralized Database Connection Manager (Lazy Singleton)

`DatabaseConnectionManager` has a private constructor, a static counter that tracks how many times the constructor runs, and an `executeQuery(String moduleName, String sql)` method. In `Task1Main`, three modules (`StudentPortal`, `FeeBillingService`, `AttendanceTracker`) call `getInstance()`. The program prints `System.identityHashCode()` for each reference, runs a sample query from each module, and uses `==` to prove that only one connection object was created.

**Result:** all three references share the same hash code, both `==` checks print `true`, and the constructor count is `1`.

### Task 2: Campus Print Spooler Queue (Shared State Consistency)

`PrintSpooler` is a Singleton holding a `Queue<String>` (`LinkedList`) of pending jobs, with `addPrintJob(labName, documentName)`, `processNextJob()` and `getPendingJobCount()`. `SoftwareLab1` submits two jobs and `NetworkingLab2` submits one. All jobs are then processed in FIFO order.

**Result:** both labs get the same spooler instance (`true`), 3 jobs are queued, they print in the order they were submitted, and 0 remain afterwards. No job is lost or overwritten.

### Task 3: Exposing and Fixing Race Conditions (Thread Safety)

1. **Naive version:** `AuditLogger` is a lazy Singleton with no synchronization. A `Thread.sleep(50)` before `new AuditLogger()` simulates initialization latency. Five threads call `getInstance()` at the same time.
   **Result:** multiple distinct hash codes appear, which proves that several instances were created (race condition).
2. **Fixed version:** the instance field is declared `volatile` and `getInstance()` uses double-checked locking with a `synchronized` block.
   **Result:** all 5 threads print the same hash code, so exactly one instance exists.

## How to Run

### Prerequisites

- JDK 11 or later
- Apache Maven (bundled with NetBeans)

### In NetBeans

1. Open the project via **File > Open Project**.
2. Right-click the file you want to run (for example `Task1Main.java`) and choose **Run File** (Shift+F6).

### Reproducing the Task 3 race condition

The race condition is timing-dependent, so the exact hash codes and the number of distinct instances differ on every run. To see the bug, run `Task3Main` with the naive `AuditLogger`. To see the fix, replace `AuditLogger.java` with the double-checked locking version and run it again. If the naive version happens to print only one hash code, run it again.

## Key Takeaways

- A private constructor plus a static accessor is enough to enforce a single instance in single-threaded code.
- A lazy Singleton without synchronization is not thread-safe: two threads can pass the `null` check before either assigns the instance.
- Double-checked locking needs `volatile` so that other threads never see a partially constructed object.
- Singletons introduce global state, which couples modules together and makes unit testing harder.

