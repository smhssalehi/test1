package Project;
//heloo!
import java.util.*;

class MonoMoonPoly{
    public static Random random ;

    private int D1 ;
    private int D2 ;

    private void rollDice() {//in baraye tase
        this.D1= ((Math.abs(random.nextInt())) % 6) + 1 ;
        this.D2 = ((Math.abs(random.nextInt())) % 6) + 1 ;
    }
    public static void main(String[] args){
        MonoMoonPoly.random = new Random() ;
        Scanner scanner = new Scanner(System.in) ;
        long seed = scanner.nextLong() ;
        MonoMoonPoly.random.setSeed(seed) ;
        Player A = new Player("A");
        Player B = new Player("B");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(A);
        players.add(B);
        Bank bank = new Bank(players);
        boolean finish = true;
        while(finish){
            //inja manager bazi piyadeh sazi misheh.
            for(int i = 0; i < Zamin.getBolooks().length; ++i){
                if(Zamin.getBolooks()[i].getMalek() == null){
                    break;
                }
                finish = false;
            }
        }
    }
}

public class Zamin{
    private static HashMap darayiha = new HashMap<Player,ArrayList<Bolook>>();//darayi haye har bazikon faghat dar in ja zakhire mishavad
    public static ArrayList getDarayiha(Player player){//ÏÇÑÇ?? åÇ? ÈÇÒ?˜ä æÑæÏ? ÑÇ ÈÑ ã?ÑÏÇäÏ
        return (ArrayList) darayiha.get(player);
    }
    public static Khane[] zamin = {new Start("Start"),new Bolook(1000,"B1"),new Bolook(17000,"Abdos"),new Bolook(1200,"B3"),new Bolook(1000,"DogDooni"),new Bolook(2000,"Jakooz"),new Bolook(500,"B5"),new Bolook(3000,"B6"),new Bolook(1000,"B7"),new Infirmary("Infirmary"),new Bolook(4000,"Hoze"),new Bolook(1200,"B8"),new Bolook(1600,"B9"),new Bolook(10000,"Aquarium"),new Bolook(8000,"B10"),new Bolook(12000,"Halls"),new Bolook(8000,"Library"),new Bolook(5000,"Gym"),new Jail("Jail"),new Bolook(7000,"B11"),new Bolook(13000,"Sinister"),new Bolook(15000,"Abtalebi"),new Bolook(16000,"Ebnes"),new Bolook(20000,"TechCenter"),new Bolook(6000,"Aida"),new Bolook(4500,"Kanoon"),new Bolook(100,"Alpha-1"),new AlphaZero("Alpha Zero"),new Bolook(100,"Alpha-2"),new Bolook(500,"Park"),new Bolook(3000,"Bank"),new Bolook(5000,"Jaber"),new Bolook(2500,"B14"),new Bolook(24000,"SpacePort"),new Bolook(3000,"Boofe"),new Bolook(8000,"Loop")};//in arraye haman zamin bazi ast ke az khane haye mokhtalef sakhte shode
    public static Bolook[] allBolooks = {new Bolook(1000,"B1"),new Bolook(17000,"Abdos"),new Bolook(1200,"B3"),new Bolook(1000,"DogDooni"),new Bolook(2000,"Jakooz"),new Bolook(500,"B5"),new Bolook(3000,"B6"),new Bolook(1000,"B7"),new Bolook(4000,"Hoze"),new Bolook(1200,"B8"),new Bolook(1600,"B9"),new Bolook(10000,"Aquarium"),new Bolook(8000,"B10"),new Bolook(12000,"Halls"),new Bolook(8000,"Library"),new Bolook(5000,"Gym"),new Bolook(7000,"B11"),new Bolook(13000,"Sinister"),new Bolook(15000,"Abtalebi"),new Bolook(16000,"Ebnes"),new Bolook(20000,"TechCenter"),new Bolook(6000,"Aida"),new Bolook(4500,"Kanoon"),new Bolook(100,"Alpha-1"),new Bolook(100,"Alpha-2"),new Bolook(500,"Park"),new Bolook(3000,"Bank"),new Bolook(5000,"Jaber"),new Bolook(2500,"B14"),new Bolook(24000,"SpacePort"),new Bolook(3000,"Boofe"),new Bolook(8000,"Loop")};
    public static Bolook[] getBolooks(){
        return allBolooks;
    }
}
abstract class Khane{//
    private String name;
//    private Khane next;
    Khane(String name){
        this.name = name;
    }
//    public Khane getNext(){//khaneye badi in khane ra dar zamin midahad
//        return next;
//    }
//    public void setNext(Khane khane){//next ra tanzim mikonad
//        this.next = khane;
//    }
//    public static void setNextAll(Khane[] khaneha){//next ra tanzim mikonad
//        for (int i = 0;i < khaneha.length ;i++){
//            khaneha[i].setNext(khaneha[(i + 1) % khaneha.length]);
//        }
//    }
    public String getName(){
        return name;
    }
}
class Bolook extends  Khane{//khane haye addi dar zamin
    private int price;
    private Player malek;
    private int eghamatNum = 0;
    private int khabgahNum = 0;
    private boolean haveKhabgah = false;
    public Bolook(int price,String name){
        super(name);
        this.price = price;
        this.malek = malek;
    }
    public int getPrice(){
        return price;
    }
    public Player getMalek(){
        return malek;
    }
    public void setMalek(Player p){
        this.malek = p;
    }
    public boolean isFree(){
        if (this.malek == null) return true;
        else return false;
    }
    public boolean kharid(Player player){//player be  onavan malek sabt mishavad//hesa haye mali inja sorat nemigirad
        if (this.malek != null) return false;
        else
        {
            this.malek = player;
            return true;
        }

    }
    public void tasahob(){//tasahob in khane be vasile bank va gereftan malkiat an az bazikon
       this.malek = null;
       eghamatNum = 0;
       khabgahNum = 0;
    }
    public boolean makeKhabgah(){//kar haye mali dar in ja nist
        if (eghamatNum >= 5) {
            haveKhabgah = true;
            ++khabgahNum;
            return true;
        }
        else
            return false;
    }

