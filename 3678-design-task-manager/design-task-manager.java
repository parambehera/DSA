class Pair {
    int task;
    int priority;

    public Pair(int task, int priority) {
        this.task = task;
        this.priority = priority;
    }
}

class TaskManager {
    private HashMap<Integer, Integer> taskToUser;
    private HashMap<Integer, Integer> taskToPriority;
    private PriorityQueue<Pair> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskToUser = new HashMap<>();
        taskToPriority = new HashMap<>();
        pq = new PriorityQueue<>(
            (p1, p2) -> {
                if (p1.priority == p2.priority) {
                    return Integer.compare(p2.task, p1.task); // higher taskId first
                }
                return Integer.compare(p2.priority, p1.priority); // higher priority first
            }
        );

        for (List<Integer> list : tasks) {
            int user = list.get(0);
            int task = list.get(1);
            int priority = list.get(2);
            taskToUser.put(task, user);
            taskToPriority.put(task, priority);
            pq.add(new Pair(task, priority));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskToUser.put(taskId, userId);
        taskToPriority.put(taskId, priority);
        pq.add(new Pair(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        if (taskToUser.containsKey(taskId)) {
            taskToPriority.put(taskId, newPriority);
            pq.add(new Pair(taskId, newPriority)); // lazy update
        }
    }

    public void rmv(int taskId) {
        taskToUser.remove(taskId);
        taskToPriority.remove(taskId);
        // old copies remain in pq but will be ignored in execTop()
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            Integer curPriority = taskToPriority.get(top.task);

            if (curPriority != null && curPriority == top.priority) {
                pq.poll();
                int user = taskToUser.get(top.task);
                taskToUser.remove(top.task);
                taskToPriority.remove(top.task);
                return user;
            } else {
                pq.poll(); // discard outdated entry
            }
        }
        return -1;
    }
}
