package com.kodilla;

import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class UserMethodMonitor {
    private static final String DO_SOMETHING = "doSomething";
    private static final String USER_CLASS_NAME = "User";

    @Advice.OnMethodEnter
    public static void enter(@Advice.Origin Class clazz, @Advice.Origin("#m") String methodName) {
        if (methodName.equals(DO_SOMETHING) && clazz.getSimpleName().equals(USER_CLASS_NAME)) {
            System.out.println(String.format("[AGENT] Wykonuje sie metoda %s z klasy %s o godzinie %s", DO_SOMETHING, USER_CLASS_NAME, LocalDateTime.now()));
        }
    }
}
