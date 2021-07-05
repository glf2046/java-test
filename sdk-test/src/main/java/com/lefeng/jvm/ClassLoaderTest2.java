package com.lefeng.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            /**
             * Loads the class with the specified <a href="#name">binary name</a>.
             * This method searches for classes in the same manner as the {@link
             * #loadClass(String, boolean)} method.  It is invoked by the Java virtual
             * machine to resolve class references.  Invoking this method is equivalent
             * to invoking {@link #loadClass(String, boolean) <tt>loadClass(name,
             * false)</tt>}.
             *
             * @param name The <a href="#name">binary name</a> of the class
             * @return The resulting <tt>Class</tt> object
             * @throws ClassNotFoundException If the class was not found
             */
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }

                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        };

        Object obj = myLoader.loadClass("com.lefeng.jvm.ClassLoaderTest2").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest2);

        //Won't cast since there are different class to JVM
        ClassLoaderTest2 test2 = new ClassLoaderTest2();
        test2 = (ClassLoaderTest2)obj;
    }
}
