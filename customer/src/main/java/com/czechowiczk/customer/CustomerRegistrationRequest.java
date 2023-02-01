package com.czechowiczk.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
