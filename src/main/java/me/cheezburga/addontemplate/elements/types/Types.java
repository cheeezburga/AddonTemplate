package me.cheezburga.addontemplate.elements.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import org.jetbrains.annotations.NotNull;

import java.io.NotSerializableException;
import java.io.StreamCorruptedException;
import java.util.UUID;

public class Types {

    static {
        Classes.registerClass(new ClassInfo<>(UUID.class, "actualuuid")
                .user("actual ?uuids?")
                .name("Actual UUID")
                .description("Represents the actual UUID of an entity.")
                .serializer(new Serializer<>() {
                    @Override
                    public @NotNull Fields serialize(UUID uuid) throws NotSerializableException {
                        Fields f = new Fields();
                        f.putObject("uuid", uuid.toString());
                        return f;
                    }

                    @Override
                    @SuppressWarnings("NullableProblems")
                    public void deserialize(UUID uuid, Fields fields) {
                        assert false;
                    }

                    @Override
                    protected UUID deserialize(@NotNull Fields fields) throws StreamCorruptedException {
                        String string = fields.getObject("uuid", String.class);
                        assert string != null;
                        return UUID.fromString(string);
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return true;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }
                }));
    }

}
