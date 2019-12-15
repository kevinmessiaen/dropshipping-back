package com.messiaen.dropshipping.exception;

public class UsernameAlreadyTakenException extends RuntimeException {

    public UsernameAlreadyTakenException(String username) {
        super("Le nom d'utiliateur " + username + " est déjà utilisé");
    }
}
