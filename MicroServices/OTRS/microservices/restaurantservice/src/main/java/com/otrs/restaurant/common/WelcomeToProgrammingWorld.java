package com.otrs.restaurant.common;
public class WelcomeToProgrammingWorld {
    public static void main(String[] args) {
        Welcome welcomeToALanguage =  language -> {
        	System.out.println("Welcome to world of " + language + "Programming Language");
        	System.out.print(language.length());
        };
        welcomeToALanguage.welcome("Java");
        welcomeToALanguage.welcome("Groovy");
        welcomeToALanguage.welcome("Scala");
    }
}
interface Welcome {
    abstract void welcome(String string);
}