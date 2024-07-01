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
class PoisonousWeaponEffect extends StatusEffect {
    private int poisonChance;
    private int poisonDamage;

    public PoisonousWeaponEffect(int duration, int poisonChance, int poisonDamage) {
        super("imbuiu sua arma com veneno", duration);
        this.poisonChance = poisonChance;
        this.poisonDamage = poisonDamage;
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " imbuiu sua arma com veneno!");
    }

    public int getPoisonChance() {
        return poisonChance;
    }

    public void setPoisonChance(int poisonChance) {
        this.poisonChance = poisonChance;
    }

    public int getPoisonDamage() {
        return poisonDamage;
    }

    public void setPoisonDamage(int poisonDamage) {
        this.poisonDamage = poisonDamage;
    }
}
class FieryWeaponEffect extends StatusEffect {
    private int fireChance;
    private int fireDamage;

    public FieryWeaponEffect(int duration, int fireChance, int fireDamage) {
        super("imbuiu sua arma com fogo", duration);
        this.fireChance = fireChance;
        this.fireDamage = fireDamage;
    }

    @Override
    public void applyEffect(Character character) {
        System.out.println(character.getName() + " imbuiu sua arma com fogo!");
    }

    public int getFireChance() {
        return fireChance;
    }

    public void setFireChance(int fireChance) {
        this.fireChance = fireChance;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public void setFireDamage(int fireDamage) {
        this.fireDamage = fireDamage;
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
        System.out.println(character.getName() + " imbuir sua arma com espinhos!");
    }

    public int getDamageReturned() {
        return damageRecoiled;
    }

    public void setDamageReturned(int damageRecoiled) {
        this.damageRecoiled = RecoilEffect.this.damageRecoiled;
    }
}