    public void makeEghamat(){
        eghamatNum++;
    }

    public void setEghamatNum(){
        eghamatNum = 0;
    }

    public void setKhabgahNum(){
        khabgahNum = 0;
    }

    public int getEghamatNum(){//tedad eghamat gah ha ra midahad
        return eghamatNum;
    }

    public int getKhabgahNum(){
        return khabgahNum;
    }
}
class Jail extends  Khane {
    Jail(String name){
        super(name);
    }
}
class Infirmary extends  Khane {
    Infirmary(String name){
        super(name);
    }
}
class Start extends  Khane {
    Start(String name){
        super(name);
    }
}
class AlphaZero extends  Khane {
    AlphaZero(String name){
        super(name);
    }
}

class Bank {

    @SuppressWarnings("unused")
    private static ArrayList<Player> players;

    private static final double PercentProfit = 10 / 100;
    private static final double PercentProfitWhenHasLoan = 5 / 100;
    private static final double PercentRoom = 20 / 100;
    private static final double PercentDormitory = 50 / 100;

    private static final int InitialMoney = 10000;
    private static final int MaxDebt = 500000;

    public Bank(ArrayList<Player> players) {
        this.players = new ArrayList<Player>(players);
        for (Player p : players) {
            p.setMoney(InitialMoney);
        }
    }

    public static boolean hasLoan(Player p) {
        return !(p.getDebt() == 0);
    }

    public static int getBolookPrice(Bolook b) {//ÇÑÒÔ ?å Èáæ˜ ÈÇ ÇÞÇãÊÇå åÇ æ ÎæÇÈÇå åÇ? Çä ÑÇ ÈÑã?ÑÏÇäÏ
        int s = b.getPrice();
        s += (int) (b.getPrice() * b.getEghamatNum() * PercentRoom);
        s += (int) (b.getPrice() * b.getKhabgahNum() * PercentDormitory);
        return s;
    }

    public static int getPropertyCash(Player p) {//ÇÑÒÔ ÊãÇã ÏÇÑÇ?? åÇ? ÈÇÒ?˜ä æÑæÏ? ÑÇ ÈÑã?ÑÏÇäÏ
        int s = 0;
        ArrayList<Bolook> darayiha = Zamin.getDarayiha(p);
        for (Bolook b : darayiha) {
			/* getDarayiha dar classe zamin bayad static bashe */
			/* bayad too classe zamin bokonatesh arraylist az bolookha */

            s += b.getPrice();
            s += (int) (b.getPrice() * b.getEghamatNum() * PercentRoom);
            s += (int) (b.getPrice() * b.getKhabgahNum() * PercentDormitory);
        }
        return s;
    }

    public static int getMainBenefit(Player p){//ÓæÏ ÍÇÕá ÇÒ ÇãæÇá ÈÇÒ?˜ä æÑæÏ? ÑÇ ÈÇÒ ã?ÑÏÇäÏ
        int b;
        b = (int) (getPropertyCash(p) * PercentProfit);
        return b;
    }

    public static int getBenefit(Player p) {//ÓæÏ ÈÇÒ?˜ä ÑÇ ÈÇ ÇÍäÓÇÈ ÈÏå? ÈÇÒã?ÑÏÇäÏ
        int b;
        if (!hasLoan(p)) {
            b = (int) (getPropertyCash(p) * PercentProfit);
        } else {
            b = (int) (getPropertyCash(p) * PercentProfitWhenHasLoan);
        }
        return b;
    }

