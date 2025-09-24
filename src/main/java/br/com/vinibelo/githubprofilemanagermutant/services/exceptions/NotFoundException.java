package br.com.vinibelo.githubprofilemanagermutant.services.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
