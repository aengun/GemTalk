package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;

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
	private Random rand;

	public GameCanvas() {
		instance = this;
		gameBackground = new GameBackground();
		playTurn = 0;
		playerBoards[0] = new PlayerBoard(0, 0, 1);
		playerBoards[1] = new PlayerBoard(700, 0, 2);
		playerBoards[2] = new PlayerBoard(0, 450, 3);
		playerBoards[3] = new PlayerBoard(700, 450, 4);
		rand = new Random();

		int gameBoardX = playerBoards[0].getPlayer().getX();
		int gameBoardY = playerBoards[0].getPlayer().getY() + 180;

		gameBoard = new GameBoard(gameBoardX, gameBoardY);

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

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int voteCount = 0;
				int cardType = 0;

				Card card1 = gameBoard.getCard1();
				Card card2 = gameBoard.getCard2();
				Card cardDeck = gameBoard.getCardDeck();

				List<Card> cardList = gameBoard.getCardList();

				if (card1.choiceCard(x, y)) {
					card1.zoomIn();// zoomin

					Card temp = cardList.get(0);
					gameBoard.check(temp);

					playerBoards[playTurn].getPlayer().answer();// answer
					for (int i = 0; i < 4; i++)
						if (i != playTurn) {
							if (playerBoards[i].getPlayer().vote() == 0)// vote
								voteCount++;

					if (voteCount >= 2) {
						cardType = card1.getCardType();// move - myCard 연계
						playerBoards[playTurn].getPlayer().getMyCard().move(cardType);
					}
					card1.zoomOut();// zoomout 객체는 살아있지만 paint는 안되는

					gameBoard.setCard1(temp);

					playTurn = (++playTurn % 4);

				} else if (card2.choiceCard(x, y)) {
					card2.zoomIn();

					Card temp = cardList.get(0);
					gameBoard.check(temp);

					playerBoards[playTurn].getPlayer().answer();
					for (int i = 0; i < 4; i++)
						if (i != playTurn)
							if (playerBoards[i].getPlayer().vote() == 0)// vote
								voteCount++;
					if (voteCount >= 2) {
						cardType = card2.getCardType();// move - myCard 연계
						playerBoards[playTurn].getPlayer().getMyCard().move(cardType);
					}

					card2.zoomOut();

					gameBoard.setCard2(temp);

					playTurn = (++playTurn % 4);
				} else if (cardDeck.choiceCard(x, y)) {
					cardList.get(0).zoomIn();

					playerBoards[playTurn].getPlayer().answer();
					for (int i = 0; i < 4; i++)
						if (cardList.get(0).getCardType() == 4 || cardList.get(0).getCardType() == 5)
							voteCount = 4;// action일때 실행하는 메서드 구현해야함!
						else {
							if (i != playTurn)
								if (playerBoards[i].getPlayer().vote() == 0)// vote
									voteCount++;
						}

					if (voteCount >= 2) {
						type = cardDeck.moveToPlayer();// move - myCard 연계
						playerBoards[playTurn].getPlayer().getMyCard().move(type);
					}
					cardList.get(0).moveToPlayer();
					cardList.remove(0);// zoomout역할

					playTurn = (++playTurn % 4);
				}

			}

		});

	}

	@Override
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();

		gameBackground.paint(bg);
		for (int i = 0; i < 4; i++)
			playerBoards[i].paint(bg);

		gameBoard.paint(bg);

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