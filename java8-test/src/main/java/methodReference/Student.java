package methodReference;

public class Student {
    private String name;

    private Integer score;

    public void setNameAndScore(String name, Integer score) {
        this.name = name;
        this.score = score;
        System.out.println("Student " + name + "'s score is " + score);
    }

    public static void main(String[] args) {
        /*lambda���ʽ���÷���
        TestInterface testInterface = (student, name, score) -> student.setNameAndScore(name, score);*/
        //�����������ʵ���������õ��÷�:
        TestInterface testInterface = Student::setNameAndScore;
        testInterface.set(new Student(), "DoubleBin", 100);
    }

    @FunctionalInterface
    interface TestInterface {
        // ע�⣺��α�Student���setNameAndScore������1��Student���󣬳���һ���������������һ��
        void set(Student d, String name, Integer score);
    }
}
