package cmdline.impl.types;

import cmdline.api.TypesParams;
import cmdline.api.VisitorBuilderDirector;
import com.google.inject.Inject;
import visitors.api.TypesVisitorBuilder;
import visitors.api.Visitor;

/**
 * A director for the builder which creates the visitor for the Types command line.
 */
final class TypesVisitorBuilderDirector implements VisitorBuilderDirector<TypesParams> {
    @Inject
    @TypesVisitorBuilder.FileTypes
    private TypesVisitorBuilder builder;

    @Override
    public TypesVisitorBuilderDirector buildVisitor(TypesParams params) {
        builder.setIncludeFilesOnly(params.isFilesOnly())
                .setIncludeDirectories(params.isIncludeDirectories())
                .setIsTypes(params.isTypes())
                .setTypesUnit(params.getTypesUnit());
        return this;
    }

    @Override
    public Visitor getVisitor() {
        return builder.build();
    }
}
