import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Enemy extends Character {
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private GameProcess gameProcess;

    public Enemy(String name, String origin, Classes selectedClass, Item equippedItem, int status, GameProcess gameProcess) {
        super(name, origin, selectedClass, equippedItem, String.valueOf(status));
        this.selectedClass = selectedClass;
        this.gameProcess = gameProcess;
    }

    public void performAction(Player player) {
        //System.out.println("Turno de " + name + "!");
        int choice = random.nextInt(3) + 1;

        switch (choice) {
            case 1:
                System.out.println("O inimigo irá atacar!");
                attack(player);
                waitFor(3);
                break;
            case 2:
                System.out.println("O inimigo irá usar uma poção!");
                heal();
                waitFor(3);
                break;
            case 3:
                System.out.println("O inimigo irá analisar o jogador!");
                viewPlayer(player);
                waitFor(3);
                break;
            default:
                System.out.println(name + " está indeciso...");
                waitFor(3);
                break;
        }
    }

    private void attack(Player player) {
        Item equippedItem = getEquippedItem();

        if (equippedItem != null) {
            List<Attack> itemActions = equippedItem.getItemActions();
            if (itemActions != null && !itemActions.isEmpty()) {
                int actionIndex = random.nextInt(itemActions.size());
                Attack selectedAttack = itemActions.get(actionIndex);
                System.out.println(name + " usou " + selectedAttack.getName() + "!");
                waitFor(2);
                int damage = CombatManager.calculateDamage(gameProcess.enemy, player, selectedAttack);
                System.out.println("Dano causado: " + damage);
                player.takeDamage(damage);
            } else {
                System.out.println("Esta arma não possui ataques disponíveis.");
            }
        } else {
            System.out.println("Nenhuma arma equipada.");
        }
    }

    protected void heal() {
        Random random = new Random();
        int healAmount = random.nextInt(10) + 1;
        int healthCheck = gameProcess.enemy.getHealth() + healAmount;
        if(healthCheck > gameProcess.enemy.getSelectedClass().getMaxHealth()){
            System.out.println(gameProcess.enemy.getName()+" recebeu sobrevida de " + healAmount + " pontos!");
        }
        this.health += healAmount;
        System.out.println(name + " se curou e restaurou " + healAmount + " de vida!");
    }

    public void viewPlayer(Player player) {
        System.out.println("---- Detalhes do Jogador ----");
        System.out.println("Nome: " + player.getName());
        System.out.println("Raça: " + player.getOrigin());
        System.out.println("Classe: " + player.getSelectedClass().getName());
        System.out.println("Arma: " + player.getEquippedItem().getName());
        System.out.println("Força: " + player.getSelectedClass().getStrength());
        System.out.println("Destreza: " + player.getSelectedClass().getDexterity());
        System.out.println("Vida: " + player.getHealth() + "/" + player.getSelectedClass().getMaxHealth());
        System.out.println("Defesa: " + player.getSelectedClass().getDefense());
        System.out.println("-----------------------------");
    }

    @Override
    public void useSkill() {
        System.out.println(name + " usa uma habilidade especial!");
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Converte segundos para milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
