
public class Permutation {
	char up0;
	char up1;
	char up2;
	char up3;
	char down0;
	char down1;
	char down2;
	char down3;
	char front0;
	char front1;
	char front2;
	char front3;
	char back0;
	char back1;
	char back2;
	char back3;
	char right0;
	char right1;
	char right2;
	char right3;
	char left0;
	char left1;
	char left2;
	char left3;
	
	int or = -1;
	public String rep() {
		return "" + up0 + up1 + up2 + up3 + down0 + down1 + down2 + down3;
	}
	public Permutation(char up0, char up1, char up2, char up3, char down0, char down1, char down2, char down3, char front0, char front1, char front2, char front3, char back0, char back1, char back2, char back3, char right0, char right1, char right2, char right3, char left0, char left1, char left2, char left3) {
		this.up0 = up0;
		this.up1 = up1;
		this.up2 = up2;
		this.up3 = up3;
		this.down0 = down0;
		this.down1 = down1;
		this.down2 = down2;
		this.down3 = down3;
		this.front0 = front0;
		this.front1 = front1;
		this.front2 = front2;
		this.front3 = front3;
		this.back0 = back0;
		this.back1 = back1;
		this.back2 = back2;
		this.back3 = back3;
		this.right0 = right0;
		this.right1 = right1;
		this.right2 = right2;
		this.right3 = right3;
		this.left0 = left0;
		this.left1 = left1;
		this.left2 = left2;
		this.left3 = left3;
	}

	public Permutation(Permutation p) {
		this(p.up0, p.up1, p.up2, p.up3, p.down0, p.down1, p.down2, p.down3, p.front0, p.front1, p.front2, p.front3, p.back0, p.back1, p.back2, p.back3, p.right0, p.right1, p.right2, p.right3, p.left0, p.left1, p.left2, p.left3);
	}
	public void toCorrectOr() {
		if(up0 == 'D' && back1 == 'F') {
			or = 0;
			turnU();turnU();
		}
		else if(up1 == 'D' && right1 == 'F') {
			or = 1;
			turnU();		
		}
		else if(up2 == 'D' && left1 == 'F') {
			or = 2;
			turnD();
		}
		else if(up3 == 'D' && front1 == 'F') {
			or = 3;
			//none
		}
		else if(down0 == 'D' && front2 == 'F') {
			or = 4;
			turnF();turnF();
		}
		else if(down1 == 'D' && right2 == 'F') {
			or = 5;
			turnU();turnF();turnF();	
		}
		else if(down2 == 'D' && left2 == 'F') {
			or = 6;
			turnD();turnF();turnF();	
		}
		else if(down3 == 'D' && back2 == 'F') {
			or = 7;
			turnR();turnR();
		}
		
		else if(front0 == 'D' && up2 == 'F') {
			or = 8;
			turnR();turnU();turnU();
		}
		else if(front1 == 'D' && right0 == 'F') {
			or = 9;
			turnR();turnU();		
		}
		else if(front2 == 'D' && left3 == 'F') {
			or = 10;
			turnR();turnD();		
		}
		else if(front3 == 'D' && down1 == 'F') {
			or = 11;
			turnR();
		}
		
		else if(back0 == 'D' && up1 == 'F') {
			or = 12;
			turnL();
		}
		else if(back1 == 'D' && left0 == 'F') {
			or = 13;
			turnF();turnL();		
		}
		else if(back2 == 'D' && right3 == 'F') {
			or = 14;
			turnB();turnL();		
		}
		else if(back3 == 'D' && down2 == 'F') {
			or = 15;
			turnF();turnF();turnL();		
		}
		
		else if(right0 == 'D' && up3 == 'F') {
			or = 16;
			turnB();turnD();
		}
		else if(right1 == 'D' && back0 == 'F') {
			or = 17;
			turnB();turnU();turnU();		
		}
		else if(right2 == 'D' && front3 == 'F') {
			or = 18;
			turnB();
		}
		else if(right3 == 'D' && down3 == 'F') {
			or = 19;
			turnB();turnU();
		}
		
		else if(left0 == 'D' && up0 == 'F') {
			or = 20;
			turnF();turnU();
		}
		else if(left1 == 'D' && front0 == 'F') {
			or = 21;
			turnF();		
		}
		else if(left2 == 'D' && back3 == 'F') {
			or = 22;
			turnF();turnU();turnU();
		}
		else if(left3 == 'D' && down0 == 'F') {
			or = 23;
			turnF();turnD();
		}
		
	}
	public void returnOr() {
		switch(or) {
		case 0: turnD();turnD();break;
		case 1: turnD();break;
		case 2: turnU();break;
		case 4: turnB();turnB();break;
		case 5: turnB();turnB(); turnD();break;
		case 6: turnB();turnB();turnU();break;
		case 7: turnL();turnL();break;
		case 8: turnD();turnD();turnL();break;
		case 9: turnD();turnL();break;
		case 10: turnU();turnL();break;
		case 11: turnL();break;
		case 12: turnR();break;
		case 13: turnR(); turnB();break;
		case 14: turnR(); turnF(); break;
		case 15: turnR(); turnB();turnB();break;
		case 16: turnU(); turnF();break;
		case 17: turnD();turnD();turnF();break;
		case 18: turnF();break;
		case 19: turnD();turnF();break;
		case 20: turnD();turnB();break;
		case 21: turnB();break;
		case 22: turnD();turnD();turnB();break;
		case 23: turnU();turnB();	
		}
	}
	
