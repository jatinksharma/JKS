package com.jatin.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyClassLoader extends ClassLoader{
	
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		 MyClassLoader loader1 = new MyClassLoader();
	        
	        // load demo.Base64
	        Class clsShuffleCards = Class.forName("com.java.concurrency.iterRecur.ShuffleCards", true, loader1);
	        System.out.println("ShuffleCards class : " + clsShuffleCards);

	        if (ShuffleCards.class.equals(clsShuffleCards)) {
	            System.out.println("ShuffleCards loaded through custom loader is the same as that loaded by System loader.");
	        }
	        else {
	            System.out.println("ShuffleCards loaded through custom loader is NOT same as that loaded by System loader.");
	        }

	        // call the main method in ShuffleCards
	        java.lang.reflect.Method main = clsShuffleCards.getMethod("main", 
	                                                new Class[] {String[].class});
	        main.invoke(null, new Object[]{ new String[]{} });
	}
	
	private static final int BUFFER_SIZE = 8192;

    protected synchronized Class loadClass(String className, boolean resolve) throws ClassNotFoundException {
        log("Loading class: " + className + ", resolve: " + resolve);

        // 1. is this class already loaded?
        Class cls = findLoadedClass(className);
        if (cls != null) {
            return cls;
        }

        // 2. get class file name from class name
        String clsFile = className.replace('.', '/') + ".class";
        
        // 3. get bytes for class
        byte[] classBytes = null;
        try {
            InputStream in = getResourceAsStream(clsFile);
            byte[] buffer = new byte[BUFFER_SIZE];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int n = -1;
            while ((n = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
                out.write(buffer, 0, n);
            }
            classBytes = out.toByteArray();
        }
        catch (IOException e) {
            log("ERROR loading class file: " + e);
        }

        if (classBytes == null) {
            throw new ClassNotFoundException("Cannot load class: " + className);
        }

        // 4. turn the byte array into a Class
        try {
            cls = defineClass(className, classBytes, 0, classBytes.length);
            if (resolve) {
                resolveClass(cls);
            }
        }
        catch (SecurityException e) { 
            // loading core java classes such as java.lang.String
            // is prohibited, throws java.lang.SecurityException.
            // delegate to parent if not allowed to load class
            cls = super.loadClass(className, resolve);
        }

        return cls;
    }

    private static void log(String s) {
        System.out.println(s);
    }
}
