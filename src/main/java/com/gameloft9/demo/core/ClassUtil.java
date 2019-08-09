package com.gameloft9.demo.core;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/*
 * 类工具
 */
public class ClassUtil {

    /**
     * 根据注解筛选对应的class文件
     *
     * @param packageName     包名
     * @param annotationClass 注解类
     * @param isRecursive     是否递归
     * @return
     */
    public static List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass, boolean isRecursive) {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        try {
            classList = getClassList(packageName, isRecursive);

            Iterator<Class<?>> it = classList.iterator();
            while (it.hasNext()) {
                Class<?> clz = it.next();

                if (!clz.isAnnotationPresent(annotationClass)) { // 剔除掉没有相应注解的类
                    it.remove();
                }
            }

            return classList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return classList;
    }

    /**
     * 给我一个包名，获取该包下的所有class文件
     *
     * @param packageName 包名 com.xxx.xxx
     * @param isRecursive 是否递归
     * @return 返回class文件的集合
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClassList(String packageName, boolean isRecursive) throws ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<Class<?>>();

        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replace('.', '/'));

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    //拿到文件的协议
                    String protocol = url.getProtocol();

                    //如果是file
                    if ("file".equals(protocol)) {
                        //取到文件的路径
                        String packagePath = url.getPath();

                        addClass(classList, packagePath, packageName, isRecursive);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classList;
    }


    /**
     * 将对应包名下的所有.class文件加入到classList集合中
     *
     * @param classList   存放classList文件的集合
     * @param packagePath 包路径
     * @param packageName 包名
     * @param isRecursive 是否递归
     * @throws ClassNotFoundException
     */
    private static void addClass(List<Class<?>> classList, String packagePath, String packageName,
                                 boolean isRecursive) throws ClassNotFoundException {
        //取到路径下所有的对应的文件，包括.class文件和目录
        File[] files = getClassFiles(packagePath);

        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();

                if (file.isFile()) { // 如果是类文件则直接添加该类
                    String className = getClassName(packageName, fileName);

                    classList.add(Class.forName(className,false,Thread.currentThread().getContextClassLoader()));
                } else {
                    if (isRecursive) { // 递归获取类文件
                        String subPackagePath = getSubPackagePath(packagePath, fileName);
                        String subPackageName = getSubPackageName(packageName, fileName);

                        addClass(classList, subPackagePath, subPackageName, isRecursive);
                    }
                }
            }

        }
    }

    /**
     * 获取子包名
     *
     * @param packageName
     * @param fileName
     * @return
     */
    private static String getSubPackageName(String packageName, String fileName) {
        String subPackageName = fileName;

        if (packageName != null && (!"".equals(packageName))) {
            subPackageName = packageName + "." + subPackageName;
        }

        return subPackageName;
    }

    /**
     * 获取子目录
     *
     * @param packagePath 包的路径
     * @param fileName    文件的路径
     * @return
     */
    private static String getSubPackagePath(String packagePath, String fileName) {
        String subPackagePath = fileName;

        if (packagePath != null && (!"".equals(packagePath))) {
            subPackagePath = packagePath + "/" + subPackagePath;
        }

        return subPackagePath;
    }

    /**
     * 根据传入的包名和文件名返回对应类的全限定名
     *
     * @param packageName 包名
     * @param fileName    文件名 	类名.后缀名
     * @return 包名.类名
     */
    private static String getClassName(String packageName, String fileName) {
        String className = fileName.substring(0, fileName.indexOf("."));

        if (packageName != null && !"".equals(packageName)) {
            className = packageName + "." + className;
        }

        return className;
    }

    /**
     * 获取class文件列表包括目录
     *
     * @param packagePath
     * @return
     */
    private static File[] getClassFiles(String packagePath) {
        return new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                //如果是.class文件，或者是目录就返回true
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
    }

}
