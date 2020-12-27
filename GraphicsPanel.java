
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener{
	
	
	// method: GraphicsPanel Constructor
	// description: This 'method' runs when a new instance of this class in instantiated.  It sets default values  
	// that are necessary to run this project.  You do not need to edit this method.
	char up0 = 'A';
	char up1= 'B';
	char up2= 'C';
	char up3= 'D';
	char down0= 'U';
	char down1= 'V';
	char down2= 'W';
	char down3= 'X';
	char front0= 'E';
	char front1= 'F';
	char front2= 'G';
	char front3= 'H';
	char back0= 'M';
	char back1= 'N';
	char back2= 'O';
	char back3= 'P';
	char right0= 'I';
	char right1= 'J';
	char right2= 'K';
	char right3= 'L';
	char left0= 'Q';
	char left1= 'R';
	char left2= 'S';
	char left3= 'T';
	
	int[][] up = {{0,0},{0,0}};
	int[][] down = {{0,0},{0,0}};
	int[][] left = {{0,0},{0,0}};
	int[][] right = {{0,0},{0,0}};
	int[][] front = {{0,0},{0,0}};
	int[][] back = {{0,0},{0,0}};
	
	Permutation p = new Permutation(up0, up1, up2, up3, down0, down1, down2, down3, front0, front1, front2, front3, back0, back1, back2, back3, right0, right1, right2, right3, left0, left1, left2, left3);

	ArrayList<ArrayList<Permutation>> possible = new ArrayList<ArrayList<Permutation>>();
	ArrayList<HashSet<String>> store = new ArrayList<HashSet<String>>();
	
	
	
	public GraphicsPanel(){
		setPreferredSize(new Dimension(400, 400));
        this.setFocusable(true);			// for keylistener
		this.addKeyListener(this);
		this.addMouseListener(this);
		ArrayList<Permutation> starters = new ArrayList<Permutation>();
		//System.out.println(p.rep());
		starters.add(p);
		store.add(new HashSet<String>(10000, new Float(0.75)));
		for(int i = 0; i<starters.size(); i++) {
			//System.out.println(starters.get(i).rep() +"hi");
			store.get(0).add(starters.get(i).rep());
		}

		possible.add(new ArrayList<Permutation>());
		possible.get(0).add(new Permutation(p));
		
		int index = 0;
		while(possible.get(index).size()>0) {
			possible.add(new ArrayList<Permutation>());
			store.add(new HashSet<String>(16, new Float(0.75)));
			for(int i = 0; i<possible.get(index).size(); i++) {
				ArrayList<Permutation> check = new ArrayList<Permutation>();
				Permutation up = new Permutation(possible.get(index).get(i));
				Permutation upC = new Permutation(possible.get(index).get(i));
//				Permutation down = new Permutation(possible.get(index).get(i));
//				Permutation downC = new Permutation(possible.get(index).get(i));
				Permutation front = new Permutation(possible.get(index).get(i));
				Permutation frontC = new Permutation(possible.get(index).get(i));
//				Permutation back = new Permutation(possible.get(index).get(i));
//				Permutation backC = new Permutation(possible.get(index).get(i));
				Permutation right = new Permutation(possible.get(index).get(i));
				Permutation rightC = new Permutation(possible.get(index).get(i));
//				Permutation left = new Permutation(possible.get(index).get(i));
//				Permutation leftC = new Permutation(possible.get(index).get(i));
				up.up();
				upC.upC();
//				down.down();
//				downC.downC();
				front.front();
				frontC.frontC();
//				back.back();
//				backC.backC();
				right.right();
				rightC.rightC();
//				left.left();
//				leftC.leftC();
				check.add(up);
				check.add(upC);
//				check.add(down);
//				check.add(downC);
				check.add(front);
				check.add(frontC);
//				check.add(back);
//				check.add(backC);
				check.add(right);
				check.add(rightC);
//				check.add(left);
//				check.add(leftC);
				for(int j = 0; j<check.size(); j++) {
					check.get(j).toCorrectOr();
					if((store.size()<3 || !store.get(store.size()-3).contains(check.get(j).rep())) && (store.size()<1 || !store.get(store.size()-1).contains(check.get(j).rep()))) {
						store.get(store.size()-1).add(check.get(j).rep());
						check.get(j).returnOr();
						possible.get(index+1).add(check.get(j));
//						if(possible.get(index+1).size()%10000 == 0)
//							System.out.println(possible.get(index+1).size() + " size");
					}
				}							
			}
			System.out.println(possible.get(index).size());
			index++;
		}
		for(int i = 0; i<possible.get(possible.size()-2).size(); i++) {
			//System.out.println(possible.get(possible.size()-2).get(i).rep());
		}
		
//		int count = 0;
//		for(int i = 0; i<possible.size(); i++) {
//			System.out.println(possible.get(i).size());
//			count += possible.get(i).size();
//		}

		
	}
	
	// method: paintComponent
	// description: This method is called when the Panel is painted.  It contains code that draws shapes onto the panel.
	// parameters: Graphics g - this object is used to draw shapes onto the JPanel.
	// return: void
	public void paintComponent(Graphics g){
		
		
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i = 0; i<up.length; i++) {
			for(int j = 0; j<up[i].length; j++) {
				setColor(up[i][j],g2);
				g2.fillRect(100 + 20*j, 100 + 20*i, 20,20);
				g2.setColor(Color.BLACK);
				g2.drawRect(100 + 20*j, 100 + 20*i, 20,20);
			}
		}
		for(int i = 0; i<left.length; i++) {
			for(int j = 0; j<left[i].length; j++) {
				setColor(left[i][j],g2);
				g2.fillRect(60 + 20*j, 140 + 20*i, 20,20);
				g2.setColor(Color.BLACK);
				g2.drawRect(60 + 20*j, 140 + 20*i, 20,20);
			}
		}
		for(int i = 0; i<front.length; i++) {
			for(int j = 0; j<front[i].length; j++) {
				setColor(front[i][j],g2);
				g2.fillRect(100 + 20*j, 140 + 20*i, 20,20);
				g2.setColor(Color.BLACK);
				g2.drawRect(100 + 20*j, 140 + 20*i, 20,20);
			}
		}
		for(int i = 0; i<right.length; i++) {
			for(int j = 0; j<right[i].length; j++) {
				setColor(right[i][j],g2);
				g2.fillRect(140 + 20*j, 140 + 20*i, 20,20);
				g2.setColor(Color.BLACK);
				g2.drawRect(140 + 20*j, 140 + 20*i, 20,20);
			}
		}
		for(int i = 0; i<back.length; i++) {
			for(int j = 0; j<back[i].length; j++) {
				setColor(back[i][j],g2);
				g2.fillRect(180 + 20*j, 140 + 20*i, 20,20);
				g2.setColor(Color.BLACK);
				g2.drawRect(180 + 20*j, 140 + 20*i, 20,20);
			}
		}
		for(int i = 0; i<down.length; i++) {
			for(int j = 0; j<down[i].length; j++) {
				setColor(down[i][j],g2);
				g2.fillRect(100 + 20*j, 180 + 20*i, 20,20);
				g2.setColor(Color.BLACK);
				g2.drawRect(100 + 20*j, 180 + 20*i, 20,20);
			}
		}
		g2.drawString("Click on sqaures to enter colors", 50, 250);
		g2.drawString("Once colors are entered, press S to solve", 50, 270);
		g2.drawString("Press R to reset colors", 50, 290);
	}
	public void setColor(int id, Graphics2D g2) {
		switch(id) {
			case 0: g2.setColor(Color.white);break;
			case 1: g2.setColor(Color.yellow); break;
			case 2: g2.setColor(Color.RED); break;
			case 3: g2.setColor(Color.orange); break;
			case 4: g2.setColor(Color.BLUE); break;
			case 5: g2.setColor(Color.green);
		}
	}
	public void solve(String look) {
		Permutation solve = null;
		int movesAway = -1;
		int index = 0;
		while(movesAway == -1 && index<24) {
			System.out.println("checking orientation " + index);
			for(int i = 0; i<possible.size(); i++) {
				for(int j = 0; j<possible.get(i).size(); j++) {
					Permutation store = new Permutation(possible.get(i).get(j));
					possible.get(i).get(j).or = index;
					possible.get(i).get(j).returnOr();
					if(possible.get(i).get(j).rep().equals(look)) {
						System.out.println("found solution " + i + " moves away");
						solve = store;
						movesAway = i;
					}
					possible.get(i).set(j, store);
				}
			}
			if(movesAway == -1 && index<24)
				index++;
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		for(int i = movesAway-1; i>=0; i--) {
			ArrayList<Permutation> check = new ArrayList<Permutation>();
			
			Permutation up = new Permutation(solve); //0
			Permutation upC = new Permutation(solve);//1
			Permutation right = new Permutation(solve);//2
			Permutation rightC = new Permutation(solve);//3
			Permutation front = new Permutation(solve);//4
			Permutation frontC = new Permutation(solve);//5
//			Permutation left = new Permutation(solve);//6
//			Permutation leftC = new Permutation(solve);//7
//			Permutation down = new Permutation(solve);//8
//			Permutation downC = new Permutation(solve);//9
//			Permutation back = new Permutation(solve);//10
//			Permutation backC = new Permutation(solve);//11
			
			up.up();
			upC.upC();
//			down.down();
//			downC.downC();
			front.front();
			frontC.frontC();
//			back.back();
//			backC.backC();
			right.right();
			rightC.rightC();
//			left.left();
//			leftC.leftC();
			check.add(up);
			check.add(upC);
			check.add(right);
			check.add(rightC);
			check.add(front);
			check.add(frontC);
//			check.add(left);
//			check.add(leftC);
//			check.add(down);
//			check.add(downC);
//			check.add(back);
//			check.add(backC);
			
			for(int k = 0; k<check.size(); k++) {
				for(int j = 0; j<possible.get(i).size();j++) {
					if(possible.get(i).get(j).rep().equals(check.get(k).rep())) {
						solution.add(k);
						//System.out.println(check.get(k).rep());
						solve = possible.get(i).get(j);
						k = check.size();
						j = possible.get(i).size();
					}
				}
			}
		}
		switch(index) {
			case 0: System.out.println("turn U turn U");break;
			case 1: System.out.println("turn U");break;
			case 2: System.out.println("turn D");break;
			case 4: System.out.println("turn F turn F");break;
			case 5: System.out.println("turn U turn F turn F"); break;
			case 6: System.out.println("turn D turn F turn F");break;
			case 7: System.out.println("turn R turn R");break;
			case 8: System.out.println("turn R turn U turn U");break;
			case 9: System.out.println("turn R turn U");break;
			case 10: System.out.println("turn R turn D");break;
			case 11: System.out.println("turn R");break;
			case 12: System.out.println("turn L");break;
			case 13: System.out.println("turn F turn L"); break;
			case 14: System.out.println("turn B turn L");  break;
			case 15: System.out.println("turn F turn F turn L"); break;
			case 16: System.out.println("turn B turn D"); break;
			case 17: System.out.println("turn B turn U turn U");break;
			case 18: System.out.println("turn B");break;
			case 19: System.out.println("turn B turn U");break;
			case 20: System.out.println("turn F turn U");break;
			case 21: System.out.println("turn F");break;
			case 22: System.out.println("turn F turn U turn U");break;
			case 23: System.out.println("turn F turn D");	
		}
		//System.out.println(solution);
		for(int i = 0; i<solution.size(); i++) {
			String move = "";
			switch(solution.get(i)) {
				case 0: move = "U";break;
				case 1: move = "Ui";break;
				case 2: move = "R";break;
				case 3: move = "Ri";break;
				case 4: move = "F";break;
				case 5: move = "Fi";break;
				case 6: move = "L";break;
				case 7: move = "Li";break;
				case 8: move = "D";break;
				case 9: move = "Di";break;
				case 10: move = "B";break;
				case 11: move = "Bi";break;
			}
			System.out.print(move + " ");
		}
		System.out.println();
	}
	
	public String getState(int[][] up, int[][] down, int[][] front, int[][] back, int[][] left, int[][] right) {
		int A = up[0][0];
		int A1 = left[0][0];
		int A2 = back[0][1];
		int B = up[0][1];
		int B1 = right[0][1];
		int B2 = back[0][0];
		int C = up[1][0];
		int C1 = left[0][1];
		int C2 = front[0][0];
		int D = up[1][1];
		int D1 = front[0][1];
		int D2 = right[0][0];
		
		int U = down[0][0];
		int U1 = left[1][1];
		int U2 = front[1][0];
		int V = down[0][1];
		int V1 = front[1][1];
		int V2 = right[1][0];
		int W = down[1][0];
		int W1 = left[1][0];
		int W2 = back[1][1];
		int X = down[1][1];
		int X1 = right[1][1];
		int X2 = back[1][0];
		
		int[][] check = new int[][] {{A1,A2,A},{B1,B2,B},{C1,C2,C},{D1,D2,D},{U1,U2,U},{V1,V2,V},{W1,W2,W},{X1,X2,X}};	
		ArrayList<Character> dd = new ArrayList<Character>();
		for(int i = 0; i<check.length; i++) {
			if(check[i][2] == 0) {
				if((check[i][0] == 5 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 5)) {
					dd.add('A');
				}
				if((check[i][0] == 4 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 4)) {
					dd.add('B');
				}
				if((check[i][0] == 5 && check[i][1] == 2) || (check[i][0] == 2 && check[i][1] == 5)) {
					dd.add('C');
				}
				if((check[i][0] == 2 && check[i][1] == 4) || (check[i][0] == 4 && check[i][1] == 2)) {
					dd.add('D');
				}
			}
			if(check[i][2] == 2) {
				if((check[i][0] == 5 && check[i][1] == 0) || (check[i][0] == 0 && check[i][1] == 5)) {
					dd.add('E');
				}
				if((check[i][0] == 4 && check[i][1] == 0) || (check[i][0] == 0 && check[i][1] == 4)) {
					dd.add('F');
				}
				if((check[i][0] == 5 && check[i][1] == 1) || (check[i][0] == 1 && check[i][1] == 5)) {
					dd.add('G');
				}
				if((check[i][0] == 4 && check[i][1] == 1) || (check[i][0] == 1 && check[i][1] == 4)) {
					dd.add('H');
				}
			}
			if(check[i][2] == 4) {
				if((check[i][0] == 0 && check[i][1] == 2) || (check[i][0] == 2 && check[i][1] == 0)) {
					dd.add('I');
				}
				if((check[i][0] == 0 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 0)) {
					dd.add('J');
				}
				if((check[i][0] == 2 && check[i][1] == 1) || (check[i][0] == 1 && check[i][1] == 2)) {
					dd.add('K');
				}
				if((check[i][0] == 1 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 1)) {
					dd.add('L');
				}
			}
			if(check[i][2] == 3) {
				if((check[i][0] == 0 && check[i][1] == 4) || (check[i][0] == 4 && check[i][1] == 0)) {
					dd.add('M');
				}
				if((check[i][0] == 5 && check[i][1] == 0) || (check[i][0] == 0 && check[i][1] == 5)) {
					dd.add('N');
				}
				if((check[i][0] == 4 && check[i][1] == 1) || (check[i][0] == 1 && check[i][1] == 4)) {
					dd.add('O');
				}
				if((check[i][0] == 5 && check[i][1] == 1) || (check[i][0] == 1 && check[i][1] == 5)) {
					dd.add('P');
				}
			}
			if(check[i][2] == 5) {
				if((check[i][0] == 0 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 0)) {
					dd.add('Q');
				}
				if((check[i][0] == 0 && check[i][1] == 2) || (check[i][0] == 2 && check[i][1] == 0)) {
					dd.add('R');
				}
				if((check[i][0] == 1 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 1)) {
					dd.add('S');
				}
				if((check[i][0] == 1 && check[i][1] == 2) || (check[i][0] == 2 && check[i][1] == 1)) {
					dd.add('T');
				}
			}
			if(check[i][2] == 1) {
				if((check[i][0] == 5 && check[i][1] == 2) || (check[i][0] == 2 && check[i][1] == 5)) {
					dd.add('U');
				}
				if((check[i][0] == 2 && check[i][1] == 4) || (check[i][0] == 4 && check[i][1] == 2)) {
					dd.add('V');
				}
				if((check[i][0] == 5 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 5)) {
					dd.add('W');
				}
				if((check[i][0] == 4 && check[i][1] == 3) || (check[i][0] == 3 && check[i][1] == 4)) {
					dd.add('X');
				}
			}
		}
		String state = "";
		for(int i = 0; i<dd.size(); i++) {
			state += dd.get(i);
		}
		return state;
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println(getState(up,down,front,back,left,right));
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			solve(getState(up,down,front,back,left,right));
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			 up = new int[][]{{0,0},{0,0}};
			 down = new int[][]{{0,0},{0,0}};
			 left = new int[][]{{0,0},{0,0}};
			 right = new int[][]{{0,0},{0,0}};
			 front = new int[][]{{0,0},{0,0}};
			 back = new int[][]{{0,0},{0,0}};
		}
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		for(int i = 0; i<up.length; i++) {
			for(int j = 0; j<up[i].length; j++) {
				if(e.getX()>100 + 20*j && e.getX()<120 + 20*j && e.getY()>100 + 20*i && e.getY()<120 + 20*i){
					up[i][j] = (up[i][j] + 1)%6;
				}
				
			}
		}
		for(int i = 0; i<left.length; i++) {
			for(int j = 0; j<left[i].length; j++) {
				if(e.getX()>60 + 20*j && e.getX()<80 + 20*j && e.getY()>140 + 20*i && e.getY()<160 + 20*i){
					left[i][j] = (left[i][j] + 1)%6;
				}
			}
		}
		for(int i = 0; i<front.length; i++) {
			for(int j = 0; j<front[i].length; j++) {
				if(e.getX()>100 + 20*j && e.getX()<120 + 20*j && e.getY()>140 + 20*i && e.getY()<160 + 20*i){
					front[i][j] = (front[i][j] + 1)%6;
				}
			}
		}
		for(int i = 0; i<right.length; i++) {
			for(int j = 0; j<right[i].length; j++) {
				if(e.getX()>140 + 20*j && e.getX()<160 + 20*j && e.getY()>140 + 20*i && e.getY()<160 + 20*i){
					right[i][j] = (right[i][j] + 1)%6;
				}
			}
		}
		for(int i = 0; i<back.length; i++) {
			for(int j = 0; j<back[i].length; j++) {
				if(e.getX()>180 + 20*j && e.getX()<200 + 20*j && e.getY()>140 + 20*i && e.getY()<160 + 20*i){
					back[i][j] = (back[i][j] + 1)%6;		
				}
			}
		}
		for(int i = 0; i<down.length; i++) {
			for(int j = 0; j<down[i].length; j++) {
				if(e.getX()>100 + 20*j && e.getX()<120 + 20*j && e.getY()>180 + 20*i && e.getY()<200 + 20*i){
					down[i][j] = (down[i][j] + 1)%6;		
				}
			}
		}
		
		this.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
