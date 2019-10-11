public class Teacher extends Person {


    public Teacher (String name) {
        super(name);
    }

    @Override
    public String toString(){
        return "Hello, " + getName() + "! " + "You don't need to give us the score.";
    }
}
