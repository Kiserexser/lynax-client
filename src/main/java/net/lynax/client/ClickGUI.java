
package net.lynax.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ClickGUI implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        new Thread(() -> {
            while (true) {
                long window = MinecraftClient.getInstance().getWindow().getHandle();

                if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_RIGHT_SHIFT) == 1) {
                    MinecraftClient.getInstance().setScreen(new Menu());
                }

                try { Thread.sleep(100); } catch (Exception ignored) {}
            }
        }).start();
    }

    public static class Menu extends Screen {
        protected Menu() {
            super(Text.literal("Lynax Client"));
        }

        @Override
        public void render(net.minecraft.client.gui.DrawContext ctx, int x, int y, float delta) {
            renderBackground(ctx);
            ctx.fill(0, 0, width, height, 0xEFFFFFFF);

            drawCenteredText(textRenderer, Text.literal("Lynax Client"), width/2, 20, 0x000000);
            drawCenteredText(textRenderer, Text.literal("FPS Boost / PvP Mode"), width/2, 60, 0x000000);

            super.render(ctx, x, y, delta);
        }
    }
}
