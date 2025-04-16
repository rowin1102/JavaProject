package banking.threeby3;

import java.util.Random;
import java.util.Scanner;

public class ThreeBy3 {
	
	public static Scanner scan = new Scanner(System.in);
	static int[] board = new int[9];
	static int[] setBoard = new int[9];
	static Random rand = new Random();
	
	public static void set() {
		
		for(int i=0; i<8; i++) {
			board[i] = i + 1;
		}
		board[8] = -1;
		
		for(int i=0; i<9; i++) {
			setBoard[i] = board[i];
		}
	}
	
	public static void swap(int a, int b) {
		int temp = board[a];
		board[a] = board[b];
		board[b] = temp;
	}
	
	public static void printBoard() {
		
		for (int i = 0; i < 9; i++) {
			if(board[i] == -1)
				System.out.print("X ");
			else
				System.out.print(board[i] + " ");
			
			if ((i + 1) % 3 == 0) System.out.println();
        }
	}
	
	public static int findBlank() {
		for(int i=0; i<9; i++) {
			if(board[i] == -1)
				return i;
		}
		return -1;
	}
	
	public static void move(char key) {
		move(key, true);
	}
	
	public static void move(char key, boolean showMessage) {
		
		int pos = findBlank();
		int offset = 0;
		
		switch(key) {
		case 'a':
			if(pos % 3 == 2) {
				if (showMessage) System.out.println("왼쪽으로 이동할 수 없습니다.");
				return;
			}
			offset = 1;
			break;
		case 'd':
			if(pos % 3 == 0) {
				if (showMessage) System.out.println("오른쪽으로 이동할 수 없습니다.");
				return;
			}
			offset = -1;
			break;
		case 'w':
			if(pos >= 6) {
				if (showMessage) System.out.println("위로 이동할 수 없습니다.");
				return;
			}
			offset = 3;
			break;
		case 's':
			if(pos <= 2) {
				if (showMessage) System.out.println("아래로 이동할 수 없습니다.");
				return;
			}
			offset = -3;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		int target = pos + offset;
		swap(pos, target);
		
	}
	
	public static void moveRandom() {
		
		char[] moveKey = {'a', 'd', 'w', 's'};
		int count = 0;
		
		while (count < 3) {
			char randomKey = moveKey[rand.nextInt(4)];
			int before = findBlank();
			move(randomKey, false);
			int after = findBlank();
			
			
			
			if (before != after) {
				count++;
			}
		}
		
	}
	
	public static void showMenu() {
		System.out.println("[이동] a:Left d:Right w:Up s:Down");
		System.out.print("[종료] x:Exit\n키를 입력해주세요 : ");
	}
	
	public static boolean sameBoard() {
		
		for (int i = 0; i < 9; i++) {
			if (board[i] != setBoard[i]) {
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		char choice;
		
		set();
		moveRandom();
		
		while(true) {
			
			
			if(sameBoard()) {
				System.out.println("정답입니다.");
				printBoard();
				System.out.println("재시작하시겠습니까?(y를 누르면 재시작, 나머지는 종료)");
				
				scan.nextLine();
				String subchoice = scan.nextLine();
				
				if(subchoice.toUpperCase().equals("Y")) {
					set();
					moveRandom();
					continue;
				} else {
					System.out.println("게임을 종료합니다.");
					break;
				}
			}
			
			printBoard();
			showMenu();
			
			choice = scan.next().charAt(0);
			
			move(choice);
			
			if(choice == 'x') {
				break;
			}
			
		}
		
	}
	
}
