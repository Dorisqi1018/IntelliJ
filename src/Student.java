public class Student extends Person {

    private double score;

    public Student(String name, double score){
        super(name);
        this.score = score;
    }

    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return super.toString() + " \nYour GPA is: " + String.format("%3.2f", score);

    }

}
