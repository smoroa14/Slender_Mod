package virusmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class VirusEssence extends Item{

    public VirusEssence(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
