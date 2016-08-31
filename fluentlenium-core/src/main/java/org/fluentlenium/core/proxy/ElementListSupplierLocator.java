package org.fluentlenium.core.proxy;

import com.google.common.base.Supplier;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.Collections;
import java.util.List;

public class ElementListSupplierLocator implements ElementLocator {
    private final Supplier<List<WebElement>> elementsSupplier;

    public ElementListSupplierLocator(Supplier<List<WebElement>> elementsSupplier) {
        this.elementsSupplier = elementsSupplier;
    }

    @Override
    public WebElement findElement() {
        List<WebElement> webElements = elementsSupplier.get();
        if (webElements !=null && !webElements.isEmpty()) {
            return webElements.iterator().next();
        }
        return null;
    }

    @Override
    public List<WebElement> findElements() {
        return this.elementsSupplier.get();
    }
}
