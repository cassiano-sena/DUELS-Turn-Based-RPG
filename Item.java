import java.util.*;

public class Item {
    private int id;
    private String name;
    private String description = "";
    protected List<Attack> itemActions;

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemActions = new ArrayList<>();
    }

    public void displayInfo() {
        System.out.println("Item ID: " + id);
        System.out.println("Nome: " + name);
        System.out.println("Descrição: " + description);
        System.out.println("Ações:");
        for (Attack action : itemActions) {
            System.out.println(action.getDescription() + "\n");
            System.out.println(action.getDamageFormula() + "\n");
            System.out.println(action.getHitChance() + "\n");
            System.out.println(action.getEffect() + "\n\n");
        }
        System.out.println();
    }

    public List<Attack> getItemActions() {
        return itemActions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    public Item getRandomItem() {
        Random random = new Random();
        int itemId = random.nextInt(12) + 1; // Gera um número aleatório de 1 a 12 (número máximo de tipos de armas)

        switch (itemId) {
            case 1:
                return new Sword();
            case 2:
                return new Axe();
            case 3:
                return new Hammer();
            case 4:
                return new ShortBow();
            case 5:
                return new HandCrossbow();
            case 6:
                return new LongBow();
            case 7:
                return new MagicStaff();
            case 8:
                return new ElectricStaff();
            case 9:
                return new FireStaff();
            case 10:
                return new Dagger();
            case 11:
                return new DualKnives();
            case 12:
                return new Rapier();
            default:
                throw new IllegalArgumentException("Item ID inválido: " + itemId);
        }
    }

    public static class Sword extends Item {
        public Sword() {
            super(1, "Espada", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(1),
                    AttackList.getAttackById(2),
                    AttackList.getAttackById(3)
            );
        }

        public void counterAttack(Character attacker, Character target) {
            System.out.println("Realizando Contra-ataque!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(1));
        }

        public void slash(Character attacker, Character target) {
            System.out.println("Realizando Corte!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(2));
        }

        public void feint(Character attacker, Character target) {
            System.out.println("Realizando Finta!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(3));
        }
    }


    public static class Axe extends Item {
        public Axe() {
            super(2, "Machado", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(4),
                    AttackList.getAttackById(5),
                    AttackList.getAttackById(6)
            );
        }

        public void wildAttack(Character attacker, Character target) {
            System.out.println("Realizando Ataque Selvagem!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(4));
        }

        public void strongAxe(Character attacker, Character target) {
            System.out.println("Realizando Machadada Forte!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(5));
        }

        public void maim(Character attacker, Character target) {
            System.out.println("Realizando Mutilar!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(6));
        }
    }

    public static class Hammer extends Item {
        public Hammer() {
            super(3, "Martelo", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(7),
                    AttackList.getAttackById(8),
                    AttackList.getAttackById(9)
            );
        }

        public void stunningLeap(Character attacker, Character target) {
            System.out.println("Realizando Salto Atordoante!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(7));
        }

        public void heavyHammer(Character attacker, Character target) {
            System.out.println("Realizando Martelo Pesado!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(8));
        }

        public void charge(Character attacker, Character target) {
            System.out.println("Realizando Carregar!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(9));
        }
    }

    public static class ShortBow extends Item {
        public ShortBow() {
            super(4, "Arco Curto", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(10),
                    AttackList.getAttackById(11),
                    AttackList.getAttackById(12),
                    AttackList.getAttackById(13)
            );
        }

        public void volleyOfArrows(Character attacker, Character target) {
            System.out.println("Realizando Saraivada de Flechas!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(10));
        }

        public void fastArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Rápida!");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(11));
        }

        public void poisonArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Envenenada!");
            System.out.println("10 de dano + destreza, 20% de chance de envenenar o inimigo.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(12));
        }

        public void keepDistance(Character attacker, Character target) {
            System.out.println("Realizando Manter Distância!");
            System.out.println("Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância, 75% de chance de desviar do ataque.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(13));
        }
    }

    public static class HandCrossbow extends Item {
        public HandCrossbow() {
            super(5, "Besta de Mão", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(14),
                    AttackList.getAttackById(15),
                    AttackList.getAttackById(16),
                    AttackList.getAttackById(13)
            );
        }

        public void preciseShot(Character attacker, Character target) {
            System.out.println("Realizando Flecha Precisa!");
            System.out.println("Uma flechada precisa que causa 10 de dano + destreza com 50% de chance de crítico.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(14));
        }

        public void poisonArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Envenenada!");
            System.out.println("10 de dano + destreza, 25% de chance de envenenar o inimigo.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(15));
        }

        public void heavyArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Pesada!");
            System.out.println("Uma flechada pesada que causa 10 de dano + destreza com 20% de chance de atordoar.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(16));
        }

        public void keepDistance(Character attacker, Character target) {
            System.out.println("Realizando Manter Distância!");
            System.out.println("Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância, 75% de chance de desviar do ataque.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(13));
        }
    }

    public static class LongBow extends Item {
        public LongBow() {
            super(6, "Arco Longo", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(17),
                    AttackList.getAttackById(18),
                    AttackList.getAttackById(19),
                    AttackList.getAttackById(13)
            );
        }

        public void strongArrow(Character attacker, Character target) {
            System.out.println("Realizando Flechada Forte!");
            System.out.println("Uma flechada forte que causa 20 de dano + destreza.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(17));
        }

        public void fireArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha de Fogo!");
            System.out.println("10 de dano + destreza, 25% de chance de botar fogo no inimigo.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(18));
        }

        public void headshot(Character attacker, Character target) {
            System.out.println("Realizando Headshot!");
            System.out.println("Sacrifica o turno, 30 de dano + destreza, crítico.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(19));
        }

        public void keepDistance(Character attacker, Character target) {
            System.out.println("Realizando Manter Distância!");
            System.out.println("Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância, 75% de chance de desviar do ataque.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(13));
        }
    }

    public static class MagicStaff extends Item {
        public MagicStaff() {
            super(7, "Cajado Mágico", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(20),
                    AttackList.getAttackById(21),
                    AttackList.getAttackById(22)
            );
        }

        public void sleepSpell(Character attacker, Character target) {
            System.out.println("Realizando Magia do Sono!");
            System.out.println("50% de chance de fazer o inimigo dormir.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(20));
        }

        public void explosiveComet(Character attacker, Character target) {
            System.out.println("Realizando Cometa Explosivo!");
            System.out.println("20 de dano, +20 se o inimigo estiver dormindo. Se o inimigo estiver dormindo, ele acordará.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(21));
        }

        public void arcaneSphere(Character attacker, Character target) {
            System.out.println("Realizando Esfera Arcana!");
            System.out.println("10 de dano, 20% de chance de atordoamento.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(22));
        }
    }
    public static class ElectricStaff extends Item {
        public ElectricStaff() {
            super(8, "Cajado Elétrico", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(23),
                    AttackList.getAttackById(24),
                    AttackList.getAttackById(25)
            );
        }

        public void castLightning(Character attacker, Character target) {
            System.out.println("Realizando Evocar Raio!");
            System.out.println("20 de dano.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(23));
        }

        public void thunder(Character attacker, Character target) {
            System.out.println("Realizando Trovão!");
            System.out.println("Durante os próximos 3 turnos possui mais 20% de chance de atordoamento.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(24));
        }

        public void electricChain(Character attacker, Character target) {
            System.out.println("Realizando Cadeia Elétrica!");
            System.out.println("10 de dano, 30% de chance de atordoamento.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(25));
        }
    }

    public static class FireStaff extends Item {
        public FireStaff() {
            super(9, "Cajado de Fogo", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(26),
                    AttackList.getAttackById(27),
                    AttackList.getAttackById(28)
            );
        }

        public void fireball(Character attacker, Character target) {
            System.out.println("Realizando Bola de Fogo!");
            System.out.println("Sacrifica o próximo turno, arremessa uma bola de fogo que causa 40 de dano.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(26));
        }

        public void armorOfFire(Character attacker, Character target) {
            System.out.println("Realizando Armadura de Fogo!");
            System.out.println("Os próximos 5 ataques sofridos causam 5 de dano ao atacante.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(27));
        }

        public void flamethrower(Character attacker, Character target) {
            System.out.println("Realizando Lança-Chamas!");
            System.out.println("Evoca um cone de chamas que causa 20 de dano, 20% de chance de botar fogo.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(28));
        }
    }

    public static class Dagger extends Item {
        public Dagger() {
            super(10, "Adaga", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(29),
                    AttackList.getAttackById(30),
                    AttackList.getAttackById(31),
                    AttackList.getAttackById(32)
            );
        }

        public void cut(Character attacker, Character target) {
            System.out.println("Realizando Corte!");
            System.out.println("Causa 5 + destreza de dano.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(29));
        }

        public void sneakAttack(Character attacker, Character target) {
            System.out.println("Realizando Ataque Furtivo!");
            System.out.println("Apenas se estiver furtivo, causa 10 + destreza de dano, ataque crítico garantido.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(30));
        }

        public void stealth(Character attacker, Character target) {
            System.out.println("Realizando Furtividade!");
            System.out.println("Sacrifica o turno para ficar furtivo.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(31));
        }

        public void imbueWithPoison(Character attacker, Character target) {
            System.out.println("Realizando Imbuir com Veneno!");
            System.out.println("30% de chance de envenenar.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(32));
        }
    }

    public static class DualKnives extends Item {
        public DualKnives() {
            super(11, "Facas Duplas", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(33),
                    AttackList.getAttackById(34),
                    AttackList.getAttackById(35)
            );
        }

        public void flurryOfSlashes(Character attacker, Character target) {
            System.out.println("Realizando Enxurrada de Cortes!");
            System.out.println("Série de 5 ataques rápidos, causando (2 por ataque) + destreza no valor total.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(33));
        }

        public void lacerate(Character attacker, Character target) {
            System.out.println("Realizando Lacerar!");
            System.out.println("Cruza as lâminas e causa 10 + destreza de dano, 20% de chance de causar sangramento.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(34));
        }

        public void imbueWithFlames(Character attacker, Character target) {
            System.out.println("Realizando Imbuir com Chamas!");
            System.out.println("Embui as lâminas com óleo inflamável, os próximos 3 turnos possuem 20% de chance de queimar o inimigo.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(35));
        }
    }

    public static class Rapier extends Item {
        public Rapier() {
            super(12, "Rapieira", "Arma");
            this.itemActions = Arrays.asList(
                    AttackList.getAttackById(36),
                    AttackList.getAttackById(37),
                    AttackList.getAttackById(38)
            );
        }

        public void thrust(Character attacker, Character target) {
            System.out.println("Realizando Ataque Perfurante!");
            System.out.println("Causa 10 + destreza de dano.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(36));
        }

        public void decisiveStrike(Character attacker, Character target) {
            System.out.println("Realizando Ataque Decisivo!");
            System.out.println("Causa 10 + destreza de dano, o turno do inimigo é ignorado, não pode ser usado sucessivamente.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(37));
        }

        public void riposte(Character attacker, Character target) {
            System.out.println("Realizando Ripostar!");
            System.out.println("Sacrifica o turno para defletir o próximo ataque do inimigo, 50% de chance de acerto, curando 5 hp num sucesso.");
            CombatManager.calculateDamage(attacker, target, AttackList.getAttackById(38));
        }
    }

}
