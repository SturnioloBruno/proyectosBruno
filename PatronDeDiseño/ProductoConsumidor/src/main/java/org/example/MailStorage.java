package org.example;

import lombok.Getter;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class MailStorage {
    @Getter
    private final Queue<Mail> mailsQueue;
    private final int capacityLimit;

    private final AtomicBoolean workFinish = new AtomicBoolean(false);
}
