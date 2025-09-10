package com.akjostudios.engine.demo;

import com.akjostudios.engine.api.AkjoApplication;
import com.akjostudios.engine.api.context.Component;

@Component
public class AkjoEngineDemoApp extends AkjoApplication {
    @Override
    public void onStart() { ctx.lifecycle().stopApplication(); }
}