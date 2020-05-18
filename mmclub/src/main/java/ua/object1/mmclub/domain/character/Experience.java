package ua.object1.mmclub.domain.character;

public class Experience
{
    private int level;
    private int currentExp;
    private int nextExp;

    public Experience() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getNextExp() {
        return nextExp;
    }

    public void setNextExp(int nextExp) {
        this.nextExp = nextExp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Experience{");
        sb.append("level=").append(level);
        sb.append(", currentExp=").append(currentExp);
        sb.append(", nextExp=").append(nextExp);
        sb.append('}');
        return sb.toString();
    }
}
