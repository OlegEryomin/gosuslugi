package ru.edu.bsu.gosuslugi.exception;

public class DepartmentAlreadyExistException extends Exception{
    public DepartmentAlreadyExistException(String message) {
        super(message);
    }
}
