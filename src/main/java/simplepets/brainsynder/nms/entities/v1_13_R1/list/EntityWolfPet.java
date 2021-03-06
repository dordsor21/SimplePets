package simplepets.brainsynder.nms.entities.v1_13_R1.list;

import net.minecraft.server.v1_13_R1.*;
import simple.brainsynder.nbt.StorageTagCompound;
import simplepets.brainsynder.api.Size;
import simplepets.brainsynder.api.entity.passive.IEntityWolfPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_13_R1.EntityTameablePet;
import simplepets.brainsynder.nms.registry.v1_13_R1.Types;
import simplepets.brainsynder.wrapper.DyeColorWrapper;

@Size(width = 0.6F, length = 0.8F)
public class EntityWolfPet extends EntityTameablePet implements IEntityWolfPet {
    private static final DataWatcherObject<Float> DATA_HEALTH;
    private static final DataWatcherObject<Boolean> BEGGING;
    private static final DataWatcherObject<Integer> COLLAR_COLOR;

    static {
        DATA_HEALTH = DataWatcher.a(EntityWolfPet.class, DataWatcherRegistry.c);
        BEGGING = DataWatcher.a(EntityWolfPet.class, DataWatcherRegistry.i);
        COLLAR_COLOR = DataWatcher.a(EntityWolfPet.class, DataWatcherRegistry.b);
    }

    public EntityWolfPet(World world) {
        super(Types.WOLF, world);
    }
    public EntityWolfPet(World world, IPet pet) {
        super(Types.WOLF, world, pet);
    }

    protected void registerDatawatchers() {
        super.registerDatawatchers();
        this.datawatcher.register(DATA_HEALTH, this.getHealth());
        this.datawatcher.register(BEGGING, Boolean.FALSE);
        this.datawatcher.register(COLLAR_COLOR, EnumColor.RED.getColorIndex());
    }

    @Override
    public StorageTagCompound asCompound() {
        StorageTagCompound object = super.asCompound();
        object.setInteger("color", getColor().ordinal());
        object.setBoolean("angry", isAngry());
        object.setBoolean("tilted", isHeadTilted());
        return object;
    }

    @Override
    public void applyCompound(StorageTagCompound object) {
        if (object.hasKey("angry")) setAngry(object.getBoolean("angry"));
        if (object.hasKey("tilted")) setHeadTilted(object.getBoolean("tilted"));
        if (object.hasKey("color")) setColor(DyeColorWrapper.values()[object.getInteger("color")]);
        super.applyCompound(object);
    }

    public void setTamed(boolean flag) {
        if (this.isAngry() && flag) {
            this.setAngry(false);
        }

        super.setTamed(flag);
    }

    @Override
    public boolean isAngry() {
        return (this.datawatcher.get(TAME_SIT) & 2) != 0;
    }

    @Override
    public void setAngry(boolean flag) {
        if (this.isTamed() && flag) {
            this.setTamed(false);
        }

        byte b0 = this.datawatcher.get(TAME_SIT);
        if (flag) {
            this.datawatcher.set(TAME_SIT, (byte) (b0 | 2));
        } else {
            this.datawatcher.set(TAME_SIT, (byte) (b0 & -3));
        }

    }

    @Override
    public DyeColorWrapper getColor() {
        return DyeColorWrapper.getByDyeData((byte) ((int) getDataWatcher().get(COLLAR_COLOR)));
    }

    public void setColor(DyeColorWrapper dc) {
        if (isTamed()) {
            this.datawatcher.set(COLLAR_COLOR, (int) dc.getDyeData());
        }
    }

    @Override
    public boolean isHeadTilted() {
        return datawatcher.get(BEGGING);
    }

    @Override
    public void setHeadTilted(boolean var) {
        datawatcher.set(BEGGING, var);
    }
}
