package sberleasing.api.extension;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static sberleasing.api.spec.Specifications.installSpecification;

public class ApiExtension implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        installSpecification();
    }
}
