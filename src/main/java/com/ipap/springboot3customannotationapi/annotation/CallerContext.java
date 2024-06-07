package com.ipap.springboot3customannotationapi.annotation;

public class CallerContext {
    private static final ThreadLocal<String> callerName = new ThreadLocal<>();

    public static void setCallerName(String name) {
        callerName.set(name);
    }

    public static String getCallerName() {
        return callerName.get();
    }

    public static void clear() {
        callerName.remove();
    }
}

