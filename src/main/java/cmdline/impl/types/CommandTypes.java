package cmdline.impl.types;

import cmdline.api.TypesParams;
import cmdline.impl.common.CommandBase;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.google.inject.Guice;
import com.google.inject.Injector;
import visitors.api.Visitor;
import visitors.impl.Types.TypesVisitorBuilderModule;

/**
 * Files and directories types command line implementation. The files or directories are provided as arguments.
 * The types is about:
 * - each file
 * - each directory
 * - the total of (only) all files types, which is the default behavior.
 * <p>
 * An alternative behavior is to display each directory types as the sum of contained files or subdirectories.
 * As a consequence, the types of an empty directory is zero.
 * <p>
 * Another alternative behavior is to include the types of directories in the total, while displaying
 * each directory types as in the default behavior.
 */
@Parameters(commandNames = {"types"}, commandDescription = "Shows types of files or directories. " +
        "Default behavior includes only files types in the total, while showing each directory's own types.")
public final class CommandTypes extends CommandBase {

    private static final String NAME = "types";

    @ParametersDelegate
    private final TypesParams params = new TypesParamsImpl();

    public CommandTypes() {
        super();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute(JCommander jc) {
        if (isDisplayHelp(params.isHelp(), jc))
            return;

        if (bothOptionsFilesNDirectories()) {
            System.err.println("Parameters -f and -d are mutually exclusive. " +
                    "Use only one of them at each invocation.");
            return;
        }

        buildComponentTree(params.getPaths());

        Injector injector = Guice.createInjector(new TypesVisitorBuilderModule());
        TypesVisitorBuilderDirector director = injector.getInstance(TypesVisitorBuilderDirector.class);
        Visitor visitor = director.buildVisitor(params).getVisitor();
        components.forEach(c -> c.accept(visitor));
        visitor.print();

    }

    private boolean bothOptionsFilesNDirectories() {
        return params.isFilesOnly() && params.isIncludeDirectories();
    }
}
