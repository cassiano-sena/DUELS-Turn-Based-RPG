import java.util.Random;
import java.util.Scanner;
import java.util.List;

class GameProcess {
    public Player player;
    public Enemy enemy;
    public GameManager gameManager;
    public final Scanner scanner = new Scanner(System.in);
    public boolean inBattle;

    public GameProcess() {
        this.gameManager = new GameManager();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("---- Menu Principal ----");
            System.out.println("Bem vindo à DUELS!");
            System.out.println("Esse jogo é um Turn-Based-RPG focado em duelos");
            System.out.println("\n");
            System.out.println("------------------------");
            System.out.println("1. Começar Batalha");
            System.out.println("2. Criar Personagem");
            System.out.println("3. Ver personagem");
            System.out.println("4. Ajuda");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (player != null) {
                        startBattle();
                    } else {
                        System.out.println("Por favor, crie um personagem primeiro.");
                    }
                    break;
                case 2:
                    createCharacter();
                    break;
                case 3:
                    if (player != null) {
                        viewCharacter();
                    } else {
                        System.out.println("Por favor, crie um personagem primeiro.");
                    }
                    break;
                case 4:
                    System.out.println("Crie um personagem, selecione sua classe e arma e parta para o combate!");
                    System.out.println("Classes ditam seus atributos como vida e defesa");
                    System.out.println("Armas possuem habilidades e danos característicos");
                    System.out.println("\n");
                    System.out.println("Vida é o total de dano que você pode receber antes de ser derrotado");
                    System.out.println("Defesa é o numero que será reduzido de ataques recebidos");
                    System.out.println("Força é o modificador de ataques que usam força");
                    System.out.println("Destreza é o modificador que determina ordem de combate, também serve como modificador para alguns ataques");
                    System.out.println("\n");
                    System.out.println("KNOWN FLAWS:");
                    System.out.println("- Efeito de Status não está corretamente implementado!");
                    System.out.println("- Algumas features como crítico e fuga nãao estão funcionando corretamente!");
                    System.out.println("- Criação de personagem não está funcionando corretamente após ganhar uma batalha!");
                    System.out.println("\n");
                    System.out.println("Pressione qualquer tecla...");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Saindo do jogo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void createCharacter() {
        System.out.println("Bem-vindo à criação de personagem!");

        String name = askForName();
        String origin = askForOrigin();

        int classChoice = selectCharacterClass();
        if (classChoice == -1) {
            System.out.println("Opção inválida. Reinicie a criação do personagem.");
            return;
        }

        Classes selectedClass = null;
        switch (classChoice) {
            case 1:
                selectedClass = new Warrior(name);
                break;
            case 2:
                selectedClass = new Mage(name);
                break;
            case 3:
                selectedClass = new Ranger(name);
                break;
            case 4:
                selectedClass = new Rogue(name);
                break;
            default:
                System.out.println("Classe inválida.");
                return;
        }

        player = new Player(name, origin, selectedClass, null, 0, this);

        equipCharacterWeapon(selectedClass, player);
        player.setSelectedClass(selectedClass);

        System.out.println("Personagem criado com sucesso!");
        viewCharacter();
    }

    private String askForName() {
        System.out.print("Digite o nome do personagem: ");
        return scanner.nextLine();
    }

    private String askForOrigin() {
        System.out.print("Digite a raça do personagem (e.g., Humano, Elfo): ");
        return scanner.nextLine();
    }

    private int selectCharacterClass() {
        System.out.println("Escolha a classe do personagem:");
        System.out.println("1. Guerreiro - Resistente e Poderoso");
        System.out.println("2. Mago - Conjurador de magias");
        System.out.println("3. Patrulheiro - Mantêm distância do inimigo");
        System.out.println("4. Ladino - Rápido e Letal");
        System.out.print("Sua escolha: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > 4) {
            System.out.println("Opção inválida.");
        }
        return choice;
    }

    private void equipCharacterWeapon(Classes selectedClass, Player player) {
        int weaponChoice = selectWeapon();

        if (weaponChoice != -1) {
            player.setEquippedItemById(weaponChoice);
        }
    }

    private int selectWeapon() {
        printWeaponOptions();
        System.out.print("Sua escolha: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > 12) {
            System.out.println("Opção inválida.");
            return -1;
        }
        return choice;
    }

    private void printWeaponOptions() {
        System.out.println("Escolha uma arma:");
        for (int i = 1; i <= 12; i++) {
            Item item = ItemManager.getItemById(i);
            if (item != null) {
                System.out.println(i + ". " + item.getName());
            }
        }
    }

    public void viewCharacter() {
        if (player == null) {
            System.out.println("Personagem não encontrado.");
            return;
        }

        System.out.println("---- Detalhes do Personagem ----");
        System.out.println("Nome: " + player.getName());
        System.out.println("Raça: " + player.getOrigin());
        System.out.println("Classe: " + player.getSelectedClass().getName());
        System.out.println("Arma: " + player.getEquippedItem().getName());
        System.out.println("Saúde: " + player.getHealth() + "/" + player.getSelectedClass().getMaxHealth());
        System.out.println("Defesa: " + player.getSelectedClass().getDefense());
        System.out.println("Força: " + player.getSelectedClass().getStrength());
        System.out.println("Destreza: " + player.getSelectedClass().getDexterity());
        System.out.println("Nível: " + gameManager.getLevel());
        System.out.println("Experiência: " + gameManager.getExperiencePoints());
        System.out.println("Batalhas ganhas: " + gameManager.getBattlesWon());
        System.out.println("-----------------------------");
    }


    private void startBattle() {
        int roundCount = 1;
        System.out.println("---- Início da Batalha ----");

        enemy = createEnemy();
        inBattle = true;

        player.viewEnemy(enemy);

        Character[] order = defineTurnOrder(player, enemy);

        while (inBattle) {
            System.out.println("-----------------------------");
            System.out.println("\nRodada " + roundCount + " - " + order[0].getName() + " > " + order[1].getName() + "\n");

            System.out.printf("%-20s %-20s\n", "Jogador: " + player.getName(), "Inimigo: " + enemy.getName());
            System.out.printf("%-20s %-20s\n", "Classe: " + player.getSelectedClass().getName(), "Classe: " + enemy.getSelectedClass().getName());
            System.out.printf("%-20s %-20s\n", "Vida: " + player.getHealth() + "/" + player.getSelectedClass().getMaxHealth(), "Vida: " + enemy.getHealth() + "/" + enemy.getSelectedClass().getMaxHealth());
            System.out.printf("%-20s %-20s\n", "Defesa: " + player.getSelectedClass().getDefense(), "Defesa: " + enemy.getSelectedClass().getDefense());

            List<String> playerStatusEffects = player.getStatusEffects();
            List<String> enemyStatusEffects = enemy.getStatusEffects();

            String playerStatusString = "Status: ";
            String enemyStatusString = "Status: ";

            for (String status : playerStatusEffects) {
                playerStatusString += status + ", ";
            }
            playerStatusString = playerStatusString.substring(0, playerStatusString.length() - 2); // Remove a última vírgula e espaço

            for (String status : enemyStatusEffects) {
                enemyStatusString += status + ", ";
            }
            enemyStatusString = enemyStatusString.substring(0, enemyStatusString.length() - 2); // Remove a última vírgula e espaço

            System.out.printf("%-20s %-20s\n\n", playerStatusString, enemyStatusString);

            System.out.println("\n");

            for (Character character : order) {
                if (character.getHealth() > 0) {
                    System.out.println("\nTurno de " + character.getName());

                    if (character instanceof Player) {
                        ((Player) character).performAction(enemy);
                    } else if (character instanceof Enemy) {
                        ((Enemy) character).performAction(player);
                    }

                    if (player.getHealth() <= 0 || enemy.getHealth() <= 0) {
                        inBattle = false;
                        break;
                    }
                }
            }
            roundCount++;
        }

        if (player.getHealth() <= 0) {
            System.out.println("Você foi derrotado!");
        } else {
            System.out.println("Você venceu a batalha!");
            player.setHealth(player.getSelectedClass().maxHealth);
            gameManager.addBattleWon(player);
        }

        System.out.println("---- Fim da Batalha ----");
        System.out.println("Rodadas: " + roundCount);
        System.out.println("Batalhas ganhas: " + gameManager.getBattlesWon());
        System.out.println("Experiência: " + gameManager.getExperiencePoints());
        System.out.println("Nível: " + gameManager.getLevel());
        System.out.println("\n\n\n");
    }

    private Character[] defineTurnOrder(Player player, Enemy enemy) {
        Character[] order = new Character[2];
        if (player.getSelectedClass().getDexterity() >= enemy.getSelectedClass().getDexterity()) {
            order[0] = player;
            order[1] = enemy;
        } else {
            order[0] = enemy;
            order[1] = player;
        }
        return order;
    }

    protected Enemy createEnemy() {
        Random random = new Random();
        int item = random.nextInt(12) + 1;
        int enemyClassId = random.nextInt(4) + 1;

        Classes enemyClass = null;
        switch (enemyClassId) {
            case 1:
                enemyClass = new Warrior("Inimigo Guerreiro");
                break;
            case 2:
                enemyClass = new Mage("Inimigo Mago");
                break;
            case 3:
                enemyClass = new Ranger("Inimigo Patrulheiro");
                break;
            case 4:
                enemyClass = new Rogue("Inimigo Ladino");
                break;
            default:
                // Caso padrão, por exemplo:
                enemyClass = new Warrior("Inimigo Padrão");
                break;
        }

        // Criação do inimigo usando a classe específica
        return new Enemy("Inimigo", "Humano", enemyClass, new Item.Sword(), 0, this); // Exemplo de health fixo para demonstração
    }
}
