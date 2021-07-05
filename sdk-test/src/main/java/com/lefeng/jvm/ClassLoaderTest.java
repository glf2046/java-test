package com.lefeng.jvm;

import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        String classPath = "E:\\Dev\\GitHub\\java-test\\sdk-test\\target\\classes";

        FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(classPath);
        FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(classPath);

        String className = "com.lefeng.jvm.SharedClass";

        try {
            Class<?> class1 = fileSystemClassLoader1.loadClass(className);
            Object object1 = class1.newInstance();

            Class<?> class2 = fileSystemClassLoader2.loadClass(className);
            Object object2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", Object.class);
            setSampleMethod.invoke(object1, object2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SharedClass{
        public String getName() {
            return name;
        }

        private String name;

        public SharedClass(String name){
            this.name = name;
        }
    }
}
