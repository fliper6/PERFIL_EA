package backend.json;
public class TimelineJSON {
    private String date;
    private SingleTimeline[] timeline;

    public TimelineJSON() {
    }

    public TimelineJSON(String date, SingleTimeline[] timeline) {
        this.date = date;
        this.timeline = timeline;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SingleTimeline[] getTimeline() {
        return timeline;
    }

    public void setTimeline(SingleTimeline[] timeline) {
        this.timeline = timeline;
    }
}
