import java.awt.*;
import java.awt.event.*;
public class TicTacTeo implements ActionListener{
	
	Frame window = new Frame();
	
	private Button _1 = new Button();
	private Button _2 = new Button();
	private Button _3 = new Button();
	private Button _4 = new Button();
	private Button _5 = new Button();
	private Button _6 = new Button();
	private Button _7 = new Button();
	private Button _8 = new Button();
	private Button _9 = new Button();
	private Button exit = new Button("Exit");
	private Button reStart = new Button("Restart");
	
	private Label playerTurnStatus = new Label("Player O's Turn");
	private Label winningStatus = new Label("Winning Status");
	private Label playerO = new Label("O : 0");
	private Label playerX = new Label("X : 0");
	
	private Font font = new Font("SansSerif", Font.BOLD, 45);
	private Font fontPlayerStatus = new Font("SansSerif", Font.BOLD, 15);
	
	private int[][] positions = {{2,2,2},{2,2,2},{2,2,2}};
	
	private boolean playerTurn = true;
	
	public TicTacTeo(){
		window.setBounds(100,100,380,550);
		window.setLayout(null);
		
		_1.setBounds(20,50,100,100);
		_2.setBounds(140,50,100,100);
		_3.setBounds(260,50,100,100);
		
		_4.setBounds(20,170,100,100);
		_5.setBounds(140,170,100,100);
		_6.setBounds(260,170,100,100);
		
		_7.setBounds(20,290,100,100);
		_8.setBounds(140,290,100,100);
		_9.setBounds(260,290,100,100);
		playerTurnStatus.setBounds(130,400,130,25);
		
		exit.setBounds(20,450,160,25);
		reStart.setBounds(200,450,160,25);
		
		winningStatus.setBounds(20,500,150,25);
		playerO.setBounds(170, 500, 90,25);
		playerX.setBounds(260,500,90,25);
		
		window.add(_1);
		window.add(_2);
		window.add(_3);
		window.add(_4);
		window.add(_5);
		window.add(_6);
		window.add(_7);
		window.add(_8);
		window.add(_9);
		window.add(playerTurnStatus);
		window.add(winningStatus);
		window.add(playerO);
		window.add(playerX);
		window.add(exit);
		window.add(reStart);
		
		
		
		_1.setFont(font);
		_2.setFont(font);
		_3.setFont(font);
		_4.setFont(font);
		_5.setFont(font);
		_6.setFont(font);
		_7.setFont(font);
		_8.setFont(font);
		_9.setFont(font);
		playerTurnStatus.setFont(fontPlayerStatus);
		winningStatus.setFont(fontPlayerStatus);
		playerO.setFont(fontPlayerStatus);
		playerX.setFont(fontPlayerStatus);
		
		_1.addActionListener(this);
		_2.addActionListener(this);
		_3.addActionListener(this);
		_4.addActionListener(this);
		_5.addActionListener(this);
		_6.addActionListener(this);
		_7.addActionListener(this);
		_8.addActionListener(this);
		_9.addActionListener(this);
		exit.addActionListener(this);
		reStart.addActionListener(this);
		
		
		window.show();
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(_1 == e.getSource()){
			setSymbol(_1);
		}else if(_2 == e.getSource()){
			setSymbol(_2);
		}else if(_3 == e.getSource()){
			setSymbol(_3);
		}else if(_4 == e.getSource()){
			setSymbol(_4);
		}else if(_5 == e.getSource()){
			setSymbol(_5);
		}else if(_6 == e.getSource()){
			setSymbol(_6);
		}else if(_7 == e.getSource()){
			setSymbol(_7);
		}else if(_8 == e.getSource()){
			setSymbol(_8);
		}else if(_9 == e.getSource()){
			setSymbol(_9);
		}else if(exit == e.getSource()){
			
		}else if(reStart == e.getSource()){
			reStart();
		}
	}
	
	public void setSymbol(Button clicked){
		
		if(playerTurn){
			clicked.setLabel("O");
			playerTurn = false;
			clicked.setEnabled(false);
			playerTurnStatus.setText("Player X's Turn");
			hasWon();
		}else{
			clicked.setLabel("X");
			playerTurn = true;
			clicked.setEnabled(false);
			playerTurnStatus.setText("Player O's Turn");
		}
	}
	
	private void exit(){
		
	}
	
	private void reStart(){
		_1.setEnabled(true);
		_2.setEnabled(true);
		_3.setEnabled(true);
		_4.setEnabled(true);
		_5.setEnabled(true);
		_6.setEnabled(true);
		_7.setEnabled(true);
		_8.setEnabled(true);
		_9.setEnabled(true);
		
		_1.setBackground(Color.white);
		_2.setBackground(Color.white);
		_3.setBackground(Color.white);
		_4.setBackground(Color.white);
		_5.setBackground(Color.white);
		_6.setBackground(Color.white);
		_7.setBackground(Color.white);
		_8.setBackground(Color.white);
		_9.setBackground(Color.white);
		
		_1.setLabel("");
		_2.setLabel("");
		_3.setLabel("");
		_4.setLabel("");
		_5.setLabel("");
		_6.setLabel("");
		_7.setLabel("");
		_8.setLabel("");
		_9.setLabel("");
	}
	
	private void hasWon(){
		if(_1.getLabel().equals("X")){
			System.out.println(_1.getLabel());
		}
		System.out.println("hasWon()");
	}
	public static void main(String[] args){
		new TicTacTeo();
	}
}