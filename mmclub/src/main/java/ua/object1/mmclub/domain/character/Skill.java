package ua.object1.mmclub.domain.character;

public class Skill
{
    private int sword;
    private int spear;
    private int axe;
    private int mace;
    private int dagger;

    public Skill() {
    }

    public int getSword() {
        return sword;
    }

    public void setSword(int sword) {
        this.sword = sword;
    }

    public int getSpear() {
        return spear;
    }

    public void setSpear(int spear) {
        this.spear = spear;
    }

    public int getAxe() {
        return axe;
    }

    public void setAxe(int axe) {
        this.axe = axe;
    }

    public int getMace() {
        return mace;
    }

    public void setMace(int mace) {
        this.mace = mace;
    }

    public int getDagger() {
        return dagger;
    }

    public void setDagger(int dagger) {
        this.dagger = dagger;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Skill{");
        sb.append("sword=").append(sword);
        sb.append(", spear=").append(spear);
        sb.append(", axe=").append(axe);
        sb.append(", mace=").append(mace);
        sb.append(", dagger=").append(dagger);
        sb.append('}');
        return sb.toString();
    }
}
