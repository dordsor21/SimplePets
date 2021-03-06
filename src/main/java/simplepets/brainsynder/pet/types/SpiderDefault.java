package simplepets.brainsynder.pet.types;

import org.bukkit.Material;
import simple.brainsynder.sound.SoundMaker;
import simplepets.brainsynder.PetCore;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.entity.hostile.IEntitySpiderPet;
import simplepets.brainsynder.pet.PetDefault;
import simplepets.brainsynder.utils.ItemBuilder;
import simplepets.brainsynder.wrapper.EntityWrapper;

public class SpiderDefault extends PetDefault {
    public SpiderDefault(PetCore plugin) {
        super(plugin, "spider", SoundMaker.ENTITY_SPIDER_AMBIENT, EntityWrapper.SPIDER);
    }

    @Override
    public ItemBuilder getDefaultItem() {
        return new ItemBuilder(Material.SPIDER_EYE).withName("&f&lSpider Pet");
    }

    @Override
    public Class<? extends IEntityPet> getEntityClass() {
        return IEntitySpiderPet.class;
    }
}
