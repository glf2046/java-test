package com.lefeng.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);

        if(classData == null){
            throw new ClassNotFoundException();
        }else{
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String name) {
        String path = classNameToPath(name);

        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while((bytesNumRead = ins.read(buffer)) != -1){
                baos.write(buffer, 0, bytesNumRead);
            }

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }

    private String classNameToPath(String name) {
        return rootDir + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
    }

    //    private byte[] f1(){
//        return new byte[]{};
//    }
//
//    private byte f2()[]{
//            return new byte[]{};
//    }
}
