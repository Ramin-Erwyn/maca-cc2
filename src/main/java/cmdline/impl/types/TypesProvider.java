package cmdline.impl.types;

import cmdline.api.CommandLine;
import cmdline.api.CommandLineProvider;

/**
 * A provider for the Types command line.
 * @see CommandTypes
 */
public final class TypesProvider implements CommandLineProvider {
    @Override
    public CommandLine create() {
        return new CommandTypes();
    }
}
