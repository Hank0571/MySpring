package com.demo.myspring.aop.framework;

import com.demo.myspring.aop.Advisor;
import com.demo.myspring.aop.MethodBeforeAdvice;
import com.demo.myspring.aop.Pointcut;
import com.demo.myspring.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import com.demo.myspring.aop.support.DefaultPointcutAdvisor;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Aop proxy manager.
 *
 * Created by Marter on 7/11/18.
 */
public class AdvisedSupport {

    private Object target;
    private List<Class> interfaces = new ArrayList<>();

    private List<Advisor> advisors = new ArrayList<>();
    private Map<Method, List<Object>> methodCache = new HashMap<>();

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setInterfaces(List<Class> interfaces) {
        this.interfaces = interfaces;
    }

    public List<Class> getInterfaces() {
        return interfaces;
    }

    public void addAdvisor(Advisor advisor) {
        advisors.add(advisor);
    }

    public List<Object> getInterpretors(Method method, Class targetClass) {
        List<Object> cachedList = methodCache.get(method);
        if (cachedList != null) {
            return cachedList;
        }
        cachedList = new ArrayList<>();
        for (Advisor advisor : advisors) {
            if (advisor instanceof DefaultPointcutAdvisor) {
                Pointcut pointcut = ((DefaultPointcutAdvisor)advisor).getPointcut();
                if (pointcut.getMethodMatcher().mathes(method, targetClass)) {
                    Advice advice =  advisor.getAdvice();
                    /// TODO: More type of Advice
                    if (advice instanceof MethodInterceptor) {
                        cachedList.add(advice);
                    } else if (advice instanceof MethodBeforeAdvice) {
                        cachedList.add(new MethodBeforeAdviceInterceptor((MethodBeforeAdvice)advice));
                    }
                }
            } else if (advisor instanceof MethodInterceptor){
                cachedList.add(advisor);
            }
        }
        methodCache.put(method, cachedList);
        return cachedList;
    }
}
