package me.masterkaiser.command;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class ArgumentUtil {
    public static boolean isArgument(@NotNull ArgumentMeta argumentMeta, @NotNull String arg) {
        if (argumentMeta.getName().equalsIgnoreCase(arg)) {
            return true;
        }

        if (argumentMeta.getAliases() != null) {
            return argumentMeta.getNotNullAliases().stream().anyMatch(s -> s.equalsIgnoreCase(arg));
        }

        return false;
    }
}
