package simplepets.brainsynder.api.entity;

public interface ITameable extends IAgeablePet {
    boolean isTamed();

    void setTamed(boolean flag);

    boolean isSitting();

    void setSitting(boolean flag);
}
