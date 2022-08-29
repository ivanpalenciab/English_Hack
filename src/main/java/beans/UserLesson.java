
package beans;


public class UserLesson {
    private int id;
    private String username;
    private int lesson_id;
    private boolean finished;
    private double grade;

    public UserLesson(int id, String username, int lesson_id, boolean finished, double grade) {
        this.id = id;
        this.username = username;
        this.lesson_id = lesson_id;
        this.finished = finished;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UserLesson{" + "id=" + id + ", username=" + username + ", lesson_id=" + lesson_id + ", finished=" + finished + ", grade=" + grade + '}';
    }
    
    
    
}
