
package net.mcreator.periodicmaterials.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.periodicmaterials.item.GasTubeItem;
import net.mcreator.periodicmaterials.PeriodicMaterialsModElements;

@PeriodicMaterialsModElements.ModElement.Tag
public class PeriodicMaterialsGasesItemGroup extends PeriodicMaterialsModElements.ModElement {
	public PeriodicMaterialsGasesItemGroup(PeriodicMaterialsModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabperiodic_materials_gases") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GasTubeItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
