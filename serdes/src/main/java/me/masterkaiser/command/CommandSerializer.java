package me.masterkaiser.command;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandSerializer implements ObjectSerializer<CommandMeta> {
    @Override
    public boolean supports(@NonNull Class<? super CommandMeta> type) {
        return CommandMeta.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NonNull CommandMeta object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
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

        if (object.getPlayerOnly() != null) {
            data.add("playerOnly", object.getPlayerOnly());
        }

        if (object.getArguments() != null && !object.getArguments().isEmpty()) {
            data.add("arguments", object.getArguments());
        }

        if (object.getEnabled() != null) {
            data.add("enabled", object.getEnabled());
        }
    }

    @Override
    public CommandMeta deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
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

        final Boolean playerOnly = data.containsKey("playerOnly")
                ? data.get("playerOnly", Boolean.class)
                : null;

        final Map<String, ArgumentMeta> arguments = data.containsKey("arguments")
                ? data.getAsMap("arguments", String.class, ArgumentMeta.class)
                : new HashMap<>();

        final Boolean enabled = data.containsKey("enabled")
                ? data.get("enabled", Boolean.class)
                : null;

        return new CommandMeta(name, usage, description, permission, aliases.toArray(new String[0]), playerOnly, arguments, null);
    }
}
