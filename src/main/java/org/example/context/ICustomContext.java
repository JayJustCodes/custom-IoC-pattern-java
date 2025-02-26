package org.example.context;

public interface ICustomContext {
    <T> T getBean(String paramName);
    <T> T getBean(String paramName, Class<T> tClass);
}
