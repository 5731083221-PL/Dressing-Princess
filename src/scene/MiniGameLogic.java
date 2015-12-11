package scene;

import manager.RandomUtility;

public class MiniGameLogic {
	private String mode, op1, op2, op3;
	private int a, b, c, d, ans;

	public MiniGameLogic(String mode) {
		this.mode = mode;
		ans = 0;
		op1 = "";
		op2 = "";
		op3 = "";
		a = 0;
		b = 0;
		c = 0;
		d = 0;
	}

	public String getEquation() {
		op1 = RandomUtility.OpRandom();
		if (mode.equalsIgnoreCase("easy")) {
			int styleRandom = RandomUtility.levelRandom(4);
			switch (styleRandom) {
			case 1:
				b = RandomUtility.EasyRandom();
				a = RandomUtility.EasyRandom();
				break;
			case 2:
				b = RandomUtility.MediumRandom();
				a = RandomUtility.EasyRandom();
				break;
			case 3:
				b = RandomUtility.EasyRandom();
				a = RandomUtility.MediumRandom();
				break;
			case 4:
				b = RandomUtility.MediumRandom();
				a = RandomUtility.MediumRandom();
				break;
			default:
				b = RandomUtility.EasyRandom();
				a = RandomUtility.EasyRandom();
				break;
			}
			return a + " " + op1 + " " + b;
		} else if (mode.equalsIgnoreCase("medium")) {
			op2 = RandomUtility.OpRandom();
			a = RandomUtility.MediumRandom();
			int styleRandom = RandomUtility.levelRandom(4);
			switch (styleRandom) {
			case 1:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.EasyRandom();
				break;
			case 2:
				b = RandomUtility.MediumRandom();
				c = RandomUtility.EasyRandom();
				break;
			case 3:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.MediumRandom();
				break;
			case 4:
				b = RandomUtility.MediumRandom();
				c = RandomUtility.MediumRandom();
				break;
			default:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.EasyRandom();
				break;
			}
			return a + " " + op1 + " " + b + " " + op2 + " " + c;
		} else {
			op2 = RandomUtility.OpRandom();
			op3 = RandomUtility.OpRandom();
			a = RandomUtility.HardRandom();
			int styleRandom = RandomUtility.levelRandom(8);
			switch (styleRandom) {
			case 1:
				b = RandomUtility.MediumRandom();
				c = RandomUtility.EasyRandom();
				d = RandomUtility.MediumRandom();
				break;
			case 2:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.EasyRandom();
				d = RandomUtility.MediumRandom();
				break;
			case 3:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.HardRandom();
				d = RandomUtility.MediumRandom();
				break;
			case 4:
				b = RandomUtility.MediumRandom();
				c = RandomUtility.MediumRandom();
				d = RandomUtility.MediumRandom();
				break;
			case 5:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.HardRandom();
				d = RandomUtility.HardRandom();
				break;
			case 6:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.EasyRandom();
				d = RandomUtility.EasyRandom();
				break;
			case 7:
				b = RandomUtility.HardRandom();
				c = RandomUtility.EasyRandom();
				d = RandomUtility.MediumRandom();
				break;
			case 8:
				b = RandomUtility.HardRandom();
				c = RandomUtility.HardRandom();
				d = RandomUtility.HardRandom();
				break;
			default:
				b = RandomUtility.EasyRandom();
				c = RandomUtility.EasyRandom();
				d = RandomUtility.EasyRandom();
				break;
			}
			return a + " " + op1 + " " + b + " " + op2 + " " + c + " " + op3 + " " + d;
		}
	}

	public boolean checkAnswer(int answer) {
		ans += a;
		if (op1.equals("+")) {
			ans += b;
		} else if (op1.equals("-")) {
			ans -= b;
		}
		if (op2.equals("+")) {
			ans += c;
		} else if (op2.equals("-")) {
			ans -= c;
		}
		if (op3.equals("+")) {
			ans += d;
		} else if (op3.equals("-")) {
			ans -= d;
		}
		if (ans == answer) {
			return true;
		}
		return false;
	}

	public void resetParameter() {
		op1 = "";
		op2 = "";
		op3 = "";
		a = 0;
		b = 0;
		c = 0;
		d = 0;
		ans = 0;
	}

	public int rewardScore() {
		if (mode.equalsIgnoreCase("Hard")) {
			return 80;
		} else if (mode.equalsIgnoreCase("medium")) {
			return 40;
		} else {
			return 10;
		}
	}
}
