package simplepets.brainsynder.nms.entities.v1_13_R2.list;

import net.minecraft.server.v1_13_R2.World;
import simplepets.brainsynder.api.entity.passive.IEntityCodPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_13_R2.EntityFishPet;
import simplepets.brainsynder.nms.registry.v1_13_R2.Types;

public class EntityCodPet extends EntityFishPet implements IEntityCodPet {
    public EntityCodPet(World world, IPet pet) {
        super(Types.COD, world, pet);
    }

    public EntityCodPet(World world) {
        super(Types.COD, world);
    }
}
