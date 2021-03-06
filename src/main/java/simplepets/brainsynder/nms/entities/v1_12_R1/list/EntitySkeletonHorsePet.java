package simplepets.brainsynder.nms.entities.v1_12_R1.list;

import net.minecraft.server.v1_12_R1.World;
import simplepets.brainsynder.api.Size;
import simplepets.brainsynder.api.entity.passive.IEntitySkeletonHorsePet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_12_R1.branch.EntityHorseChestedAbstractPet;
import simplepets.brainsynder.wrapper.EntityWrapper;

@Size(width = 1.4F, length = 1.6F)
public class EntitySkeletonHorsePet extends EntityHorseChestedAbstractPet implements IEntitySkeletonHorsePet {
    public EntitySkeletonHorsePet(World world) {
        super(world);
    }
    public EntitySkeletonHorsePet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    public EntityWrapper getEntityType() {
        return EntityWrapper.SKELETON_HORSE;
    }
}
