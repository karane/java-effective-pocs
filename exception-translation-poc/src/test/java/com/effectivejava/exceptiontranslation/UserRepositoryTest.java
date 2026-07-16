package com.effectivejava.exceptiontranslation;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest {

    @Test
    void findByIdReturnsRecordWhenStorageSucceeds() {
        LowLevelStorage storage = new LowLevelStorage(Map.of("42", "Ada Lovelace"), false);
        UserRepository repository = new UserRepository(storage);

        assertEquals("Ada Lovelace", repository.findById("42"));
    }

    @Test
    void findByIdTranslatesIOExceptionIntoHigherAbstractionException() {
        LowLevelStorage storage = new LowLevelStorage(Map.of("42", "Ada Lovelace"), false);
        UserRepository repository = new UserRepository(storage);

        UserRepositoryException thrown = assertThrows(UserRepositoryException.class,
                () -> repository.findById("missing"));

        assertEquals("Failed to load user with id missing", thrown.getMessage());
    }

    @Test
    void translatedExceptionChainsTheOriginalCause() {
        LowLevelStorage storage = new LowLevelStorage(Map.of(), true);
        UserRepository repository = new UserRepository(storage);

        UserRepositoryException thrown = assertThrows(UserRepositoryException.class,
                () -> repository.findById("1"));

        assertInstanceOf(IOException.class, thrown.getCause());
        assertEquals("Disk read failed for record: 1", thrown.getCause().getMessage());
    }

    @Test
    void causeStackTraceIsPreservedForDiagnostics() {
        LowLevelStorage storage = new LowLevelStorage(Map.of(), true);
        UserRepository repository = new UserRepository(storage);

        UserRepositoryException thrown = assertThrows(UserRepositoryException.class,
                () -> repository.findById("1"));

        Throwable cause = thrown.getCause();
        assertTrue(cause.getStackTrace().length > 0);
        assertEquals(LowLevelStorage.class.getName(), cause.getStackTrace()[0].getClassName());
    }
}
