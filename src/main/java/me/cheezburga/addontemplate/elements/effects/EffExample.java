package me.cheezburga.addontemplate.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import me.cheezburga.addontemplate.api.utils.Utils;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EffExample extends Effect {

    static {
        Skript.registerEffect(EffExample.class, "this is an effect");
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        return true;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    protected void execute(Event event) {
        Utils.log("Executing the example effect!");
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public String toString(@Nullable Event event, boolean debug) {
        return "example effect";
    }

}
