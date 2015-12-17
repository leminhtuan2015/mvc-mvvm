package com.leminhtuan.mvc_mvvm.components;

import com.leminhtuan.mvc_mvvm.connection.Connection;
import com.leminhtuan.mvc_mvvm.modules.ConnectionModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ConnectionModule.class})
public interface ConnectionComponent {
    Connection provideConnection();
}
