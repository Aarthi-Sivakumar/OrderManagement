package com.example.ordermanagement.exception;

public class ResourceAlreadyExists extends RuntimeException{
        public ResourceAlreadyExists(String message){
            super(message);
        }
}
