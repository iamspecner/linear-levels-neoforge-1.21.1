package com.wasadog91.linearlevels;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class LinearLevelsConfigScreen extends Screen {
    private final Screen parent;
    private EditBox xpBox;

    public LinearLevelsConfigScreen(Screen parent) {
        super(Component.literal("LinearLevels Config"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        // Position near the top, centered-ish but not at the edge
        int centerX = this.width / 2;

        // Text box for xpPerLevel
        xpBox = new EditBox(this.font,
                centerX + 60, 20, // x,y position (same line as label, offset right)
                80, 20,
                Component.literal("XP per level"));
        xpBox.setValue(String.valueOf(Config.XP_PER_LEVEL.get())); // load current value
        this.addRenderableWidget(xpBox);

        // Save button at bottom
        this.addRenderableWidget(Button.builder(Component.literal("Save"), b -> {
            try {
                int newValue = Integer.parseInt(xpBox.getValue());
                Config.XP_PER_LEVEL.set(newValue);   // update config value
                Config.SPEC.save();                  // persist to file
            } catch (NumberFormatException ignored) {}
            this.minecraft.setScreen(parent);        // return to Mods menu
        }).bounds(centerX - 90, this.height - 40, 80, 20).build());

        // Cancel button at bottom
        this.addRenderableWidget(Button.builder(Component.literal("Cancel"), b -> {
            this.minecraft.setScreen(parent);
        }).bounds(centerX + 10, this.height - 40, 80, 20).build());
    }

    @Override
    public void render(net.minecraft.client.gui.GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // Draw background
        this.renderBackground(graphics, mouseX, mouseY, partialTicks);

        // Draw children (text box, buttons)
        super.render(graphics, mouseX, mouseY, partialTicks);

        // Draw the label AFTER background so it’s crisp
        int centerX = this.width / 2;
        graphics.drawString(this.font, "XP per level", centerX - 100, 25, 0xFFFFFF);
    }
}