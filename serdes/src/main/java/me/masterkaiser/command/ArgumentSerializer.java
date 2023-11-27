package me.masterkaiser.command;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ArgumentSerializer implements ObjectSerializer<ArgumentMeta> {
    @Override
    public boolean supports(@NonNull Class<? super ArgumentMeta> type) {
        return ArgumentMeta.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NonNull ArgumentMeta object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
        data.add("name", object.getName());

        if (object.getUsage() != null) {
            data.add("usage", object.getUsage());
        }

        if (object.getDescription() != null) {
            data.add("description", object.getDescription());
        }

        if (object.getPermission() != null) {
            data.add("permission", object.getPermission());
        }

        if (object.getAliases() != null && object.getAliases().length != 0) {
            data.add("aliases", List.of(object.getAliases()));
        }
    }

    @Override
    public ArgumentMeta deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
        final String name = data.get("name", String.class);

        final String usage = data.containsKey("usage")
                ? data.get("usage", String.class)
                : null;

        final String description = data.containsKey("description")
                ? data.get("description", String.class)
                : null;

        final String permission = data.containsKey("permission")
                ? data.get("permission", String.class)
                : null;

        final List<String> aliases = data.containsKey("aliases")
                ? data.getAsList("aliases", String.class)
                : new ArrayList<>();

        return new ArgumentMeta(name, usage, description, permission, aliases.toArray(new String[0]));
    }
}
