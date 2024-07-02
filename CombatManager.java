import java.util.Objects;
import java.util.Random;

public class CombatManager {

    public static int calculateDamage(Character attacker, Character target, Attack attack) {
        int damage = 0;
        boolean hit = checkHit(attacker, target);

        if (hit) {
            damage = attack.getDamage();
            damage = applyDamageModifiers(attacker, target, damage, attack);

            if (isCriticalHit(attack)) {
                System.out.println("Acerto Crítico!");
                damage *= 2;
            }

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
        } else if (damageFormula.equals("INT")) {
            int attackerIntelligence = attacker.getSelectedClass().getIntelligence();
            damage += attackerIntelligence;
        }

        return damage;
    }

    private static int applyMultiAttack(Character attacker, Character target, Attack attack, int baseDamage) {
        int attackCount = attack.getAttackCount();
        int totalDamage = baseDamage * attackCount;
        return totalDamage;
    }

    private static void applyStatusEffects(Character attacker, Character target, Attack attack) {
        String effect = attack.getEffect();
        double effectChance = attack.getEffectChance();
        Random random = new Random();
        int chance = random.nextInt(101);

        if (chance <= effectChance) {
            if (Objects.equals(effect, "espinhos") || Objects.equals(effect, "ricochete")){
                System.out.println(attacker.getName() + " foi afetado por " + effect + "!");
            }else {
                System.out.println(target.getName() + " foi afetado por " + effect + "!");
            }
            switch (effect.toLowerCase()) {
                case "sono":
                    target.setSleeping(true, 3);
                    break;
                case "fogo":
                    target.setBurning(true, 3);
                    break;
                case "atordoamento":
                    target.setStunned(true, 1);
                    break;
                case "veneno":
                    target.setPoisoned(true, 5);
                    break;
                case "espinhos":
                    attacker.setThorns(true, 5, 5);
                    break;
                case "curar":
                    target.heal();
                    break;
                case "ricochete":
                    attacker.setRecoil(true, 1,5);
                    break;
                case "sangramento":
                    target.setBleeding(true, 1,5);
                    break;
                default:
                    System.out.println("Efeito desconhecido: " + effect);
                    break;
            }
        }
    }

    private static boolean isCriticalHit(Attack attack) {
        Random random = new Random();
        int criticalChance = random.nextInt(101);
        return criticalChance <= attack.getCriticalChance() * 100; // Convertendo a chance crítica para porcentagem
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

        target.updateStatusEffects();
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " atacou " + target.getName() + " causando " + damage + " de dano.");

    }
}
