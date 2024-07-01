import java.util.Random;

public class CombatManager {

    public static int calculateDamage(Character attacker, Character target, Attack attack) {
        int damage = 0;
        boolean hit = checkHit(attacker, target);

        if (hit) {
            damage = attack.getDamage();
            damage = applyDamageModifiers(attacker, target, damage, attack);
            if (attack.getAttackCount() > 1) {
                damage = applyMultiAttack(attacker, target, attack, damage);
            }
            applyStatusEffects(attacker, target, attack);
        } else {
            System.out.println("MISS");
        }

        return damage;
    }

    private static boolean checkHit(Character attacker, Character target) {
        Random random = new Random();
        int attackerDexterity = attacker.getSelectedClass().getDexterity();
        int targetDexterity = target.getSelectedClass().getDexterity();
        int hitChance = random.nextInt(101);

        int totalDexterity = attackerDexterity + targetDexterity;

        return hitChance <= totalDexterity;
    }

    private static int applyDamageModifiers(Character attacker, Character target, int damage, Attack attack) {
        String damageFormula = attack.getDamageFormula();

        if (damageFormula.equals("FOR")) {
            int attackerStrength = attacker.getSelectedClass().getStrength();
            damage += attackerStrength;
        } else if (damageFormula.equals("DES")) {
            int attackerDexterity = attacker.getSelectedClass().getDexterity();
            damage += attackerDexterity;
        }

        return damage;
    }

    private static int applyMultiAttack(Character attacker, Character target, Attack attack, int baseDamage) {
        int attackCount = attack.getAttackCount();
        int totalDamage = baseDamage * attackCount;
        return totalDamage;
    }

    private static void applyStatusEffects(Character attacker, Character target, Attack attack) {

    }

    private static boolean isCriticalHit() {
        Random random = new Random();
        int criticalChance = random.nextInt(101);
        return criticalChance <= 10;
    }

    public static void processTurn(Character attacker, Character target, Attack attack) {
        if (attacker.isWaitingNextTurn()) {
            System.out.println(attacker.getName() + " está esperando o próximo turno.");
            attacker.setWaitNextTurn(false);
            return;
        }

        if (attacker.isExhaustedNextTurn()) {
            System.out.println(attacker.getName() + " está exausto e perderá o próximo turno.");
            attacker.setExhaustedNextTurn(false);
            return;
        }

        int damage = calculateDamage(attacker, target, attack);

        if (isCriticalHit()) {
            System.out.println("Acerto Crítico!");
        }

        target.takeDamage(damage);

        System.out.println(attacker.getName() + " atacou " + target.getName() + " causando " + damage + " de dano.");
    }
}
