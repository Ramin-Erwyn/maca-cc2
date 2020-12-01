package visitors.impl.Types;

import cmdline.impl.common.TypesUnit;
import filesystem.api.Component;
import filesystem.api.Composite;
import utils.CommandLineTable;
import visitors.impl.common.VisitorImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static utils.TypesFormatter.formatTypes;
import static utils.TypesFormatter.translateTypesInUnit;

final class TypesVisitor extends VisitorImpl {

    public static final String Types = "Types";
    public static final String NAME = "Name";
    public static final String CONTENT = "Content";
    public static final String NB = "NB";


    private final CommandLineTable cmdLineTable;
    private final Map<Path, Long> dirTypes;
    private long totalTypes;
    private boolean includeFilesOnly;
    private boolean includeDirectories;
    private boolean withTypes;
    private Object TypesUnit;


    TypesVisitor() {
        super();
        cmdLineTable = new CommandLineTable();
        dirTypes = new HashMap<>();
    }

    @Override
    public void visit(Component visitable) {
        try {
            long Types = visitable.getTypes();
            totalTypes += Types;
            checkIncludeFileTypesOnly(visitable);
            cmdLineTable.addRow(visitable.getPath().toString(),
                    formatTypes(translateTypesInUnit(Types, (cmdline.impl.common.TypesUnit) TypesUnit)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(Composite<Component> visitable) {
        try {
            long Types = visitable.getTypes();
            checkIncludeDirTypes(Types);
            checkIncludeFileTypesOnly(visitable);
            visitable.getChildren().forEach(c -> c.accept(this));
            updateParentTypes(visitable);
            Types = getDirTypesToPrint(visitable);
            cmdLineTable.addRow(visitable.getPath().toString(),
                    formatTypes(translateTypesInUnit(Types, (cmdline.impl.common.TypesUnit) TypesUnit)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        initCmdLineTableHeaders();
        cmdLineTable.setShowVerticalLines(true);
        cmdLineTable.addFinalRow((withTypes?">>":"**") + TOTAL + WS + unitStr,
                formatTypes(translateTypesInUnit(totalTypes, (cmdline.impl.common.TypesUnit) TypesUnit)));
        cmdLineTable.print();
    }
    void setIncludeFilesOnly(boolean includeFilesOnly) {
        this.includeFilesOnly = includeFilesOnly;
    }

    void setIncludeDirectories(boolean includeDirectories) {
        this.includeDirectories = includeDirectories;
    }

    void setIsTypes(boolean withTypes) {
        this.withTypes = withTypes;
    }

    private void initCmdLineTableHeaders() {
        cmdLineTable.setHeaders(CONTENT,Types + WS + unitStr);
    }

    private void checkIncludeDirTypes(long types) {
        if (includeDirectories)
            totalTypes += types;
    }

    private void checkIncludeFileTypesOnly(Composite<Component> composite) {
        if (includeFilesOnly)
            dirTypes.put(composite.getPath(), 0L);
    }

    private void checkIncludeFileTypesOnly(Component component) throws IOException {
        if (includeFilesOnly) {
            long types = component.getTypes();
            dirTypes.computeIfPresent(component.getPath().getParent(), (k, v) -> Long.valueOf(v + Types));
        }
    }

    private void updateParentTypes(Composite<Component> composite) {
        if (includeFilesOnly) {
            long myTypes = dirTypes.get(composite.getPath());
            dirTypes.computeIfPresent(composite.getPath().getParent(), (k, v) -> v + myTypes);
        }
    }

    private long getDirTypesToPrint(Composite<Component> composite) throws IOException {
        if (includeFilesOnly)
            return dirTypes.get(composite.getPath());
        return composite.getTypes();
    }

}
