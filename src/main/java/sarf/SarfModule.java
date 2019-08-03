package sarf;

import com.google.inject.AbstractModule;

public class SarfModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SarfDictionary.class).to(SarfDictionaryImpl.class);
    }
}
