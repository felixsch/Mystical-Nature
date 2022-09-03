package net.marwinka.mysticalcrops.tools;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DiamondKnife extends SwordItem {
    public DiamondKnife(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.mysticalcrops.diamond_knife.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.mysticalcrops.diamond_knife.tooltip") );
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}