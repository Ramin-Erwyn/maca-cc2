package cmdline.impl.size;

import cmdline.api.CommonParams;
import cmdline.api.SizeParams;
import cmdline.impl.common.CommonParamsImpl;
import cmdline.impl.common.SizeUnit;
import cmdline.impl.common.TypesUnit;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;

import java.nio.file.Path;
import java.util.List;

/**
 * Defines specific parameters for size command line.
 * Reuses {@link CommonParamsImpl}
 */
final class SizeParamsImpl implements SizeParams {

    @ParametersDelegate
    private final CommonParams commonParams = new CommonParamsImpl();

    @Parameter(names = {"-fs", "--include-files"}, description = "include files sizes only in total, " +
            "showing each directory total as contained files or subdirectories' total." +
            " This implies that en empty directory's size is 0")
    protected boolean filesOnly = false;

    @Parameter(names = {"-ds", "--include-directories"}, description = "include directories sizes also in total, " +
            "showing each directory own's size")
    protected boolean includeDirectories = false;

    @Parameter(names = {"-it", "--types"}, description = "affiche le type")
    protected boolean istypes = false;
    protected boolean isSize = false;


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

    @Override
    public boolean isSize() {
        return isSize;
    }
}
