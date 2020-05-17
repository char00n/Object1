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


}

