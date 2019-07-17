package Application.utils;

import Application.Interfaces.BookingSaver;

public class EnvironmentSingleton {
    private static EnvironmentSingleton instance = null;
    public BookingSaver saver;

    private EnvironmentSingleton(){
        BookingSaver saver = new CSVWriter();
        this.saver = saver;
    }
    public static EnvironmentSingleton getInstance(){
        if(instance == null){
            instance = new EnvironmentSingleton();
        }
        return instance;
    }
}
