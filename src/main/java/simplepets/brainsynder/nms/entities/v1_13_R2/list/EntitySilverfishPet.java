package simplepets.brainsynder.nms.entities.v1_13_R2.list;

import net.minecraft.server.v1_13_R2.World;
import simplepets.brainsynder.api.Size;
import simplepets.brainsynder.api.entity.hostile.IEntitySilverfishPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_13_R2.EntityPet;
import simplepets.brainsynder.nms.registry.v1_13_R2.Types;

@Size(width = 0.3F, length = 0.7F)
public class EntitySilverfishPet extends EntityPet implements IEntitySilverfishPet {
    public EntitySilverfishPet(World world) {
        super(Types.SILVERFISH, world);
    }
    public EntitySilverfishPet(World world, IPet pet) {
        super(Types.SILVERFISH, world, pet);
    }
}