    public static int getPenaltyPrice(Bolook b) {//ÌÑ?ãå ÈÑÇ? Èáæ˜ æÑæÏ? ÑÇ ÈÇÒã?ÑÏÇäÏ
        int p = b.getPrice();
        p += b.getEghamatNum() * 100;
        p += b.getKhabgahNum() * 1000;
        return p;
    }

    public static void getMoneyFromPlayer(Player p, int penalty) {//inja miyad jarime ro migire va ye karayi anjam mideh
        if (p.getMoney() >= penalty) {
            p.setMoney(0 - penalty);
        } else {
            p.setDebt(penalty);
        }
        checkMax(p);
		/* nobate tas baraye in player bayad hazf she */
    }

    public static void getpenalty(Player p, Bolook b) {//jarime
        int penalty = getPenaltyPrice(b);
        getMoneyFromPlayer(p,penalty);
        b.getMalek().setMoney(penalty);
    }

    public static void setBenefit(Player p) {//sood bazikon
        int b = getBenefit(p);
        if (!hasLoan(p)) {
            p.setMoney(b);
        } else {
            if (p.getDebt() >= b) {
                p.setMoney(b);
                p.setDebt(-b);
            } else {
                p.setMoney(2 * b - p.getDebt());
                p.setDebt(-p.getDebt());
            }
        }
    }

    public int getPriceofRoom(Bolook b) {//æá ãæÑÏ ä?ÇÒ ÈÑÇ? ÇÍÏÇË ?˜ ÇÞÇãÊÇå
        return (int) (b.getPrice() * PercentRoom);
    }

    public int getPriceofDormrmitory(Bolook b) {//æá áÇÒã ÈÑÇ? ÇÍÏÇË ?˜ ÎæÇÈÇå
        return (int) (b.getPrice() * PercentDormitory);
    }

    public void returnToFirst(Player p) {
        p.setMoney(200);
    }

    public void goToHospital(Player p) {
        p.setMoney(-500);
    }

    private static boolean checkMax(Player p) {//ÇÑ ÈÇÒ?˜ä æÑÔ˜ÓÊå ÔæÏ ÝÇáÓ ÈÑã?ÑÏÇäÏ
        ArrayList<Bolook> darayiha = Zamin.getDarayiha(p);//agar bedehi bishtar az 50000 shavad inja amval forookhteh mishavad
        Bolook temp;
        for (int i = 0; i < darayiha.size(); i++) {
            for (int j = 1; j < (darayiha.size() - i); j++) {
                if (darayiha.get(j - 1).getPrice() > darayiha.get(j).getPrice()) {
                    temp = darayiha.get(j - 1);
                    darayiha.set(j - 1, darayiha.get(j));
                    darayiha.set(j, temp);
                }
            }
        }
        while (darayiha.size() != 0 || p.getDebt() >= 1000) {
            int price = darayiha.get(0).getPrice();
            p.setDebt(-price);
            darayiha.get(0).setMalek(null);
            darayiha.get(0).setEghamatNum();
            darayiha.get(0).setKhabgahNum();
            darayiha.remove(0);
        }
//        if (p.getDebt() > MaxDebt) {
//            Bolook b = darayiha.get(0);
//            int price = getBolookPrice(b);
//            if (p.getDebt() > price) {
//                p.setDebt(-price);
//                // b.setOwner(null);
//				/* bolook bayad yek set owner dashte bashad!!! */
//            } else {
//                p.setMoney(price - p.getDebt());
//                p.setDebt(-p.getDebt());
//            }
//            return true;
//        }
//        return false;
//    }
        if(p.getDebt() >= 1000){
            return false;
        }
        else    return true;
    }
}

class Player {
    private String name;
    private int playerMoney;
    private int debt;
    private int benefit;
    private int penalty;
    private int permission = 0;

    public Player(String name){
        this.name = name;
    }

    public void setMoney(int money){//ãÞÇÏ?Ñ ãËÈÊ ?Ç ãäÝ? ÑÇ ÏÑ?ÇÝÊ ã?˜äÏ
        playerMoney += money;
    }

    public int getMoney(){
        return playerMoney;
    }

    public void setDebt(int debt){//ÞÑÖ Èå ÈÇä˜ ÑÇ ãÔÎÕ ãí˜äÏ.
        this.debt += debt;//ÇÑ ÞÑÖ ÇÖÇÝå ÔæÏ ãÞÏÇÑ ÇÑæãÇä æÑæÏí ãËÈÊ æ ÇÑ ÞÑÖ ˜ã ÔæÏ ãÞÏÇÑ ÇÑæãÇä æÑæÏí ãäÝí ÎæÇåÏ ÈæÏ.
    }

    public int getDebt(){
        return debt;
    }

    public int getBenefit(){
        return Bank.getMainBenefit(this);
    }

    public void setPermission(int i){//agar i = 1 bashad bazikon partab anjam nemidehad
        permission = i;
    }

    public int getPermission(){
        return permission;
    }

}


