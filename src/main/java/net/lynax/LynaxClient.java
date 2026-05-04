
package net.lynax;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class LynaxClient implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("Lynax Client loaded");
    }

    public static void fpsBoost() {
        var client = MinecraftClient.getInstance();
        client.options.getViewDistance().setValue(6);
        client.options.getParticles().setValue(net.minecraft.client.option.ParticlesMode.MINIMAL);
    }

    public static void pvpMode() {
        var client = MinecraftClient.getInstance();
        client.options.getViewDistance().setValue(4);
    }
}
