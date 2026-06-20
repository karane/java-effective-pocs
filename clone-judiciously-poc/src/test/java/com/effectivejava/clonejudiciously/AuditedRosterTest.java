package com.effectivejava.clonejudiciously;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuditedRosterTest {

    @Test
    void overridableHookLeaksIntoOriginalBeforeDeepCopyRuns() {
        List<String> auditTrail = new ArrayList<>(List.of("created"));
        AuditedRoster original = new AuditedRoster(new Player[0], auditTrail);

        AuditedRoster clone = original.clone();

        assertTrue(original.getAuditTrail().contains("cloned"),
                "onCloned() ran against the still-shared list before AuditedRoster.clone() "
                        + "could deep-copy auditTrail, so the side effect leaked into the original");
        assertEquals(original.getAuditTrail(), clone.getAuditTrail());
    }
}
