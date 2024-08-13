package me.cheezburga.addontemplate.elements.conditions;

import ch.njol.skript.conditions.base.PropertyCondition;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Name("Is Actual UUID")
@Description("Whether an object is an actual UUID (as opposed to a string, etc.).")
@Examples("broadcast true if {_uuid} is an actual uuid else false")
@Since("1.0.0")
public class CondIsActual extends PropertyCondition<Object> {

    static {
        // PropertyConditions provide a register method which handles most of the methods (e.g. init) for you
        register(CondIsActual.class, "[a|an] (actual|real) uuid", "objects");
    }

    @Override
    public boolean check(Object o) {
        return o instanceof UUID;
    }

    @Override
    protected @NotNull String getPropertyName() {
        return "an actual uuid";
    }

}
