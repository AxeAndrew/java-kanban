import java.util.HashMap;

public class TaskManager {

    protected final HashMap<Integer, Task> JobTasks = new HashMap<>();
    protected final HashMap<Integer, Epic> JobEpic = new HashMap<>();
    protected final HashMap<Integer, SubTask> JobSubtask = new HashMap<>();

    private int nextID = 1;

    private int getNextID() {
        return nextID++;
    }

    public Task addTask(Task task) {
        task.setId(getNextID());
        JobTasks.put(task.getId(), task);
        return task;
    }

    public Task getTaskId(int id) {
        return JobTasks.get(id);
    }

    public void ViewAllJobTask() {
        for (Integer key : JobTasks.keySet()) {
            System.out.println(getTaskId(key));
        }
        System.out.println(" ");
    }

    // Изменение статуса
    public void ChangesJobTask() {
        for (Integer keyi : JobTasks.keySet()) {
            System.out.println("Смена статуса задачи №" + keyi);
            Task taskUpdate = getTaskId(keyi);
            taskUpdate.setStatus(Status.IN_PROGRESS);
            updateTask(taskUpdate);
            for (Integer keyj : JobTasks.keySet()) {
                System.out.println(getTaskId(keyj));
            }
            System.out.println(" ");
        }
    }

    public void updateTask(Task task) {
        if (task != null && JobTasks.containsKey(task.getId())) {
            int id = task.getId();
            Task task1 = JobTasks.get(id);
            if (task1 == null) {
                return;
            }
            JobTasks.put(id, task);
        }
    }

    // Изменение приоритета задачи
    public void updatePriorityTask() {
        int NumElement = 0;

        for (Integer keya : JobTasks.keySet()) {
            NumElement = (NumElement + 1);
        }

        for (Integer keyi : JobTasks.keySet()) {
            System.out.println(" ");
            Task updateNameTask = getTaskId(keyi);
            updateNameTask.setName("Задача " + (keyi + NumElement));
            updateTask(updateNameTask);
            for (Integer keyj : JobTasks.keySet()) {
                System.out.println(getTaskId(keyj));
            }
        }
        System.out.println(" ");
    }

    // Изменение названия задачи
    public void updateDescriptionTask(int i) {
        Task updateDescriptionTask = getTaskId(i);
        updateDescriptionTask.setDescription("Ничего не делать");
        updateTask(updateDescriptionTask);
        System.out.println(getTaskId(i));
        System.out.println(" ");
    }

    // Очистка задач
    public void ClearJobTasks(int i, int j) {
        int NumElement = 0;
        JobTasks.remove(i);
        System.out.println("удалили ключ " + i);
        for (Integer key : JobTasks.keySet()) {
            System.out.println(getTaskId(key));
        }
        //JobTasks.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println(" ");

        System.out.println("удалили по Id " + j);
        JobTasks.values().remove(getTaskId(j));
        for (Integer key : JobTasks.keySet()) {
            System.out.println(getTaskId(key));
        }
        //JobTasks.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println(" ");
        JobTasks.clear();
        System.out.println("Полная очистка ");
        for (Integer keya : JobTasks.keySet()) {
            NumElement = (NumElement + 1);
        }
        System.out.println("Количество активных задач: " + NumElement);
        System.out.println(" ");
    }

    //Блок записи эпиков *******************************************************************
    private int nextEID = 1;

    private int getNextEID() {
        return nextEID++;
    }

    public Epic addEpic(Epic epic) {
        epic.setEId(getNextEID());
        JobEpic.put(epic.getEId(), epic);
        return epic;
    }

    public Epic getEpicId(int Eid) {
        return JobEpic.get(Eid);
    }

    public void ViewAllJobEpic() {
        for (Integer key : JobEpic.keySet()) {
            System.out.println(getEpicId(key));
        }
        System.out.println(" ");
    }

    //Блок записи подзадач *****************************************************************
    private int nextESubID = 1;

    private int getNextESubID() {
        return nextESubID++;
    }

    public SubTask addNewSubtask(SubTask subTask) {
        subTask.setESubId(getNextESubID());
        JobSubtask.put(subTask.getSubEId(), subTask);
        return subTask;
    }

    public SubTask getSubEpicId(int SubEid) {
        return JobSubtask.get(SubEid);
    }

    public void ViewAllJobSubEpic() {
        for (Integer key : JobSubtask.keySet()) {
            System.out.println(getSubEpicId(key));
        }
        System.out.println(" ");
    }

    //Блок работы с эпиками Под эпиками ****************************************************

    public SubTask getEpicSubTaskId(int EpicSubTaskId) {
        return JobSubtask.get(EpicSubTaskId);
    }

    public SubTask getSubEId(int id) {
        return JobSubtask.get(id);
    }

    public void ViewEpicTuskAndSubTusk(int i) {
        int k = 0;
        System.out.println(getEpicId(i));
        for (Integer key : JobSubtask.keySet()) {
            SubTask AllTask = getEpicSubTaskId(key);
            if (AllTask.getEpicSubTaskId() == i) {
                System.out.println("   " + getEpicSubTaskId(key));
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Non Sub Task");
        }
        System.out.println(" ");
    }

    public void upadateStatusSubEpic(int iD) {
        SubTask SubTaskUpdate = getSubEId(iD);
        SubTaskUpdate.setStatusSubTask(Status.DONE);
        int k = SubTaskUpdate.getEpicSubTaskId();
        System.out.println("Смена статуса подзадачи № " + iD + " Эпика № " + k);
        upadateStatusEpic(k);
        ViewEpicTuskAndSubTusk(k);
        System.out.println(" ");
    }

    public void upadateStatusEpic(int Eid) {
        int k = 0;
        int iNEW = 0;
        int iDONE = 0;
        Epic EpicTask = getEpicId(Eid);
        for (Integer key : JobSubtask.keySet()) {
            SubTask AllTask = getEpicSubTaskId(key);
            if (AllTask.getEpicSubTaskId() == Eid) {
                if (AllTask.getSubEpicStatus().equals(Status.IN_PROGRESS)) {
                    iNEW++;
                }
                if (AllTask.getSubEpicStatus().equals(Status.DONE)) {
                    iDONE++;
                }
                k++;
            }
        }
        if (iDONE == k) {
            EpicTask.setEpicStatus(Status.DONE);
        } else if ((iDONE > 0) || (iDONE < k) || (iNEW > 0) || (iNEW <= k)) {
            EpicTask.setEpicStatus(Status.IN_PROGRESS);
        }
    }
}






