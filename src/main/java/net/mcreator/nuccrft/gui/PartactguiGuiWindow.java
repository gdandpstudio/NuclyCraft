
package net.mcreator.nuccrft.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PartactguiGuiWindow extends ContainerScreen<PartactguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PartactguiGui.guistate;

	public PartactguiGuiWindow(PartactguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 265;
		this.ySize = 203;
	}

	private static final ResourceLocation texture = new ResourceLocation("nuccrft:textures/screens/partactgui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "1: " + (entity.getPersistentData().getString("ug1")) + "", 60, 16, -12829636);
		this.font.drawString(ms, "2: " + (entity.getPersistentData().getString("ug2")) + "", 60, 34, -12829636);
		this.font.drawString(ms, "3: " + (entity.getPersistentData().getString("ug3")) + "", 60, 52, -12829636);
		this.font.drawString(ms, "4: " + (entity.getPersistentData().getString("ug4")) + "", 60, 70, -12829636);
		this.font.drawString(ms, "5: " + (entity.getPersistentData().getString("ug5")) + "", 60, 88, -12829636);
		this.font.drawString(ms, "6: " + (entity.getPersistentData().getString("ug6")) + "", 159, 16, -12829636);
		this.font.drawString(ms, "7: " + (entity.getPersistentData().getString("ug7")) + "", 159, 34, -12829636);
		this.font.drawString(ms, "8: " + (entity.getPersistentData().getString("ug8")) + "", 159, 52, -12829636);
		this.font.drawString(ms, "9: " + (entity.getPersistentData().getString("ug9")) + "", 159, 70, -12829636);
		this.font.drawString(ms, "10: " + (entity.getPersistentData().getString("ug10")) + "", 159, 88, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
