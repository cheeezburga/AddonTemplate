package me.cheezburga.addontemplate.elements.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Name("Actual UUID - Entities")
@Description("Gets the actual uuid of an entity.")
@Examples("set {_uuid} to actual uuid of (random element out of all entities)")
@Since("1.0.0")
public class ExprSimplePropertyExample extends SimplePropertyExpression<Entity, UUID> {

    static {
        register(ExprSimplePropertyExample.class, UUID.class, "actual uuid", "entities");
    }

    @Override
    public @Nullable UUID convert(Entity entity) {
        return entity.getUniqueId();
    }

    @Override
    protected @NotNull String getPropertyName() {
        return "actual uuid";
    }

    @Override
    public @NotNull Class<? extends UUID> getReturnType() {
        return UUID.class;
    }

}
