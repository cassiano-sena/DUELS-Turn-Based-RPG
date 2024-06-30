import java.util.Random;

public abstract class Weapon extends Item {
    private final Random random = new Random();

    public Weapon(int id, String name, String description) {
        super(id, name, description);
    }

    public abstract void attack(Player attacker, Player target);

    protected boolean performCriticalHit() {
        int chance = random.nextInt(100); // Gera um número aleatório de 0 a 99
        return chance < 20; // 20% de chance de golpe crítico (valor pode ser ajustado conforme necessário)
    }

    protected boolean performStatusEffect(int chance) {
        int roll = random.nextInt(100); // Gera um número aleatório de 0 a 99
        return roll < chance;
    }
}
