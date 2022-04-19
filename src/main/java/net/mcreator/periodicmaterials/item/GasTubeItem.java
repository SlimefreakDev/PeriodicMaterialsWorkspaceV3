
package net.mcreator.periodicmaterials.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.periodicmaterials.procedures.GasTubeBasicFillProcedure;
import net.mcreator.periodicmaterials.itemgroup.PeriodicMaterialsGasesItemGroup;
import net.mcreator.periodicmaterials.PeriodicMaterialsModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@PeriodicMaterialsModElements.ModElement.Tag
public class GasTubeItem extends PeriodicMaterialsModElements.ModElement {
	@ObjectHolder("periodic_materials:gas_tube")
	public static final Item block = null;

	public GasTubeItem(PeriodicMaterialsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PeriodicMaterialsGasesItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("gas_tube");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A makeshift basic gas tube. It can't sort gases."));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			GasTubeBasicFillProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}
	}
}