	public void up() {
		char store0 = front0;
		char store1 = front1;
		front0 = right0;
		front1 = right1;
		right0 = back0;
		right1 = back1;
		back0 = left0;
		back1 = left1;
		left0 = store0;
		left1 = store1;
		rotateFaceClock("up");
	}
	public void upC() {
		char store0 = front0;
		char store1 = front1;
		front0 = left0;
		front1 = left1;
		left0 = back0;
		left1 = back1;
		back0 = right0;
		back1 = right1;
		right0 = store0;
		right1 = store1;
		rotateFaceCounter("up");
	}
	public void down() {
		char store2 = front2;
		char store3 = front3;
		front2 = left2;
		front3 = left3;
		left2 = back2;
		left3 = back3;
		back2 = right2;
		back3 = right3;
		right2 = store2;
		right3 = store3;
		rotateFaceClock("down");
	}
	public void downC() {
		char store2 = front2;
		char store3 = front3;
		front2 = right2;
		front3 = right3;
		right2 = back2;
		right3 = back3;
		back2 = left2;
		back3 = left3;
		left2 = store2;
		left3 = store3;

		rotateFaceCounter("down");
	}
	public void turnR() {
		char store0 = front0;
		char store1 = front1;
		char store2 = front2;
		char store3 = front3;
		front0 = down0;
		front1 = down1;
		front2 = down2;
		front3 = down3;
		down0 = back0;
		down1 = back1;
		down2 = back2;
		down3 = back3;
		back0 = up0;
		back1 = up1;
		back2 = up2;
		back3 = up3;
		up0 = store0;
		up1 = store1;
		up2 = store2;
		up3 = store3;

		rotateFaceClock("back");
		rotateFaceClock("back");
		rotateFaceClock("down");
		rotateFaceClock("down");
		rotateFaceClock("right");
		rotateFaceCounter("left");
	}
	public void turnL() {
		char store0 = front0;
		char store1 = front1;
		char store2 = front2;
		char store3 = front3;
		front0 = up0;
		front1 = up1;
		front2 = up2;
		front3 = up3;
		up0 = back0;
		up1 = back1;
		up2 = back2;
		up3 = back3;
		back0 = down0;
		back1 = down1;
		back2 = down2;
		back3 = down3;
		down0 = store0;
		down1 = store1;
		down2 = store2;
		down3 = store3;

		rotateFaceClock("back");
		rotateFaceClock("back");
		rotateFaceClock("up");
		rotateFaceClock("up");
		rotateFaceCounter("right");
		rotateFaceClock("left");
	}
	public void front(){
		turnR();
		up();
		turnL();
	}
	public void frontC(){
		turnR();
		upC();
		turnL();
	}
	public void back(){
		turnL();
		up();
		turnR();
	}
	public void backC(){
		turnL();
		upC();
		turnR();
	}
	public void turnU() {
		up();
		downC();
	}
	public void turnD() {
		down();
		upC();
	}
	public void right() {
		turnU();
		front();
		turnD();
	}
	public void rightC() {
		turnU();
		frontC();
		turnD();
	}
	public void left() {
		turnD();
		front();
		turnU();
	}
	public void leftC() {
		turnD();
		frontC();
		turnU();
	}
	public void turnF() {
		front();
		backC();
	}
	public void turnB() {
		back();
		frontC();
	}
	
	public void rotateFaceCounter(String whichOne) {
		if(whichOne.equals("up")) {
			char store = up0;
			up0 = up1;
			up1 = up3;
			up3 = up2;
			up2 = store;
		}
		else if(whichOne.equals("down")) {
			char store = down0;
			down0 = down1;
			down1 = down3;
			down3 = down2;
			down2 = store;
		}
		else if(whichOne.equals("left")) {
			char store = left0;
			left0 = left1;
			left1 = left3;
			left3 = left2;
			left2 = store;
		}
		else if(whichOne.equals("right")) {
			char store = right0;
			right0 = right1;
			right1 = right3;
			right3 = right2;
			right2 = store;
		}
		else if(whichOne.equals("front")) {
			char store = front0;
			front0 = front1;
			front1 = front3;
			front3 = front2;
			front2 = store;
		}
		else if(whichOne.equals("back")) {
			char store = back0;
			back0 = back1;
			back1 = back3;
			back3 = back2;
			back2 = store;
		}
	}
	
	public void rotateFaceClock(String whichOne) {
		if(whichOne.equals("up")) {
			char store = up0;
			up0 = up2;
			up2 = up3;
			up3 = up1;
			up1 = store;
		}
		else if(whichOne.equals("down")) {
			char store = down0;
			down0 = down2;
			down2 = down3;
			down3 = down1;
			down1 = store;
		}
		else if(whichOne.equals("left")) {
			char store = left0;
			left0 = left2;
			left2 = left3;
			left3 = left1;
			left1 = store;
		}
		else if(whichOne.equals("right")) {
			char store = right0;
			right0 = right2;
			right2 = right3;
			right3 = right1;
			right1 = store;
		}
		else if(whichOne.equals("front")) {
			char store = front0;
			front0 = front2;
			front2 = front3;
			front3 = front1;
			front1 = store;
		}
		else if(whichOne.equals("back")) {
			char store = back0;
			back0 = back2;
			back2 = back3;
			back3 = back1;
			back1 = store;
		}
	}
}
