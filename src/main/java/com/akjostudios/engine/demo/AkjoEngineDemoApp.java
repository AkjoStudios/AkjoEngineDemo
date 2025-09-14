package com.akjostudios.engine.demo;

import com.akjostudios.engine.api.AkjoApplication;
import com.akjostudios.engine.api.context.Component;
import com.akjostudios.engine.api.event.EventHandler;
import com.akjostudios.engine.api.window.WindowMode;
import com.akjostudios.engine.api.window.events.AllWindowsClosedEvent;
import org.jetbrains.annotations.NotNull;

@Component
public class AkjoEngineDemoApp extends AkjoApplication {
    @Override
    public void onStart() {
        ctx.scheduler().render().immediate(
                () -> ctx.windows().builder(
                        "Demo Application",
                        WindowMode.WINDOWED,
                        ctx.monitors()::getPrimaryMonitor,
                        true
                ).build()
        );
    }

    @EventHandler
    public void onAllWindowsClosed(@NotNull AllWindowsClosedEvent ignored) {
        ctx.lifecycle().stopApplication("All windows have been closed.");
    }
}