package manager;

public class RandomUtility {
	public static int EasyRandom(){
		return 1 + (int)(Math.random() * ((10 - 1) + 1));
	}
	public static int MediumRandom(){
		return 1 + (int)(Math.random() * ((100 - 1) + 1));
	}
	public static int HardRandom(){
		return 1 + (int)(Math.random() * ((1000 - 1) + 1));
	}
	public static String OpRandom(){
		int a = 1 + (int)(Math.random() * ((2 - 1) + 1));
		switch(a){
		case 1 : return "+";
		case 2 : return "-";
		default : return "+";
		}
	}
	public static int levelRandom(int level){
		return 1 + (int)(Math.random() * ((level - 1) + 1));
	}
}
