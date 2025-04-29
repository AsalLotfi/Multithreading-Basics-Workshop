## Example 01:
### **Learning Goals**

- **How to create a thread** by **extending** the `Thread` class.
- **How to start a thread** using `.start()`
- **How two threads** (main thread + your custom thread) can **run concurrently**.
- **How to set and get a thread's name**

**Concurrency**: Both `Main thread` and `GreetingThread` are running at the same time — output may be interleaved.

---
## Example 02:
### **Learning Goals**
- **Creating a thread** by **implementing `Runnable`**
- Showing **Main thread** and a **custom thread** running concurrently.
- **Better design:** Using `Runnable` lets you reuse your task code in other contexts (thread pools, etc.).
- **Runnable interface** separates **task logic** from **thread creation**.

---
## Extending Thread vs Implementing Runnable?

Both approaches are valid. However, implementing `Runnable` and passing an instance of the implementation to a `Thread` instance is often preferable. This approach allows better flexibility, particularly when working with thread pools.

---
## Example 03:

### **Learning Goals**

- **Use `interrupt()`**, not `stop()`.
- **Check `Thread.currentThread().isInterrupted()`** inside loops.
- **Handle `InterruptedException`** properly and reset the interrupted status.
- **Graceful shutdown** of threads is critical in real-world applications.
- When interrupted during sleep:
    - You **re-set** the interrupt flag (`interrupt()` again inside catch).
    - You can then **break the loop** and cleanly exit.

---
## Example 04:
### **Learning Goals**
- `join()`: Blocks the calling thread until the specified thread completes. Essential for ensuring sequential execution when needed.
- You **cannot** restart a finished thread—calling `start()` on a terminated thread throws an `IllegalThreadStateException`.

---
## Example 05 and 06:
### **Objectives**

- Implement a **loader UI** that provides feedback to users while background tasks are running.
- Ensure the **background task runs concurrently** without blocking the main execution flow.
### **Learning Goals**

- Learn how to use **Java Threads** for background operations.
- Practice what you've learned in this session

