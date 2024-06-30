import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Player extends Character {
    private final Classes selectedClass; // Armazena a classe específica do jogador
    private final Scanner scanner = new Scanner(System.in);
    private GameProcess gameProcess;

    public Player(String name, String origin, Classes selectedClass, Item equippedItem, int status, GameProcess gameProcess) {
        super(name, origin, selectedClass, equippedItem, String.valueOf(status)); // Passando selectedClass diretamente
        this.selectedClass = selectedClass;
        this.gameProcess = gameProcess;
    }

    //@Override
    public void performAction(Enemy target) {
        System.out.println("Sua vez de agir!");
        System.out.println("Escolha sua ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Usar Poção");
        System.out.println("3 - Analisar Inimigo");
        System.out.println("4 - Fugir");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                attack(target);
                waitFor(4);
                break;
            case 2:
                System.out.println("Curando...");
                heal();
                waitFor(4);
                break;
            case 3:
                System.out.println("Analisando...");
                viewEnemy(target);
                waitFor(4);
                break;
            case 4:
                System.out.println("Você tenta fugir...");
                waitFor(2);
                if (attemptEscape()) {
                    System.out.println("Você conseguiu fugir!");
                    waitFor(2);
                    break;
                } else {
                    System.out.println("Não foi possível fugir!");
                    waitFor(2);
                }
                break;
            default:
                System.out.println("Opção inválida.");
                scanner.nextLine();
                break;
        }
    }

    private void attack(Enemy target) {
        Item equippedItem = getEquippedItem();

        if (equippedItem != null) {
            System.out.println("Arma Equipada:");
            System.out.println("Nome: " + equippedItem.getName());
            System.out.println("Descrição: " + equippedItem.getDescription());

            List<Attack> itemActions = equippedItem.getItemActions();
            if (itemActions != null && !itemActions.isEmpty()) {
                System.out.println("Ataques Disponíveis:");
                for (int i = 0; i < itemActions.size(); i++) {
                    Attack attack = itemActions.get(i);
                    System.out.println((i + 1) + " - " + attack.getName() + ": " + attack.getDescription());
                    System.out.println("    Dano: " + attack.getDamageFormula());
                }
                System.out.print("Escolha o ataque: ");
                int actionIndex = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha após o nextInt()

                if (actionIndex >= 1 && actionIndex <= itemActions.size()) {
                    Attack selectedAttack = itemActions.get(actionIndex - 1);
                    System.out.println("Você usou " + selectedAttack.getName() + "!");
                    //int damage = calculateDamage(selectedAttack.getDamageFormula());
                    int damage = calculateDamage(gameProcess.player, target);
                    System.out.println("Dano causado: " + damage);
                    target.takeDamage(damage); // Aplicar dano ao inimigo
                } else {
                    System.out.println("Opção de ataque inválida.");
                }
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
        System.out.println("Você usou uma poção e restaurou " + healAmount + " de vida!");
    }

    public boolean attemptEscape() {
        Random random = new Random();
        int chance = random.nextInt(100); // Gera um número entre 0 e 99

        // Exemplo de uma chance de 30% de sucesso
        return chance < 30;
    }

    @Override
    public void equipItem(int itemId) {
        System.out.println("Equipando item ID " + itemId + "...");
        setEquippedItemById(itemId);
        System.out.println(getName() + " equipou " + getEquippedItem().getName() + ".");
    }

    @Override
    public void useSkill() {
        System.out.println(getName() + " usa uma habilidade especial de " + selectedClass.getName() + "!");
        // Implemente a lógica específica da habilidade, se necessário
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Converte segundos para milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void viewEnemy(Enemy enemy) {
        if (enemy != null) {
            System.out.println("---- Detalhes do Inimigo ----");
            System.out.println("Nome: " + enemy.getName());
            System.out.println("Raça: " + enemy.getOrigin());
            System.out.println("Classe: " + enemy.getSelectedClass().getName());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Inimigo desconhecido.");
        }
    }
}
