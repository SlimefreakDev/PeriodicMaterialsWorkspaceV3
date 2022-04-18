package net.mcreator.periodicmaterials.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.periodicmaterials.item.UnknownGasGasTubeItem;
import net.mcreator.periodicmaterials.item.GasTubeItem;
import net.mcreator.periodicmaterials.PeriodicMaterialsMod;

import java.util.Map;

public class UnknownGasGasTubeEmptyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PeriodicMaterialsMod.LOGGER.warn("Failed to load dependency entity for procedure UnknownGasGasTubeEmpty!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(UnknownGasGasTubeItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(GasTubeItem.block);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
