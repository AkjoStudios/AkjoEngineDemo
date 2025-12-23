package com.akjostudios.engine.demo;

import com.akjostudios.engine.api.AkjoApplication;
import com.akjostudios.engine.api.assets.texture.Texture;
import com.akjostudios.engine.api.common.base.color.Color;
import com.akjostudios.engine.api.context.Component;
import com.akjostudios.engine.api.event.EventHandler;
import com.akjostudios.engine.api.resource.file.ResourcePath;
import com.akjostudios.engine.api.window.WindowPosition;
import com.akjostudios.engine.api.window.events.AllWindowsClosedEvent;
import org.jetbrains.annotations.NotNull;

@Component
public class AkjoEngineDemoApp extends AkjoApplication {
    private static final ResourcePath TEST = ResourcePath.classpath("assets:test.png");

    @Override
    public void onStart() {
        var testTexture = ctx.assets().preloadHandle(TEST, Texture.class);

        ctx.windows().create("Demo Application", ctx.monitors()::getPrimaryMonitor)
                .thenAccept(window -> window.onRender(() -> {
                    window.canvas().clear(Color.RED);
                    testTexture.ifReady(texture -> window.canvas().drawTexture(texture, WindowPosition.create(0, 0)));
                }));
    }

    @EventHandler
    public void onAllWindowsClosed(@NotNull AllWindowsClosedEvent ignored) {
        ctx.lifecycle().stopApplication("All windows have been closed.");
    }
}