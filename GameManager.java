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
        int expGained = calculateExperienceGained();
        this.experiencePoints += expGained;

        checkLevelUp();
    }

    private int calculateExperienceGained() {
        return 100;
    }

    private void checkLevelUp() {
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
