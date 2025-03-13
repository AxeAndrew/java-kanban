public class SubTask extends Task {

    private Status status;
    public int epicSubTaskId;

    public SubTask(String name, String description, int epicSubTaskId) {
        super(name, description);

        this.epicSubTaskId = epicSubTaskId;
        this.status = Status.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int eSubTaskId) {
        this.id = eSubTaskId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEpicSubTaskId() {
        return epicSubTaskId;
    }

    public Status getSubEpicStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "SubEpic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", EpicSubTaskId=" + epicSubTaskId +
                ", Sub id=" + id +
                '}';
    }

}