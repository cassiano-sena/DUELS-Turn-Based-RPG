import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

abstract class Character {
    protected String name;
    protected String origin;
    protected Classes selectedClass;
    protected int health;
    protected Item equippedItem;
    protected String status;
    private List<StatusEffect> statusEffects;

    // Construtor atualizado
    public Character(String name, String origin, Classes selectedClass, Item equippedItem, String status) {
        this.name = name;
        this.origin = origin;
        this.selectedClass = selectedClass;
        this.health = selectedClass.maxHealth;
        this.equippedItem = equippedItem;
        this.status = status;
        this.statusEffects = new ArrayList<>();
    }

    // Método para adicionar um status de efeito ao personagem
    public void addStatusEffect(StatusEffect statusEffect) {
        statusEffects.add(statusEffect);
        statusEffect.applyEffect(this);
    }

    // Método para atualizar todos os efeitos de status no início de cada turno
    public void updateStatusEffects() {
        for (StatusEffect effect : new ArrayList<>(statusEffects)) {
            effect.decreaseDuration();
            if (!effect.isActive()) {
                statusEffects.remove(effect);
                System.out.println(name + " não está mais " + effect.getName() + ".");
                // Limpar o estado correspondente quando o efeito de status terminar
                clearStatus(effect.getName());
            }
        }
    }

    public Item getItem(int itemId) {
        return ItemManager.getItemById(itemId);
    }

    // Método para equipar um item
    public void equipItem(int itemId) {
        System.out.println("Equipando item ID " + itemId + "...");
        //this.equippedItem = itemId;
        if (this.getEquippedItem() != null) {
            this.setEquippedItemById(itemId);
            System.out.println(getName() + " equipou " + this.getEquippedItem().getName() + ".");
        }
    }

    protected void heal(Character character) {
        Random random = new Random();
        int healAmount = random.nextInt(10) + 1; // Restaura entre 1 e 10 pontos de vida
        int newHealth = character.getHealth() + healAmount;

        // Garante que a vida não ultrapasse o valor máximo de vida do personagem
        if (newHealth > character.getSelectedClass().getMaxHealth()) {
            newHealth = character.getSelectedClass().getMaxHealth();
        }

        character.setHealth(newHealth);

        System.out.println(character.getName() + " usou uma poção e restaurou " + healAmount + " de vida!");
        System.out.println("Vida atual: " + newHealth + "/" + character.getSelectedClass().getMaxHealth());
    }


    // Função para calcular o dano com base no atacante (Player ou Enemy)
    public int calculateDamage(Character attacker, Character target) {
        int damage = 0;

        // Obtém a fórmula de dano a ser utilizada (exemplo hipotético)
        String damageFormula = Attack.getDamageFormula();

        // Calcula o dano baseado na fórmula fornecida
        if (damageFormula != null && !damageFormula.isEmpty()) {
            if (damageFormula.contains("FOR")) {
                // Se a fórmula contém "FOR", adiciona o modificador de força do atacante
                int strengthModifier = 0;
                if (attacker instanceof Player) {
                    Player player = (Player) attacker;
                    strengthModifier = player.getSelectedClass().getStrength();
                } else if (attacker instanceof Enemy) {
                    Enemy enemy = (Enemy) attacker;
                    strengthModifier = enemy.getSelectedClass().getStrength();
                }
                damage = strengthModifier + Attack.getBaseDamage();
            } else if (damageFormula.contains("DEX")) {
                // Se a fórmula contém "DEX", adiciona o modificador de destreza do atacante
                int dexterityModifier = 0;
                if (attacker instanceof Player) {
                    Player player = (Player) attacker;
                    dexterityModifier = player.getSelectedClass().getDexterity();
                } else if (attacker instanceof Enemy) {
                    Enemy enemy = (Enemy) attacker;
                    dexterityModifier = enemy.getSelectedClass().getDexterity();
                }
                damage = dexterityModifier + Attack.getBaseDamage();
            } else {
                // Caso padrão, apenas usa o dano base do ataque
                damage = Attack.getBaseDamage();
            }
        } else {
            // Caso a fórmula esteja vazia, apenas usa o dano base do ataque
            damage = Attack.getBaseDamage();
        }

        // Aplica o dano ao alvo
        target.takeDamage(damage);

        return damage;
    }

