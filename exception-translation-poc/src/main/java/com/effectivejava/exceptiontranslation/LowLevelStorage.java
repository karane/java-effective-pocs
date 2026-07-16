package com.effectivejava.exceptiontranslation;

import java.io.IOException;
import java.util.Map;

public final class LowLevelStorage {

    private final Map<String, String> disk;
    private final boolean faulty;

    public LowLevelStorage(Map<String, String> disk, boolean faulty) {
        this.disk = disk;
        this.faulty = faulty;
    }

    public String readRawRecord(String id) throws IOException {
        if (faulty) {
            throw new IOException("Disk read failed for record: " + id);
        }
        String record = disk.get(id);
        if (record == null) {
            throw new IOException("Record not found on disk: " + id);
        }
        return record;
    }
}
