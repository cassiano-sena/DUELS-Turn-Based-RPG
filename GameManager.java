public class GameManager {
    private int battlesWon;
    private int experiencePoints;
    private int level;
    //GameProcess gameProcess;

    public GameManager() {
        this.battlesWon = 0;
        this.experiencePoints = 0;
        this.level = 1;
    }

    public void addBattleWon(Player player) {
        this.battlesWon++;
//        int expGained = calculateExperienceGained();
//        this.experiencePoints += expGained;

        player.checkLevelUp();
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
