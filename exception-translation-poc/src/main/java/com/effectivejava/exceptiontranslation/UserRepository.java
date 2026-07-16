package com.effectivejava.exceptiontranslation;

import java.io.IOException;

public final class UserRepository {

    private final LowLevelStorage storage;

    public UserRepository(LowLevelStorage storage) {
        this.storage = storage;
    }

    public String findById(String id) {
        try {
            return storage.readRawRecord(id);
        } catch (IOException e) {
            throw new UserRepositoryException("Failed to load user with id " + id, e);
        }
    }
}
