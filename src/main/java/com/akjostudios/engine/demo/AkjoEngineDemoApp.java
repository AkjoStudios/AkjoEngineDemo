package com.akjostudios.engine.demo;

import com.akjostudios.engine.api.AkjoApplication;
import com.akjostudios.engine.api.common.base.color.Color;
import com.akjostudios.engine.api.context.Component;
import com.akjostudios.engine.api.event.EventHandler;
import com.akjostudios.engine.api.window.events.AllWindowsClosedEvent;
import org.jetbrains.annotations.NotNull;

@Component
public class AkjoEngineDemoApp extends AkjoApplication {
    @Override
    public void onStart() {
        ctx.windows().create("Demo Application", ctx.monitors()::getPrimaryMonitor)
                .thenAccept(window -> window.onRender(() -> window.canvas().clear(Color.WHITE)));
    }

    @EventHandler
    public void onAllWindowsClosed(@NotNull AllWindowsClosedEvent ignored) {
        ctx.lifecycle().stopApplication("All windows have been closed.");
    }
}