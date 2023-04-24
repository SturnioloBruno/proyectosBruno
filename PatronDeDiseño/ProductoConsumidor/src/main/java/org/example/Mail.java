package org.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Mail {
    private final String message,destinationName,destinationMail;

}
