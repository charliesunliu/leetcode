import java.util.*;

class leastInterval {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        PriorityQueue<task> pq = new PriorityQueue<>(new Comparator<task>() {
            @Override
            public int compare(task o1, task o2) {
                int i = o1.count != o2.count ?  o2.count - o1.count : o1.name - o2.name;
                return i;
            }
        });

        HashMap<Character, Integer> frequncy = new HashMap<>();
        for (char task : tasks){
            frequncy.put(task, frequncy.getOrDefault(task, 0) + 1);
        }
        for (char c : frequncy.keySet()){
            task t = new task(c, frequncy.get(c));
            pq.add(t);
        }

        int taskCompleted = 0;
        int tick = 0;
        while (taskCompleted < tasks.length){
            List<task> potentialTasks = new LinkedList<>();
            while (!pq.isEmpty() && potentialTasks.size() < n + 1){
                potentialTasks.add(pq.poll());
                potentialTasks.get(potentialTasks.size() - 1).count--;
                taskCompleted++;
                tick++;
            }
            if(potentialTasks.size() < n + 1 && taskCompleted < tasks.length) {
                tick += n + 1 - potentialTasks.size();
            }
            for (task t : potentialTasks){
                if (t.count > 0){
                    pq.add(t);
                }
            }
        }

        return tick;
    }
}

class task {
    public char name;
    public int count;
    public task(char name, int count){
        this.name = name;
        this.count = count;
    }
}