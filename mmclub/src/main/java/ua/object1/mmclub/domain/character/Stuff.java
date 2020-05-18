package ua.object1.mmclub.domain.character;

public class Stuff
{
    private int money;
    private int maxWeigth;

    public Stuff() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMaxWeigth() {
        return maxWeigth;
    }

    public void setMaxWeigth(int maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stuff{");
        sb.append("money=").append(money);
        sb.append(", maxWeigth=").append(maxWeigth);
        sb.append('}');
        return sb.toString();
    }
}
