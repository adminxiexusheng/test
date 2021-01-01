package com.testspringboot.springboottest.aop;

import com.testspringboot.springboottest.annotation.MyAnno;
import com.testspringboot.springboottest.model.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiexusheng
 * @date 2020/12/25 - 22:51
 */
@Component
@Aspect
public class SpringBootAop {

   /* 1、execution(): 表达式主体。

    2、第一个*号：表示返回类型， *号表示所有的类型。

    3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。

    4、第二个*号：表示类名，*号表示所有的类。

    5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
    */
    @Pointcut("execution(* com.testspringboot.springboottest.dao.*.*(..))")
    public void poincut(){

    }
    /**
     * 环绕通知
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     */
    @Around(value="poincut()")
    public Object aroundAdvice(ProceedingJoinPoint point){
        Object target = point.getTarget();
        //获取切入点所在目标对象 可以发挥反射的功能获取关于类的任何信息，例如获取类名如下
        //  String className = point.getTarget().getClass().getName();
        System.out.println("point.getTarget()"+point.getTarget().getClass().getName());
        //拦截的方法名称
        String methodName = point.getSignature().getName();
        System.out.println("point.getSignature().getName()"+methodName);
      /*  if(true){
            return "aop123";
        }*/
        Object result=null;
        try {
            //point.proceed() 不在执行aop改为让切点方法执行，
            // 返回值是切点方法的返回值 必须把这个返回值给返回，否则切点方法返回值没有数据
            result=point.proceed();
        } catch (Throwable throwable) {
            System.out.println("发生了异常");
        }
        //拦截的方法参数
        Object[] args = point.getArgs();
        System.out.println("point.getArgs();"+args.toString());
        //获取方法上的注解
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method me = methodSignature.getMethod();
        for (Annotation annotation : me.getAnnotations()) {
            if(annotation instanceof  MyAnno){

                System.out.println("获取到注解名称");
            }else{
            }
        }
       // System.out.println("切点方法的返回值："+result.toString());
        List<Student> list= new ArrayList<Student>();
        Student stu=new Student();
        stu.setId(9999);
        list.add(stu);
        Object o = (Object)list;
        return result;
    }
}
