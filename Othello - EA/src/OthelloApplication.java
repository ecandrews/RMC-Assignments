//Elizabeth Andrews
//Last updated: Mon Apr 20 11:34 pm

public class OthelloApplication {
	private Model m;
	private ScoreView sv;
	private Controller c;
	private BoardView bv;
	
	public OthelloApplication() {
		BeginGameView bgv = new BeginGameView(this);
	}
	
	public void createNewGame(int size) {
		this.m = new Model(size);
		this.sv = new ScoreView(m);
		this.c = new Controller(m);
		this.bv = new BoardView(m, c);
	}

	public static void main(String [] args) {
		OthelloApplication oa = new OthelloApplication();
	}
}
