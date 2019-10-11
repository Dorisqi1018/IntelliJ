public class Choice {

    private int one,two,three,four;
    private String name;

    public Choice(int one, int two, int three, int four, String name){
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.name = name;
    }


    public int getOne() {
        return one;
    }
    public void setOne(int one) {
        this.one = one;
    }
    public int getTwo() {
        return two;
    }
    public void setTwo(int two) {
        this.two = two;
    }
    public int getThree() {
        return three;
    }
    public void setThree(int three) {
        this.three = three;
    }
    public int getFour() {
        return four;
    }
    public void setFour(int four) {
        this.four = four;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String toString(){
        int all = one + two + three + four;
        String scoreFinal = Standard.CovertStandard(all);

        return "Thank you for your time, " + name + "!\nYour evaluation in this category are "
                + one + " for the first question, " + two + " for the second question, "
                + three + " for the third question, " + four + " for the last question."
                + "\nFinal evaluation: " + scoreFinal;

    }
}
