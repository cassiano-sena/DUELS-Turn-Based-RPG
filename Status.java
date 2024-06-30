import java.util.ArrayList;
import java.util.List;

// Classe base para todos os efeitos de status
abstract class StatusEffect {
    protected String name;
    protected int duration; // Duração em número de turnos

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    // Método abstrato para aplicar o efeito de status ao personagem
    public abstract void applyEffect(Character character);

    // Método para verificar se o efeito ainda está ativo
    public boolean isActive() {
        return duration > 0;
    }

    // Método para diminuir a duração do efeito no início de cada turno
    public void decreaseDuration() {
        duration--;
    }

    public String getName() {
        return name;
    }
}

// Implementações específicas de efeitos de status

class StunStatus extends StatusEffect {
    private static int duration = 1;
    public StunStatus() {
    // public StunStatus(int duration) {
        super("Atordoamento", duration);
    }

    @Override
    public void applyEffect(Character character) {
        // Implementar lógica para atordoamento (perder próximo turno)
        System.out.println(character.getName() + " está atordoado!");
        character.setStunned(true);
    }
}

class BleedStatus extends StatusEffect {
    private int damagePerTurn = 5;
    private static int duration = 1;
    //public BleedStatus(int duration, int damagePerTurn) {
    public BleedStatus() {
        super("Sangramento", duration);
        //this.damagePerTurn = damagePerTurn;
    }

    @Override
    public void applyEffect(Character character) {
        // Implementar lógica para sangramento (dano por turno)
        int totalDamage = damagePerTurn;
        System.out.println(character.getName() + " sofre " + totalDamage + " de dano por sangramento!");
        character.takeDamage(totalDamage);
    }
}

class PoisonStatus extends StatusEffect {
    private int damagePerTurn = 5;
    private static int duration = 1;
    //public PoisonStatus(int duration, int damagePerTurn) {
    public PoisonStatus() {
        super("Veneno", PoisonStatus.duration);
        this.damagePerTurn = damagePerTurn;
    }

    @Override
    public void applyEffect(Character character) {
        // Implementar lógica para veneno (dano por turno)
        int totalDamage = damagePerTurn;
        System.out.println(character.getName() + " sofre " + totalDamage + " de dano por veneno!");
        character.takeDamage(totalDamage);
    }
}

class BurnStatus extends StatusEffect {
    private int damagePerTurn = 5;
    private static int duration = 5;

    //public BurnStatus(int duration, int damagePerTurn) {
    public BurnStatus() {
        super("Queimado", duration);
        this.damagePerTurn = damagePerTurn;
    }

    @Override
    public void applyEffect(Character character) {
        // Implementar lógica para queimado (dano por turno)
        int totalDamage = damagePerTurn;
        System.out.println(character.getName() + " sofre " + totalDamage + " de dano por queimadura!");
        character.takeDamage(totalDamage);
    }
}

class SleepStatus extends StatusEffect {
    private static int duration = 1;
    //public SleepStatus(int duration) {
    public SleepStatus() {
        super("Dormindo", duration);
    }

    @Override
    public void applyEffect(Character character) {
        // Implementar lógica para dormir (ficar sem agir)
        System.out.println(character.getName() + " está dormindo e não pode agir!");
        character.setSleeping(true);
    }
}
