public class Attack {
    private int id; // id do ataque
    private String name; // nome do ataque
    private String description; // descrição do ataque
    private static String damageFormula; // formula para o calculo do ataque, serve para informar o jogador de como é feito o calculo
    private int damage; // o dano real do ataque
    private int hitChance; // chance de acerto
    private String effect; // efeitos secundários do ataque
    private double criticalChance; // modificador da chance de crítico, deve poder ser alterado para garantir ou aumentar a chance
    private boolean skipThisTurn; // variavel para se o ataque acontece no proximo turno do atacante
    private boolean skipNextTurn; // variavel para se o ataque pula o próximo turno do atacante

    public Attack(int id, String name, String description, String damageFormula, int damage, int hitChance, String effect, double criticalChance, boolean skipThisTurn, boolean skipNextTurn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.damageFormula = damageFormula;
        this.hitChance = hitChance;
        this.effect = effect;
        this.criticalChance = criticalChance;
        this.skipThisTurn = skipThisTurn;
        this.skipNextTurn = skipNextTurn;
    }

    // Método para reduzir a vida do alvo com base no dano calculado
    public void applyDamage(Character target, int damage) {
        // Reduz a vida do alvo com base no dano recebido
        target.takeDamage(damage);
    }

    // Métodos getters para obter informações do ataque
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static String getDamageFormula() {
        return damageFormula;
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

    // Método para obter o dano base do ataque
    public static int getBaseDamage() {
        // Aqui você pode retornar o dano base do ataque
        // Exemplo simples, você pode ajustar conforme sua implementação
        return 10; // Valor base do dano, você pode ajustar conforme necessário
    }

    public int getActionId() {
        return id;
    }
}