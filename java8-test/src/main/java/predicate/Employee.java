package predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author guff
 * @since 2020-01-06 16:07
 */
public class Employee {

    <T> List<T> getList(){
        return null;
    }

    static <T> List<T> getStaticList(){
        return null;
    }

    public static void main(String[] args) {
        Employee employee = new Employee(2, 2, "", "", "");
        List<Employee> list = employee.<Employee>getList();
        List list2 = Employee.<Employee>getStaticList();
        System.out.println(list);
        System.out.println(list2);
    }

    public Employee(Integer id, Integer age, String gender, String fName, String lName){
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    private Integer id;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String gender;
    private String firstName;
    private String lastName;

    //Please generate Getter and Setters

    @Override
    public String toString() {
        return this.id.toString()+" - "+this.age.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }
    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }
    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }
}
