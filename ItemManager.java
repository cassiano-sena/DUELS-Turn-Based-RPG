import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private static final Map<Integer, Item> itemMap = new HashMap<>();

    //public static Map<Integer, Item> getItemMap() {}

    static {
        // Inicializa os itens e os adiciona ao mapa
        itemMap.put(1, new Item.Sword());
        itemMap.put(2, new Item.Axe());
        itemMap.put(3, new Item.Hammer());
        itemMap.put(4, new Item.ShortBow());
        itemMap.put(5, new Item.HandCrossbow());
        itemMap.put(6, new Item.LongBow());
        itemMap.put(7, new Item.MagicStaff());
        itemMap.put(8, new Item.ElectricStaff());
        itemMap.put(9, new Item.FireStaff());
        itemMap.put(10, new Item.Dagger());
        itemMap.put(11, new Item.DualKnives());
        itemMap.put(12, new Item.Rapier());
    }

    // Método para obter um item pelo seu ID
    public static Item getItemById(int itemId) {
        return itemMap.get(itemId);
    }
}
