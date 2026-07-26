package mku.BIT8307.week11.model;

public class Course {
    private final String code;
    private final String title;
    private final int credits;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }

    public String toDisplayText() {
        return code + " - " + title + " (" + credits + " credits)";
    }
}
