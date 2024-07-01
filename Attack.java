import java.util.Random;

public class Attack {
    private int id;
    private String name;
    private String description;
    private String damageFormula;
    private int damage;
    private int hitChance;
    private String effect;
    private int effectChance;
    private double criticalChance;
    private boolean skipThisTurn;
    private boolean skipNextTurn;
    private int attackCount;

    public Attack(int id, String name, String description, String damageFormula, int damage, int hitChance, String effect, int effectChance, double criticalChance, boolean skipThisTurn, boolean skipNextTurn, int attackCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.damageFormula = damageFormula;
        this.hitChance = hitChance;
        this.effect = effect;
        this.effectChance = effectChance;
        this.criticalChance = criticalChance;
        this.skipThisTurn = skipThisTurn;
        this.skipNextTurn = skipNextTurn;
        this.attackCount = attackCount;
    }

    public void attack(Character attacker, Character target) {
        // Verifica se há mais de um ataque a ser feito
        if (attackCount > 1) {
            // Realiza o número especificado de ataques
            for (int i = 0; i < attackCount; i++) {
                CombatManager.processTurn(attacker, target, this);
            }
        } else {
            CombatManager.processTurn(attacker, target, this);
        }
    }

    public void printDetails() {
        System.out.println("Realizando " + this.name);
        System.out.println(this.description);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDamageFormula() {
        return damageFormula;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitChance() {
        return hitChance;
    }

    public String getEffect() {
        return effect;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public boolean isSkipThisTurn() {
        return skipThisTurn;
    }

    public boolean isSkipNextTurn() {
        return skipNextTurn;
    }

    public int getAttackCount() {
        return attackCount;
    }
}