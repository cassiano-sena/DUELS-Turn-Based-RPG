public class GameManager {
    private int battlesWon;
    private int experiencePoints;
    private int level;

    public GameManager() {
        this.battlesWon = 0;
        this.experiencePoints = 0;
        this.level = 1;
    }

    public void addBattleWon() {
        this.battlesWon++;
        // Gere pontos de experiência ao vencer uma batalha
        int expGained = calculateExperienceGained();
        this.experiencePoints += expGained;

        // Verifica se o jogador subiu de nível
        checkLevelUp();
    }

    private int calculateExperienceGained() {
        // Lógica para calcular pontos de experiência ganhos
        return 100; // Exemplo simples, pode ser ajustado conforme a necessidade
    }

    private void checkLevelUp() {
        // Lógica para verificar se o jogador subiu de nível
        if (experiencePoints >= 100 * level) {
            level++;
            System.out.println("Você subiu para o nível " + level + "!");
        }
    }

    public int getBattlesWon() {
        return battlesWon;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getLevel() {
        return level;
    }
}
