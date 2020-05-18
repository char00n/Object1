package ua.object1.mmclub.domain.character;

public class Slot
{
    private int helmet;
    private int shield;
    private int weapon;
    private int gloves;
    private int shoes;
    private int armor;
    private int necklace;
    private int ring1;
    private int ring2;
    private int ring3;
    private int ring4;
    private int ear;
    private int belt;

    public Slot() {
    }

    public int getHelmet() {
        return helmet;
    }

    public void setHelmet(int helmet) {
        this.helmet = helmet;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getGloves() {
        return gloves;
    }

    public void setGloves(int gloves) {
        this.gloves = gloves;
    }

    public int getShoes() {
        return shoes;
    }

    public void setShoes(int shoes) {
        this.shoes = shoes;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getNecklace() {
        return necklace;
    }

    public void setNecklace(int necklace) {
        this.necklace = necklace;
    }

    public int getRing1() {
        return ring1;
    }

    public void setRing1(int ring1) {
        this.ring1 = ring1;
    }

    public int getRing2() {
        return ring2;
    }

    public void setRing2(int ring2) {
        this.ring2 = ring2;
    }

    public int getRing3() {
        return ring3;
    }

    public void setRing3(int ring3) {
        this.ring3 = ring3;
    }

    public int getRing4() {
        return ring4;
    }

    public void setRing4(int ring4) {
        this.ring4 = ring4;
    }

    public int getEar() {
        return ear;
    }

    public void setEar(int ear) {
        this.ear = ear;
    }

    public int getBelt() {
        return belt;
    }

    public void setBelt(int belt) {
        this.belt = belt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Slot{");
        sb.append("helmet=").append(helmet);
        sb.append(", shield=").append(shield);
        sb.append(", weapon=").append(weapon);
        sb.append(", gloves=").append(gloves);
        sb.append(", shoes=").append(shoes);
        sb.append(", armor=").append(armor);
        sb.append(", necklace=").append(necklace);
        sb.append(", ring1=").append(ring1);
        sb.append(", ring2=").append(ring2);
        sb.append(", ring3=").append(ring3);
        sb.append(", ring4=").append(ring4);
        sb.append(", ear=").append(ear);
        sb.append(", belt=").append(belt);
        sb.append('}');
        return sb.toString();
    }
}
