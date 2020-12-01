package cmdline.api;

/**
 * Defines the API for specific parameters of the Types command line.
 */
public interface TypesParams extends CommonParams {
    boolean isFilesOnly();
    boolean isIncludeDirectories();
    boolean isTypes();
}
