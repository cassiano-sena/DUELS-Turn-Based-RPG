public class Character {
    String name; // name of the character e.g "Fred"
    String origin; // origin of the character e.g "Goblin"
    int health; // present health value at the time
    int healthValue; // total health value
    int defense; // total defense value
    int strength; // total strength value
    int dexterity; // total strength value
    int equippedItemId; // equipped item id

    public Character() {}
    public Character(String name, String origin,int health, int healthValue, int defense, int strength, int dexterity, int equippedItemId) {
        this.name = name;
        this.origin = origin;
        this.health = health;
        this.healthValue = healthValue;
        this.defense = defense;
        this.strength = strength;
        this.dexterity = dexterity;
        this.equippedItemId = equippedItemId;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getEquippedItemId() {
        return equippedItemId;
    }

    public void setEquippedItemId(int equippedItemId) {
        this.equippedItemId = equippedItemId;
    }
}
