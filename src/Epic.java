public class Epic extends Task {
    private Status status;

    public Epic(String name, String description) {
        super(name, description);
        this.status = Status.NEW;
    }

    public int getEId() {
        return id;
    }

    public void setEId(int Eid) {
        this.id = Eid;
    }

    public void setEpicStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
