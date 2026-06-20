package com.effectivejava.clonejudiciously;

import java.util.ArrayList;
import java.util.List;

public final class AuditedRoster extends CloneCallbackBase {

    private List<String> auditTrail;

    public AuditedRoster(Player[] players, List<String> auditTrail) {
        super(players);
        this.auditTrail = auditTrail;
    }

    public List<String> getAuditTrail() {
        return auditTrail;
    }

    @Override
    public AuditedRoster clone() {
        AuditedRoster result = (AuditedRoster) super.clone();
        // Too late: onCloned() already ran, against the shared auditTrail,
        // before this line could deep-copy it.
        result.auditTrail = new ArrayList<>(auditTrail);
        return result;
    }

    @Override
    protected void onCloned() {
        auditTrail.add("cloned"); // may still leak to the original
    }
}
