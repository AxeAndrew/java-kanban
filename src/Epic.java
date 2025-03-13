public class Epic extends Task {
    private Status status;

    public Epic(String name, String description) {
        super(name, description);
        this.status = Status.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int eId) {
        this.id = eId;
    }

    public void setStatus(Status status) {
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
