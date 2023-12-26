public class Item {
    private String name;
    private int serialnumber;

    private int piece;

    public Item(String name, int serialnumber,int piece){
        this.name=name;
        this.serialnumber=serialnumber;
        this.piece=piece;
    }
    public String getName(){
        return name;
    }
    public void setName(String str){
        this.name=str;
    }

    public int getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(int snum) {
        this.serialnumber=snum;
    }
    public void setPiece(int number){this.piece=number;}
    public int getPiece(){return piece;}
}
