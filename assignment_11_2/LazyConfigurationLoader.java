// Lazy Configuration Loader
// Concepts: Supplier, Optional
// Assume you have a configuration setting that may or may not be loaded. Use a
// Supplier to lazily load the config value only if it's missing. Use Optional to simulate
// missing or present values and print the final result.
// Hint : Create a Supplier loadConfig which will have a configuration string.

import java.util.Optional;
import java.util.function.Supplier;

public class LazyConfigurationLoader {
    public static void main(String[] args) {
        Optional<String> configValue = Optional.empty();

        // Supplier to lazily load config if missing
        Supplier<String> loadConfig = () -> "LoadedDefaultConfig";

        String finalConfig = configValue.orElseGet(loadConfig);

        System.out.println("Final configuration: " + finalConfig);
    }
}