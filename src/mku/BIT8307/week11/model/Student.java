package mku.BIT8307.week11.model;

public class Student {
    private final String studentId;
    private final String fullName;
    private final String email;
    private final String program;

    public Student(String studentId, String fullName, String email, String program) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.program = program;
    }

    public String getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getProgram() { return program; }

    @Override
    public String toString() {
        return studentId + " - " + fullName + " (" + program + ")";
    }
}
