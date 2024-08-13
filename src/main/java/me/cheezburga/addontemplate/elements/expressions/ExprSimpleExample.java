package me.cheezburga.addontemplate.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ExprSimpleExample extends SimpleExpression<Number> {

    static {
        Skript.registerExpression(ExprSimpleExample.class, Number.class, ExpressionType.SIMPLE, "simple example");
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        return true;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    protected @Nullable Number[] get(Event event) {
        return new Number[]{new Random().nextInt()};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public @NotNull Class<? extends Number> getReturnType() {
        return Number.class;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public String toString(@Nullable Event event, boolean debug) {
        return "simple expression example";
    }

}
