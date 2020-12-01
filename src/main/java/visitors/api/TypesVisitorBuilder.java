package visitors.api;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Definition for builder of Types visitor implementation.
 */
public interface TypesVisitorBuilder extends VisitorBuilder {
    /**
     * Annotates this builder so that it can be injected wherever it is required.
     * Placeholders for injection are fields, parameters, and methods.
     */
    @Qualifier
    @Target({FIELD, PARAMETER, METHOD})
    @Retention(RUNTIME)
    @interface FileTypes {}

    TypesVisitorBuilder setIncludeFilesOnly(boolean option);
    TypesVisitorBuilder setIncludeDirectories(boolean option);
    TypesVisitorBuilder setIsTypes(boolean option);

}
