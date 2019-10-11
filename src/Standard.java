public class Standard {

    public static void Standards(Choice s, int qStandards) {
        if (s.getOne() == 0) {
            s.setOne(qStandards);
        } else if (s.getTwo() == 0) {
            s.setTwo(qStandards);
        } else if (s.getThree() == 0) {
            s.setThree(qStandards);
        } else if (s.getFour() == 0) {
            s.setFour(qStandards);
        } else {

            System.out.println("All the answers have already been input.");

        }
    }

    public static String CovertStandard(int score) {


        if (score >= 17) {
            return "A";

        } else if (score >= 15) {
            return "B";

        } else if (score >= 13) {
            return "C";

        } else if (score >= 11) {
            return "D";

        } else {
            return "F";
        }
    }
}
