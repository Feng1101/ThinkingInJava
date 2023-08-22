package feng.R_Enumerted.B_添加新方法;

public enum OzWitch {
    WEST("Miss Gulch, aka thwe Wicked Witch of the West","other"),
    NORTH("gLINDA THE gOOD wITCH OF THE NORTH"),
    EAST("Wicked Witch of the East,wearer of the Ruby "+"Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");
    private String description;
    private String other;
    private OzWitch(String description){
        this.description=description;
    }
    private OzWitch(String description,String other){
        this.description=description;
        this.other=other;
    }
    private String getDescription(){return description;}

    public static void main(String[] args) {
        for(OzWitch witch:OzWitch.values())
            System.out.println(witch+ ": "+witch.getDescription());
        System.out.println(OzWitch.EAST);
    }
}
