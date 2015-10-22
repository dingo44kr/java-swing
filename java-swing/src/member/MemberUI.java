package member;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private Vector data;
	private Vector title;
	JTable table;
	JButton btnAdd, btnSearch, btnUpdate, btnDel, btnClear;
	JTextField txtName, txtAddr, txtUserid;
	JLabel lblName, lblAddr, lblUserid;
	DefaultTableModel model;
	
	public MemberUI() {
		super("회원관리");
		init();
		pack();
		setVisible(true);
	}
	
	public void init(){
//		this.setTitle("회원관리");
		data = new Vector<>(); //테이블에 표시될 데이터 벡터
		title = new Vector<>(); //테이블에 표시될 타이틀 벡터
		title.add("아이디");
		title.add("이름");
		title.add("주소");
		Vector result = null; //MemberDAO가 selectAll()한 결과를 받는 컬렉션
//		model.setDataVector(result, title);
		table = new JTable(model); //모델을 통해 테이블 생성.
		JScrollPane scroll = new JScrollPane(table); // 테이블 옆 스크롤 바.
		
		//이벤트를 단 하나의 컴포넌트 객체에 할당하는 방법.
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				Vector rs = (Vector) data.get(index); //memberDAO를 참조하면 이해가 쉬움.
				txtUserid.setText((String) rs.get(0));
				txtName.setText((String) rs.get(1));
				txtAddr.setText((String) rs.get(2));
				// 사용자ID는 변경할 수 없다는 옵션 처리.
				txtUserid.setEditable(false);
				txtName.setEditable(false);
				
			}
		});
		
		//화면에 표시될 패널 생성
		JPanel panel = new JPanel();
		
		
		//값을 입력받거나 표시할 텍스트 필드
		txtName = new JTextField(8); //8글자 허용
		txtUserid = new JTextField(10); //1글자 허용
		txtAddr = new JTextField(30); //30글자 허용
		
		// 레이블 생성.
		lblUserid = new JLabel("ID");
		lblName = new JLabel("이름");
		lblAddr = new JLabel("주소");
		
		// 버튼 생성
		btnAdd = new JButton("추가");
		btnSearch = new JButton("검색");
		btnUpdate = new JButton("수정");
		btnDel = new JButton("삭제");
		btnClear = new JButton("초기화");
		
		// 추가버튼 클릭
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userid = txtUserid.getText();
			//  String userid = scanner.next(); 와 동일한 기능.
				String name = txtName.getText();
				String addr = txtAddr.getText();
			//  service.insert(userid, name, addr);
				
			//	Vector result = service.selectAll();
			//	model.setDataVector(result, title);
				
			}
		});
		
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		panel.add(lblUserid);
		panel.add(txtUserid);
		panel.add(lblName);
		panel.add(txtName);
		panel.add(lblAddr);
		panel.add(txtAddr);
		panel.add(btnAdd);
		panel.add(btnSearch);
		panel.add(btnUpdate);
		panel.add(btnDel);
		panel.add(btnClear);
		Container container = this.getContentPane();
		container.add(new JLabel("테이블 데모 프로그램", JLabel.CENTER),"North");
		container.add(scroll,BorderLayout.CENTER);
		container.add(panel,BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 윈도우 창을 보이지 않게 해라 -> 닫기
				System.exit(0); //스윙 문법으로 종료처리 .. 알고리즘에서 return 의미
			}
		});
		
		
		
		

	}
}
