public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Task JobTask1 = new Task("Задача 1", "Проснуться");
        Task JobTask2 = new Task("Задача 2", "Умыться");
        Task JobTask3 = new Task("Задача 3", "Позавтракать");
        Task JobTask4 = new Task("Задача 4", "Погулять с собакой");

        Task JobTaskCreated1 = taskManager.addTask(JobTask1);
        Task JobTaskCreated2 = taskManager.addTask(JobTask2);
        Task JobTaskCreated3 = taskManager.addTask(JobTask3);
        Task JobTaskCreated4 = taskManager.addTask(JobTask4);

        Epic JobEpic1 = new Epic("Задача 1", "Уборка");
        Epic JobEpic2 = new Epic("Задача 2", "Съездить в огород");
        Epic JobEpic3 = new Epic("Задача 3", "Отдых");

        Epic JobEpicTaskCreated1 = taskManager.addEpic(JobEpic1);
        Epic JobEpicTaskCreated2 = taskManager.addEpic(JobEpic2);
        Epic JobEpicTaskCreated3 = taskManager.addEpic(JobEpic3);

        SubTask JobSubTask1 = new SubTask("Эпик1", "Достать пылесос", 1);
        SubTask JobSubTask2 = new SubTask("Эпик1", "Достать тряпку", 1);
        SubTask JobSubTask3 = new SubTask("Эпик1", "Помыть полы", 1);
        SubTask JobSubTask4 = new SubTask("Эпик2", "Дойти др машины", 2);
        SubTask JobSubTask5 = new SubTask("Эпик2", "Доехать", 2);
        SubTask JobSubTask6 = new SubTask("Эпик2", "Взять соленья", 2);

        SubTask JobSubTaskCreated1 = taskManager.addNewSubtask(JobSubTask1);
        SubTask JobSubTaskCreated2 = taskManager.addNewSubtask(JobSubTask2);
        SubTask JobSubTaskCreated3 = taskManager.addNewSubtask(JobSubTask3);
        SubTask JobSubTaskCreated4 = taskManager.addNewSubtask(JobSubTask4);
        SubTask JobSubTaskCreated5 = taskManager.addNewSubtask(JobSubTask5);
        SubTask JobSubTaskCreated6 = taskManager.addNewSubtask(JobSubTask6);

        System.out.println("Просмотр всех задач");
        taskManager.viewAllJobTask();
        System.out.println("изменение статуса");
        taskManager.changesJobTask();
        System.out.println("изменение приоритета");
        taskManager.updatePriorityTask();
        System.out.println("изменение задачи");
        taskManager.updateDescriptionTask(3);
        System.out.println("удаляем ключ №..., ID №.... и полностью очищаем");
        taskManager.clearJobTasks(2, 4);

        System.out.println("Просмотр всех Эпиков");
        taskManager.viewAllJobEpic();

        System.out.println("Просмотр всех Подзадач");
        taskManager.viewAllJobSubEpic();

        System.out.println("Просмотр подзадач Эпика");
        taskManager.viewEpicTuskAndSubTusk(3);
        System.out.println("Изменение статуса Подзадачи и Эпика");
        taskManager.upadateStatusSubEpic(1);
        taskManager.upadateStatusSubEpic(2);
        taskManager.upadateStatusSubEpic(3);
    }
}

