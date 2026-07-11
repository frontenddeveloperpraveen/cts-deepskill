class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task [ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }

        Node current = head;
        Node prev = null;

        while (current != null && !current.task.getTaskId().equals(taskId)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        Task t1 = new Task("T101", "Design Database Schema", "Pending");
        Task t2 = new Task("T102", "Implement Authentication", "In Progress");
        Task t3 = new Task("T103", "Write API Documentation", "Completed");

        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);

        System.out.println("Initial Tasks:");
        list.traverseTasks();

        System.out.println("\nSearching for Task T102...");
        Task found = list.searchTask("T102");
        System.out.println("Found: " + found);

        System.out.println("\nDeleting Task T101...");
        list.deleteTask("T101");

        System.out.println("Tasks after deletion:");
        list.traverseTasks();
    }
}
