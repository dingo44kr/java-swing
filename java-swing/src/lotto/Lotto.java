package lotto;

import java.util.Arrays;

public class Lotto {
	// sbs에서는 단 하나의 로또 번호만 출력
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		int[] temp = lotto.getLotto();
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]+"\t");
		}
	}
	
	int[] lotto = new int[6];

	public Lotto() {
		this.setLotto();
	}

	public int[] getLotto() {
		return lotto;
	}

	public void setLotto() {
		for (int i = 0; i < lotto.length; i++) {
			int randomNum = (int) (Math.random() * 45 + 1);
			boolean exist = false;
			for (int j = 0; j < lotto.length; j++) {
				if (randomNum == lotto[j]) {
					exist = true;
					break;
				}
			}

			if (exist) {
				i--; // 중복된 값이 출력되면 카운트 숫자를 줄여준다.
				continue;
				
			} else {
				// if문을 타지 않은 경우
				lotto[i] = randomNum;
			}
		}
		Arrays.sort(lotto);
	}

}
