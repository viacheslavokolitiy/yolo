package org.satorysoft.yolo.di.component;

import org.satorysoft.yolo.App;
import org.satorysoft.yolo.di.module.APIModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {APIModule.class})
@Singleton
public interface APIComponent {
    void inject(App app);
}
