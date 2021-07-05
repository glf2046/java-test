package com.lefeng.lamda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lamda2 {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("hello world");
        };

        runnable.run();

        List<Student> students = new ArrayList<>();
        students.add(new Student() {{
            setName("name1");
            setNo(1);
        }});
        students.add(new Student() {{
            setName("name11");
            setNo(1);
        }});
        students.add(new Student() {{
            setName("name3");
            setNo(3);
        }});
        foo(Student::getNo);
        //distinct()会调用对象的equals()方法来判断是否相等
        Map<Integer, Student> map = students.parallelStream().collect(Collectors.toMap(Student::getNo, Function.identity(), (v1, v2) -> v1));
        map.forEach(new BiConsumer() {
            @Override
            public void accept(Object key, Object value) {
                System.out.println(key + " : " + ((Student) value).getName());
            }
        });

        Function<Iterable<Student>, List<Object>> function = Lists::newArrayList;
        function.apply(Lists.newArrayList(new Student()));

        Map<Integer, List<Student>> studentMap = students.parallelStream().collect(Collectors.toMap(Student::getNo,
                Lists::newArrayList,
                (List<Student> oldList, List<Student> newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                }));

        System.out.println(studentMap);
    }

    private static <T, K> void foo(Function<T, K> function) {
    }

    private static class Student {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return no == student.no && name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(no);
        }

        public int getNo2(int a) {
            return no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private int no;
        private String name;

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
