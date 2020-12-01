package visitors.api;

import cmdline.impl.common.SizeUnit;
import cmdline.impl.common.TypesUnit;

/**
 * Basic visitor builder interface.
 */
public interface VisitorBuilder {
    VisitorBuilder setSizeUnit(SizeUnit sizeUnit);
    Visitor build();
    void setTypesUnit(TypesUnit typesUnit);
}
