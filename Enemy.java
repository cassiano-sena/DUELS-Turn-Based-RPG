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
        System.out.println("Turno de " + name + "!");
        int choice = random.nextInt(3) + 1; // Escolhe uma ação aleatória entre 1 e 3

        switch (choice) {
            case 1:
                attack(player);
                waitFor(3);
                break;
            case 2:
                heal();
                waitFor(3);
                break;
            case 3:
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
//                int damage = calculateDamage(selectedAttack.getDamageFormula());
                int damage = calculateDamage(gameProcess.enemy, player);
                System.out.println(name + " usou " + selectedAttack.getName() + "!");
                System.out.println("Dano causado: " + damage);
                player.takeDamage(damage); // Aplica dano ao jogador
            } else {
                System.out.println("Esta arma não possui ataques disponíveis.");
            }
        } else {
            System.out.println("Nenhuma arma equipada.");
        }
    }

    private void heal() {
        Random random = new Random();
        int healAmount = random.nextInt(10) + 1;
        this.health += healAmount;
        System.out.println(name + " se curou e restaurou " + healAmount + " de vida!");
    }

    private void viewPlayer(Player player) {
        System.out.println("Analisando " + player.getName() + "...");
        System.out.println("Nome: " + player.getName());
        System.out.println("Origem: " + player.getOrigin());
        System.out.println("Classe: " + player.getSelectedClass());
        System.out.println("Vida: " + player.getHealth() + "/" + player.getSelectedClass().getMaxHealth());
        System.out.println("Defesa: " + player.getSelectedClass().getDefense());
    }

    @Override
    public void useSkill() {
        System.out.println(name + " usa uma habilidade especial!");
        // Implemente a lógica da habilidade se necessário
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Converte segundos para milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
