public class Combat {
    int turns;
    int order[];

    public void turnOrder(int dexterity, int dexterity2){
        boolean faster = dexterity > dexterity2;
        if(faster){
            order[0]=dexterity;
            order[1]=dexterity2;
        }
        else{
            order[1] = dexterity;
            order[0] = dexterity2;
        }
    }
}
