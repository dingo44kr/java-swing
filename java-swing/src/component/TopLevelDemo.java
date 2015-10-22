package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class TopLevelDemo {
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("탑 레벨 예제");
		
		//프레임을 닫는 이벤트 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 메뉴바 생성 코드.. 바탕색과 크기를 설정하는 코드.
		JMenuBar greenMenuBar = new JMenuBar();
		greenMenuBar.setOpaque(true);
		greenMenuBar.setBackground(new Color(0, 84, 255));
		greenMenuBar.setPreferredSize(new Dimension(200, 20));

		
		// 라벨생성. opaque 투명도가 false면 100%
		JLabel yellowLabel = new JLabel();
		yellowLabel.setOpaque(true); //: true -> 불투명
		yellowLabel.setBackground(new Color(248, 213, 131));
		yellowLabel.setPreferredSize(new Dimension(200, 180));

		// 메뉴바 생성. 보더레이아웃은 중앙 정렬이 가능하다.
		frame.setJMenuBar(greenMenuBar);
		frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);

		// pack() 메소드는 컴포넌트를 팩킹시키는 역할.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}