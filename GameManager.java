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
        int expGained = calculateExperienceGained();
        this.experiencePoints += expGained;

        checkLevelUp(player);
    }

    private int calculateExperienceGained() {
        return 100;
    }

    private void checkLevelUp(Player player) {
        if (experiencePoints >= 100 * level) {
            level++;
            System.out.println("Você subiu para o nível " + level + "!");

            // Capturando os valores antigos
            int oldStrength = player.getSelectedClass().getStrength();
            int oldMaxHealth = player.getSelectedClass().getMaxHealth();
            int oldDexterity = player.getSelectedClass().getDexterity();
            int oldDefense = player.getSelectedClass().getDefense();

            // Atualizando os atributos
            player.getSelectedClass().setStrength(oldStrength + 5);
            player.getSelectedClass().setMaxHealth(oldMaxHealth + 5);
            player.getSelectedClass().setDexterity(oldDexterity + 5);
            player.getSelectedClass().setDefense(oldDefense + 5);

            // Capturando os novos valores após a atualização
            int newStrength = player.getSelectedClass().getStrength();
            player.setHealth(player.getSelectedClass().getMaxHealth());
            int newMaxHealth = player.getSelectedClass().getMaxHealth();
            int newDexterity = player.getSelectedClass().getDexterity();
            int newDefense = player.getSelectedClass().getDefense();

            // Imprimindo as mudanças
            System.out.println("Força: " + oldStrength + " > " + newStrength + "!");
            System.out.println("Destreza: " + oldDexterity + " > " + newDexterity + "!");
            System.out.println("Vida Máxima: " + oldMaxHealth + " > " + newMaxHealth + "!");
            System.out.println("Defesa: " + oldDefense + " > " + newDefense + "!");
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