    // Método para receber dano
    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    // Métodos para definir diferentes estados
    public void setSleeping(boolean sleeping) {
        if (sleeping) {
            addStatusEffect(new SleepStatus());
        } else {
            clearStatus("dormindo");
        }
    }

    public void setBurning(boolean burning) {
        if (burning) {
            addStatusEffect(new BurnStatus());
        } else {
            clearStatus("queimado");
        }
    }

    public void setStunned(boolean stunned) {
        if (stunned) {
            addStatusEffect(new StunStatus());
        } else {
            clearStatus("atordoado");
        }
    }

    public void setPoisoned(boolean poisoned) {
        if (poisoned) {
            addStatusEffect(new PoisonStatus());
        } else {
            clearStatus("envenenado");
        }
    }

    // Método para limpar um estado específico
    private void clearStatus(String statusName) {
        // Lógica para limpar o estado específico se necessário
        // Exemplo: this.status = "normal"; // Se não houver outros estados ativos
    }

    // Getters e setters para os atributos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Classes getSelectedClass() { // Ajustado o retorno para Classes
        return selectedClass;
    }

    public void setSelectedClass(Classes selectedClass) { // Ajustado o parâmetro para Classes
        this.selectedClass = selectedClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Item getEquippedItem() {
        return equippedItem;
        //return ItemManager.getItemById(equippedItem);
    }

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public void setEquippedItemById(int itemId) {
        // Obter o item pelo ID
        Item itemToEquip = ItemManager.getItemById(itemId);

        if (itemToEquip != null) {
            // Remover o item atualmente equipado, se houver
            if (this.equippedItem != null) {
                System.out.println(name + " removeu " + this.equippedItem.getName() + ".");
            }

            // Equipar o novo item
            this.equippedItem = itemToEquip;
            System.out.println(name + " equipou " + itemToEquip.getName() + ".");
        } else {
            System.out.println("Item com ID " + itemId + " não encontrado.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void useSkill();

    void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000); // Converte segundos para milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void attack(Item equippedItem, int actionIndex, Character attacker, Character target) {
        if (equippedItem == null) {
            System.out.println("Nenhum item equipado.");
            return;
        }

        List<Attack> itemActions = equippedItem.getItemActions();

        if (actionIndex >= 0 && actionIndex < itemActions.size()) {
            Attack selectedAction = itemActions.get(actionIndex);
            System.out.println("Ataque selecionado: " + selectedAction.getDescription());

            // Verifica o tipo de item e executa a ação correspondente
            if (equippedItem instanceof Item.Sword) {
                executeSwordAction((Item.Sword) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.Axe) {
                executeAxeAction((Item.Axe) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.Hammer) {
                executeHammerAction((Item.Hammer) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.ShortBow) {
                executeShortBowAction((Item.ShortBow) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.HandCrossbow) {
                executeHandCrossbowAction((Item.HandCrossbow) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.LongBow) {
                executeLongBowAction((Item.LongBow) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.MagicStaff) {
                executeMagicStaffAction((Item.MagicStaff) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.ElectricStaff) {
                executeElectricStaffAction((Item.ElectricStaff) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.FireStaff) {
                executeFireStaffAction((Item.FireStaff) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.Dagger) {
                executeDaggerAction((Item.Dagger) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.DualKnives) {
                executeDualKnivesAction((Item.DualKnives) equippedItem, selectedAction.getActionId(), attacker, target);
            } else if (equippedItem instanceof Item.Rapier) {
                executeRapierAction((Item.Rapier) equippedItem, selectedAction.getActionId(), attacker, target);
            } else {
                System.out.println("Item não reconhecido.");
            }
        } else {
            System.out.println("Ação inválida.");
        }
    }

    private void executeSwordAction(Item.Sword sword, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                sword.counterAttack(attacker, target);
                break;
            case 2:
                sword.slash(attacker, target);
                break;
            case 3:
                sword.feint(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Espada.");
        }
    }

    private void executeAxeAction(Item.Axe axe, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                axe.wildAttack(attacker, target);
                break;
            case 2:
                axe.strongAxe(attacker, target);
                break;
            case 3:
                axe.maim(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Machado.");
        }
    }
    private void executeHammerAction(Item.Hammer hammer, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                hammer.stunningLeap(attacker, target);
                break;
            case 2:
                hammer.heavyHammer(attacker, target);
                break;
            case 3:
                hammer.charge(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Martelo.");
        }
    }

    private void executeShortBowAction(Item.ShortBow shortBow, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                shortBow.volleyOfArrows(attacker, target);
                break;
            case 2:
                shortBow.fastArrow(attacker, target);
                break;
            case 3:
                shortBow.poisonArrow(attacker, target);
                break;
            case 4:
                shortBow.keepDistance(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Arco Curto.");
        }
    }

    private void executeHandCrossbowAction(Item.HandCrossbow handCrossbow, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                handCrossbow.preciseShot(attacker, target);
                break;
            case 2:
                handCrossbow.poisonArrow(attacker, target);
                break;
            case 3:
                handCrossbow.heavyArrow(attacker, target);
                break;
            case 4:
                handCrossbow.keepDistance(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Besta de Mão.");
        }
    }

    private void executeLongBowAction(Item.LongBow longBow, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                longBow.strongArrow(attacker, target);
                break;
            case 2:
                longBow.fireArrow(attacker, target);
                break;
            case 3:
                longBow.headshot(attacker, target);
                break;
            case 4:
                longBow.keepDistance(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Arco Longo.");
        }
    }

    private void executeMagicStaffAction(Item.MagicStaff magicStaff, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                magicStaff.sleepSpell(attacker, target);
                break;
            case 2:
                magicStaff.explosiveComet(attacker, target);
                break;
            case 3:
                magicStaff.arcaneSphere(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Cajado Mágico.");
        }
    }

    private void executeElectricStaffAction(Item.ElectricStaff electricStaff, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                electricStaff.castLightning(attacker, target);
                break;
            case 2:
                electricStaff.thunder(attacker, target);
                break;
            case 3:
                electricStaff.electricChain(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Cajado Elétrico.");
        }
    }

    private void executeFireStaffAction(Item.FireStaff fireStaff, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                fireStaff.fireball(attacker, target);
                break;
            case 2:
                fireStaff.armorOfFire(attacker, target);
                break;
            case 3:
                fireStaff.flamethrower(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Cajado de Fogo.");
        }
    }

    private void executeDaggerAction(Item.Dagger dagger, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                dagger.cut(attacker, target);
                break;
            case 2:
                dagger.sneakAttack(attacker, target);
                break;
            case 3:
                dagger.stealth(attacker, target);
                break;
            case 4:
                dagger.imbueWithPoison(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Adaga.");
        }
    }

    private void executeDualKnivesAction(Item.DualKnives dualKnives, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                dualKnives.flurryOfSlashes(attacker, target);
                break;
            case 2:
                dualKnives.lacerate(attacker, target);
                break;
            case 3:
                dualKnives.imbueWithFlames(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Facas Duplas.");
        }
    }

    private void executeRapierAction(Item.Rapier rapier, int actionId, Character attacker, Character target) {
        switch (actionId) {
            case 1:
                rapier.thrust(attacker, target);
                break;
            case 2:
                rapier.decisiveStrike(attacker, target);
                break;
            case 3:
                rapier.riposte(attacker, target);
                break;
            default:
                System.out.println("Ação não reconhecida para Rapieira.");
        }
    }
}
