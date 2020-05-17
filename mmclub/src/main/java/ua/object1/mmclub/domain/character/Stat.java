package ua.object1.mmclub.domain.character;

public class Stat
{
    private int strength;        /*сила персонажа*/
    private int strengthTotal;   /*сила персонажа c учетом вещей*/
    private int endurance;       /*Выносливость (Здоровье=Выносливость*5)*/
    private int enduranceTotal;  /*Выносливость (Здоровье=Выносливость*5)*/
    private int accuracy;        /*Точность перса (влияет на крит.удар)*/
    private int accuracyTotal;   /*Точность с уч. вещей перса*/
    private int dexterity;       /*Ловкость перса (влияет на уворот)*/
    private int dexterityTotal;  /*Ловкость перса с уч. вещей*/
    private int curHealth;       /*тек здоровье во время боя*/
    private int maxHealth;       /*Максимальное здоровье с учетом вещей*/
    private int unUsedPoints;    /*Неиспользованные очки для распределения в статы (сила, ловкость....)*/


    public Stat() {
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthTotal() {
        return strengthTotal;
    }

    public void setStrengthTotal(int strengthTotal) {
        this.strengthTotal = strengthTotal;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getEnduranceTotal() {
        return enduranceTotal;
    }

    public void setEnduranceTotal(int enduranceTotal) {
        this.enduranceTotal = enduranceTotal;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getAccuracyTotal() {
        return accuracyTotal;
    }

    public void setAccuracyTotal(int accuracyTotal) {
        this.accuracyTotal = accuracyTotal;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityTotal() {
        return dexterityTotal;
    }

    public void setDexterityTotal(int dexterityTotal) {
        this.dexterityTotal = dexterityTotal;
    }

    public int getCurHealth() {
        return curHealth;
    }

    public void setCurHealth(int curHealth) {
        this.curHealth = curHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getUnUsedPoints() {
        return unUsedPoints;
    }

    public void setUnUsedPoints(int unUsedPoints) {
        this.unUsedPoints = unUsedPoints;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stat{");
        sb.append("strength=").append(strength);
        sb.append(", strengthTotal=").append(strengthTotal);
        sb.append(", endurance=").append(endurance);
        sb.append(", enduranceTotal=").append(enduranceTotal);
        sb.append(", accuracy=").append(accuracy);
        sb.append(", accuracyTotal=").append(accuracyTotal);
        sb.append(", dexterity=").append(dexterity);
        sb.append(", dexterityTotal=").append(dexterityTotal);
        sb.append(", curHealth=").append(curHealth);
        sb.append(", maxHealth=").append(maxHealth);
        sb.append(", unUsedPoints=").append(unUsedPoints);
        sb.append('}');
        return sb.toString();
    }
}

