abstract class StatusEffect {
    private String name;
    private int duration;

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public abstract void applyEffect(Character character);

    public void decreaseDuration() {
        duration--;
    }

    // Verifica se o efeito ainda está ativo
    public boolean isActive() {
        return duration > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
class BleedEffect extends StatusEffect {
    private int damagePerRound;

    public BleedEffect(int duration, int damagePerRound) {
        super("sangrando", duration);
        this.damagePerRound = damagePerRound;
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " está sangrando!");
        character.takeDamage(damagePerRound); // Aplica dano de sangramento imediatamente
    }

    public int getDamagePerRound() {
        return damagePerRound;
    }

    public void setDamagePerRound(int damagePerRound) {
        this.damagePerRound = damagePerRound;
    }
}

class SleepStatus extends StatusEffect {
    public SleepStatus(int duration) {
        super("sono", duration);
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " está ficando sonolento!");
    }
}
class StunStatus extends StatusEffect {
    public StunStatus(int duration) {
        super("atordoado", duration);
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " está atordoado!");
    }
}
class PoisonStatus extends StatusEffect {
    private int damagePerRound = 5;

    public PoisonStatus(int duration) {
        super("envenenado", duration);
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " está envenenado!");
    }

    public int getDamagePerRound() {
        return damagePerRound;
    }

    public void setDamagePerRound(int damagePerRound) {
        this.damagePerRound = damagePerRound;
    }
}
class BurnStatus extends StatusEffect {
    private int damagePerTurn = 3;

    public BurnStatus(int duration) {
        super("queimando", duration);
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " está pegando fogo!");
    }

    public int getDamagePerTurn() {
        return damagePerTurn;
    }

    public void setDamagePerTurn(int damagePerTurn) {
        this.damagePerTurn = damagePerTurn;
    }
}
class RecoilEffect extends StatusEffect {
    private int damageRecoiled = 5;

    public RecoilEffect(int damageReturned) {
        super("tomou dano de volta!",1);
        this.damageRecoiled = damageReturned;
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " tomou dano de volta!");
    }

    public int getDamageReturned() {
        return damageRecoiled;
    }

    public void setDamageReturned(int damageRecoiled) {
        this.damageRecoiled = RecoilEffect.this.damageRecoiled;
    }
}
class ThornsEffect extends StatusEffect {
    private int damagePerTurn = 5;

    public ThornsEffect(int duration) {
        super("queimando", duration);
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " está pegando fogo!");
    }

    public int getDamagePerTurn() {
        return damagePerTurn;
    }

    public void setDamagePerTurn(int damagePerTurn) {
        this.damagePerTurn = damagePerTurn;
    }
}
