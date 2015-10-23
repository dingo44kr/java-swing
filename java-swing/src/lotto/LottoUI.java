package lotto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Lotto lotto;
	// 컴포넌트 (스윙에서 화면을 나타내는 클래스)는 연관관계로 부모-자식 관계를 맺는다.
	JButton btn, btnTest, btnExit;
	JPanel panelNorth, panelSouth; //보더 레이아웃 개념으로 볼 때 동서남북으로 위치값을 줌.
	ImageIcon icon;
	List<JButton> btns;
	
	public LottoUI() {
		this.init();
	}
	
	public void init(){ // initialize 의 약자로 초기화 메소드 이름으로 많이 사용함.
		/* 부품 준비 단계 => 큰것에서 작은것 순으로 */
		this.setTitle("SBS 로또 추첨");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		btn = new JButton("로또번호추첨"); 
		btnTest = new JButton("테스트");
		btnExit = new JButton("종료");
		
		
		/* 실제 조립 단계 => 작은것부터 큰것 순으로 */
		btn.addActionListener(this); //이 클래스에서 구현한 관련 메소드를 할당한다. -> 이벤트가 발생하면 저 아래의 함수를 실행한다.
		btnTest.addActionListener(this);
		btnExit.addActionListener(this);
		panelNorth.add(btn); // 북쪽 패널에 버튼을 장착.
		panelNorth.add(btnTest);
		panelNorth.add(btnExit);
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelSouth, BorderLayout.SOUTH);
		this.setBounds(300,400,1200,300);
		//300, 400 은 x, y 로 좌표값
		// 1200, 300 은 픽셀로 크기
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "로또번호추첨":
			if (btns.size() == 0) {
				JButton tmp = null;
				for (int i = 0; i < 6; i++) {
					tmp = new JButton(); // 번호가 붙지 않은 로또볼 객체를 만들어라
					btns.add(tmp); // 6회전이므로 비어있는 로또볼 6개를 리스트 담아라
					panelSouth.add(tmp); // 리스트에 담고, 또 그 로또볼을 패널에 붙여라.
				}
			}
			lotto.setLotto(); // 로또볼 추첨에 들어갑니다.
			int[] temp = lotto.getLotto(); // 랜덤으로 발생시킨 6개의 숫자가 들어가있음.
			for (int i = 0; i < temp.length; i++) {
				btns.get(i).setIcon(new ImageIcon("src/image/" + temp[i] + ".gif"));
			}
			break;

		case "테스트":
			System.out.println("테스트");
			break;

		case "종료":
			System.exit(0);
			break;

		default:
			return;
		}
	}

}
