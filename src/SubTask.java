public class SubTask extends Task {

    private Status status;
    public int EpicSubTaskId;

    public SubTask(String name, String description, int EpicSubTaskId) {
        super(name, description);

        this.EpicSubTaskId = EpicSubTaskId;
        this.status = Status.NEW;
    }

    public int getSubEId() {
        return id;
    }

    public void setESubId(int ESubTaskId) {
        this.id = ESubTaskId;
    }

    public void setStatusSubTask(Status status) {
        this.status = status;
    }

    public int getEpicSubTaskId() {
        return EpicSubTaskId;
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
                ", EpicSubTaskId=" + EpicSubTaskId +
                ", Sub id=" + id +
                '}';
    }

}