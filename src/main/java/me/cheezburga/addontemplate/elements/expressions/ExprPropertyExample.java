package me.cheezburga.addontemplate.elements.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Name("Actual UUID - Strings")
@Description("Gets the actual uuid from a string.")
@Examples("set {_uuid} to actual uuid of (uuid of (random element out of all entities))")
@Since("1.0.0")
public class ExprPropertyExample extends PropertyExpression<String, UUID> {

    static {
        // PropertyExpressions provide a register method, which essentially just takes property and type strings
        // and creates the patterns for you
        register(ExprPropertyExample.class, UUID.class, "actual uuid", "strings");
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        return true;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    protected UUID[] get(Event event, String[] strings) {
        List<UUID> uuids = new ArrayList<>();
        for (String string : strings) {
            try {
                uuids.add(UUID.fromString(string));
            } catch (IllegalArgumentException ignored) {}
        }
        return uuids.toArray(UUID[]::new);
    }

    @Override
    public @NotNull Class<? extends UUID> getReturnType() {
        return UUID.class;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public String toString(@Nullable Event event, boolean debug) {
        return "actual uuid of " + getExpr().toString(event, debug);
    }

}
