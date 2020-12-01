package visitors.impl.Types;

import cmdline.impl.common.SizeUnit;
import cmdline.impl.common.TypesUnit;
import visitors.api.TypesVisitorBuilder;
import visitors.api.Visitor;
import visitors.api.VisitorBuilder;

/**
 * Concrete builder of {@link TypesVisitor} implementing {@link TypesVisitorBuilder}
 */
final class TypesVisitorBuilderImpl implements TypesVisitorBuilder {

    private final TypesVisitor visitor;

    TypesVisitorBuilderImpl() {
        visitor = new TypesVisitor();
    }

    @Override
    public void setTypesUnit(TypesUnit typesUnit) {
        visitor.setTypesUnit(typesUnit);
        return ;
    }

    @Override
    public TypesVisitorBuilder setIncludeFilesOnly(boolean option) {
        visitor.setIncludeFilesOnly(option);
        return this;
    }

    @Override
    public TypesVisitorBuilder setIncludeDirectories(boolean option) {
        visitor.setIncludeDirectories(option);
        return this;
    }

    @Override
    public TypesVisitorBuilder setIsTypes(boolean option) {
        visitor.setIsTypes(option);
        return this;
    }


    @Override
    public VisitorBuilder setSizeUnit(SizeUnit sizeUnit) {
        visitor.setSizeUnit(sizeUnit);
        return this;
    }

    @Override
    public Visitor build() {
        return visitor;
    }
}
