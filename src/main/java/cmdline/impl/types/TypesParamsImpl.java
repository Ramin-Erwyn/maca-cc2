package cmdline.impl.types;

import cmdline.api.CommonParams;
import cmdline.api.TypesParams;
import cmdline.impl.common.CommonParamsImpl;
import cmdline.impl.common.SizeUnit;
import cmdline.impl.common.TypesUnit;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;

import java.nio.file.Path;
import java.util.List;

/**
 * Defines specific parameters for type command line.
 * Reuses {@link CommonParamsImpl}
 */
final class TypesParamsImpl implements TypesParams {

    @ParametersDelegate
    private final CommonParams commonParams = new CommonParamsImpl();

    @Parameter(names = {"-fs", "--include-files"}, description = "include files types only in total, " +
            "showing each directory total as contained files or subdirectories' total." +
            " This implies that en empty directory's types is 0")
    protected boolean filesOnly = false;

    @Parameter(names = {"-ds", "--include-directories"}, description = "include directories Types also in total, " +
            "showing each directory own's types")
    protected boolean includeDirectories = false;

    @Parameter(names = {"-f", "--types"}, description = "affiche le type")
    protected boolean istypes = false;

    @Override
    public List<Path> getPaths() {
        return commonParams.getPaths();
    }

    @Override
    public SizeUnit getSizeUnit() {
        return commonParams.getSizeUnit();
    }

    @Override
    public TypesUnit getTypesUnit() {
        return commonParams.getTypesUnit();
    }

    @Override
    public boolean isHelp() {
        return commonParams.isHelp();
    }

    @Override
    public boolean isFilesOnly() {
        return filesOnly;
    }

    @Override
    public boolean isIncludeDirectories() {
        return includeDirectories;
    }

    @Override
    public boolean isTypes() {
        return istypes;
    }
}
