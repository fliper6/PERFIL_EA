package backend.json;


public class SingleTimeline{
    private String state;
    private String time;

    public SingleTimeline() {
    }

    public SingleTimeline(String state, String time) {
        this.state = state;
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
