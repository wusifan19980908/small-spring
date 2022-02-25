package com.jilin.spring.aop.aspectj;

import com.jilin.spring.aop.ClassFilter;
import com.jilin.spring.aop.MethodMatcher;
import com.jilin.spring.aop.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname AspectJExpressionPointcut
 * @Description 切点表达式类
 * 切点表达式实现了 Pointcut、ClassFilter、MethodMatcher，三个接口定义方法，
 * 同时这个类主要是对 aspectj 包提供的表达式校验方法使用
 * @Date 2022/2/24 16:56
 * @Created by jilin
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {
    /**
     * 表达式
     */
    private static final Set<PointcutPrimitive> SUPPORT_PRIMITIVES = new HashSet<PointcutPrimitive>();

    static {
        SUPPORT_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }
    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression){
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORT_PRIMITIVES,this.getClass().getClassLoader());
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }


    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> clazz) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
