package com.gameloft9.demo.core;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * 抽象策略工厂类
 * Created by gameloft9 on 2019/8/5.
 */
public abstract class StrategyFactory {
    /**
     * 扫描策略类的包路径
     */
    private String strategyScanPackage;

    /**
     * 由于不知道具体的业务上，策略类是根据什么注解区分的，
     * 这里需要子工厂类注入一个业务策略类的注解class
     * */
    private Class<?> strategyAnnotationClass;

    //策略类列表
    private List<Class<?>> strategyList;

    public StrategyFactory() {
        init();
    }

    /**
     * 创建具体的策略类
     */
    public Object createStrategy(Object... params) {
        //在策略列表查找策略
        for (Class<?> clazz : strategyList) {
            if(clazz.isInterface()){// 过滤掉接口类型
                continue;
            }

            //判断该策略类是否满足要求
            if (matchStrategy(clazz,params)) {
                try {
                    if(getStrategyFromSpringContext()){// 从spring中获取
                        return ContextUtil.getBean(clazz);
                    }else{
                        return clazz.newInstance(); // 反射new一个实例
                    }
                } catch (Exception e) {
                    throw new RuntimeException("获取策略实例异常");
                }
            }
        }

        throw new RuntimeException("没有找到匹配的策略");
    }

    /**
     * 是否匹配策略，根据此筛选出最终的策略类
     * */
    protected boolean matchStrategy(Class<?> clazz,Object... params){
        Annotation[] annotations = clazz.getDeclaredAnnotations();//获取该策略类上的注解

        for(Annotation annotation : annotations){
            if(annotation.annotationType().equals(strategyAnnotationClass)){// 找到策略分类的那个注解
                return accept(annotation,params); // 匹配逻辑
            }
        }

        return false;
    }

    /**
     * 是否从spring容器中获取策略实例，默认反射实例化
     * */
    protected boolean getStrategyFromSpringContext(){
        return false;
    }

    /**
     * 策略匹配逻辑
     * @param annotation
     * @param params
     * @return
     */
    protected boolean accept(Annotation annotation,Object... params){
        throw new RuntimeException("必须继承StrategyFactory并实现");
    }

    /**
     * 策略类分类注解
     */
    protected Class<?> strategyAnnotationClass(){
        throw new RuntimeException("必须继承StrategyFactory并实现");
    }

    /**
     * 初始化策略列表
     */
    private void init() {
        setStrategyAnnotationClass(strategyAnnotationClass());

        getScanPackage();

        if (StringUtils.isBlank(strategyScanPackage)) {
            throw new RuntimeException("策略扫描包不能为空");
        }

        strategyList =  ClassUtil.getClassListByAnnotation(strategyScanPackage,StrategyComponent.class,true);
    }



    /**
     * 获取策略类扫描包路径
     * */
    private void getScanPackage(){
        Annotation[] annotations = this.getClass().getDeclaredAnnotations();

        if (annotations == null || annotations.length == 0) {
           throw new RuntimeException("没有找到StrategyScan注解");
        }

        for (Annotation annotation : annotations) {
            if (annotation instanceof StrategyScan) {
                this.strategyScanPackage = ((StrategyScan) annotation).value();

                return;
            }
        }

        throw new RuntimeException("没有找到StrategyScan注解");
    }

    private void setStrategyAnnotationClass(Class<?> clazz){
        this.strategyAnnotationClass = clazz;
    }
}

