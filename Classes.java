public abstract class Classes {
    protected String name;
    protected int maxHealth;
    protected int defense;
    protected int strength;
    protected int dexterity;

    public Classes(String name, int maxHealth, int defense, int strength, int dexterity) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.defense = defense;
        this.strength = strength;
        this.dexterity = dexterity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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
}

