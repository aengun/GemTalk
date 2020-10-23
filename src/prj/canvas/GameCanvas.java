package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

import prj.board.GameBoard;
import prj.board.PlayerBoard;
import prj.entity.Card;
import prj.entity.GameBackground;
import prj.entity.MyCard;

public class GameCanvas extends Canvas {

	public static Canvas instance;

	private GameBackground gameBackground;
	private int playTurn;

	private MyCard myCard; // 인터페이스 때문에 정의
	private GameBoard gameBoard;
	private PlayerBoard[] playerBoards = new PlayerBoard[4]; // 플레이어 보드 4개 생성


	public GameCanvas() {
		instance = this;
		
		gameBackground = new GameBackground();
		playTurn = 0;
		playerBoards[0] = new PlayerBoard(0, 0, 1);
		playerBoards[1] = new PlayerBoard(700, 0, 2);
		playerBoards[2] = new PlayerBoard(0, 450, 3);
		playerBoards[3] = new PlayerBoard(700, 450, 4);

		int gameBoardX = playerBoards[0].getPlayer().getX();
		int gameBoardY = playerBoards[0].getPlayer().getY() + 180;

		gameBoard = new GameBoard(gameBoardX, gameBoardY); // 350x225

		// 우승할 때 인터페이스 꽂는 부분
//		myCard.setMyCardListener(new MyCardListener() {
//			
//			@Override
//			public void onWin() {
//				// 게임에서 우승했을 때의 소스코드	canvas or 팝업창
//				if(win)
//					imgWin.paint
//				else(lose)
//					imgLose.paint
//			}
//		});

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					
					for (int i = 0; i < 4; i++) {
						// 얘를 해줘야 repaint를 할때 변경된 부분이 적용되어 다시 그려진다.
						playerBoards[i].update(); 
					}
					//gameBoard.update(); 얘말고 setCard방식으로..?

					// repaint() -> Canvas.update()가 화면을 지움 -> Canvas.paint(g)가 다시 그림
					repaint(); // 이걸 안하면 시작화면에서 그대로 멈춤(그린걸 지우고 다시 그리지를 않으므로)

					try {
						Thread.sleep(500); // 60fps(1초에 60번 while문 반복)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
		}).start();

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int voteCount = 0;
				int cardType = 0;
				System.out.println("그냥 마우스 클릭되는지 확인");

				Card card1 = gameBoard.getCard1();
				Card card2 = gameBoard.getCard2();
				Card cardDeck = gameBoard.getCardDeck();

				List<Card> cardList = gameBoard.getCardList();

				if (card1.choiceCard(x, y)) {
					card1.zoomIn();// zoomin

					gameBoard.check(cardList.get(0));
					Card temp = cardList.get(0);

					playerBoards[playTurn].getPlayer().answer(playTurn + 1);
					for (int i = 0; i < 4; i++)
						if (i != playTurn)
							if (playerBoards[i].getPlayer().vote() == 0)
								voteCount++;

					if (voteCount >= 2) {
						cardType = card1.getCardType();// move - myCard 연계
						playerBoards[playTurn].getPlayer().getMyCard().moveToPlayer(cardType);
					}
					card1.zoomOut();// zoomout 객체는 살아있지만 paint는 안되는
					
					gameBoard.setCard1(temp);
					cardList.remove(0);
					gameBoard.setCardList(cardList);
          
					playTurn = ++playTurn % 4;

				} else if (card2.choiceCard(x, y)) {
					card2.zoomIn();

					gameBoard.check(cardList.get(0));
					Card temp = cardList.get(0);

					playerBoards[playTurn].getPlayer().answer(playTurn + 1);
					for (int i = 0; i < 4; i++)
						if (i != playTurn)
							if (playerBoards[i].getPlayer().vote() == 0)
								voteCount++;

					if (voteCount >= 2) {
						cardType = card2.getCardType();// move - myCard 연계
						playerBoards[playTurn].getPlayer().getMyCard().moveToPlayer(cardType);
					}

					card2.zoomOut();

					gameBoard.setCard2(temp);
					cardList.remove(0);
					gameBoard.setCardList(cardList);
					playTurn = ++playTurn % 4;
				} else if (cardDeck.choiceCard(x, y)) {
					cardList.get(0).zoomIn();

					playerBoards[playTurn].getPlayer().answer(playTurn + 1);
					for (int i = 0; i < 4; i++)
						if (cardList.get(0).getCardType() == 4)
							voteCount = 4;
						else if (cardList.get(0).getCardType() == 5) {
							cardList.get(0).giveOrTake(playTurn);
							voteCount = 4;
						} else {
							if (i != playTurn)
								if (playerBoards[i].getPlayer().vote() == 0)
									voteCount++;
						}
					if (voteCount >= 2) {
						cardType = card2.getCardType();// move - myCard 연계
						playerBoards[playTurn].getPlayer().getMyCard().moveToPlayer(cardType);
					}
					System.out.println(voteCount);
					cardList.remove(0);
					gameBoard.setCardList(cardList);
					playTurn = ++playTurn % 4;
				}

//				if (voteCount >= 2) {
//					cardType = cardDeck.getCardType();// move - myCard 연계
//					playerBoards[playTurn].getPlayer().getMyCard().moveToPlayer(cardType);
//				}
//				cardList.remove(0);// zoomout역할

			}

		});
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread start");
				while (true) {
					
					for (int i = 0; i < 4; i++) {
						// 얘를 해줘야 repaint를 할때 변경된 부분이 적용되어 다시 그려진다.
						playerBoards[i].update(); 
					}
					gameBoard.update();

					// repaint() -> Canvas.update()가 화면을 지움 -> Canvas.paint(g)가 다시 그림
					repaint(); // 이걸 안하면 시작화면에서 그대로 멈춤(그린걸 지우고 다시 그리지를 않으므로)

					try {
						Thread.sleep(17); // 60fps(1초에 60번 while문 반복)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
		}).start();

	}

	@Override
	public void paint(Graphics g) {
		System.out.println("paint start");
		Image buf = this.createImage(getWidth(), getHeight());
		Graphics bg = buf.getGraphics();

		gameBackground.paint(bg);
		gameBoard.paint(bg);
		
		for (int i = 0; i < 4; i++)
			playerBoards[i].paint(bg);

		g.drawImage(buf, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public PlayerBoard[] getPlayerBoards() {
		return playerBoards;
	}

	public void setPlayerBoards(PlayerBoard[] playerBoards) {
		this.playerBoards = playerBoards;
	}

}