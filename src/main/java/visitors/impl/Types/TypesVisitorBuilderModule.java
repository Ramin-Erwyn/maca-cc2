package visitors.impl.Types;

import com.google.inject.AbstractModule;
import visitors.api.TypesVisitorBuilder;

/**
 * Binds annotated {@link TypesVisitorBuilder} interface to its implementation, for dependency injection.
 * @see <a href="https://github.com/google/guice/wiki/GettingStarted">Guice documentation</a>.
 */
public final class TypesVisitorBuilderModule extends AbstractModule {

    public TypesVisitorBuilderModule() {
        super();
    }

    @Override
    protected void configure() {
       bind(TypesVisitorBuilder.class)
               .annotatedWith(TypesVisitorBuilder.FileTypes.class)
               .to(TypesVisitorBuilderImpl.class);
    }
}
