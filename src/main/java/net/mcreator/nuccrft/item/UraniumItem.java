
package net.mcreator.nuccrft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.nuccrft.NuccrftModElements;

import java.util.List;

@NuccrftModElements.ModElement.Tag
public class UraniumItem extends NuccrftModElements.ModElement {
	@ObjectHolder("nuccrft:uranium")
	public static final Item block = null;

	public UraniumItem(NuccrftModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("uranium");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Uranium (92)"));
			list.add(new StringTextComponent("Atomic mass: 238"));
			list.add(new StringTextComponent("02891 (3)"));
			list.add(new StringTextComponent("Electron configuration:1s2 2s2 2p6 3s2 3p6 3d10 4s2 4p6 4d10 4f14 5s2 5p6 5d10 5f3 6s2 6p6 6d1 7s2"));
			list.add(new StringTextComponent("Electron core: K2 L8 M18 N32 O21 P9 Q2 R0"));
			list.add(new StringTextComponent("92 electrons"));
			list.add(new StringTextComponent("92 protons"));
			list.add(new StringTextComponent("146 neutrons"));
		}
	}
}
