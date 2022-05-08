package it.unibo.ai.didattica.competition.tablut.nonamefoundexceptionclient;

import it.unibo.ai.didattica.competition.tablut.client.TablutClient;
import it.unibo.ai.didattica.competition.tablut.domain.*;
import it.unibo.ai.didattica.competition.tablut.domain.State.Turn;
import it.unibo.ai.didattica.competition.tablut.intelligence.GameIntelligence;
import it.unibo.ai.didattica.competition.tablut.intelligence.ReachableState;
import it.unibo.ai.didattica.competition.tablut.intelligence.TransposedGameIntelligence;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFactory;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.intelligence.search.TreeSearch;
import it.unibo.ai.didattica.competition.tablut.intelligence.search.TreeSearchFactory;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 
 * @author A. Piretti, Andrea Galassi
 *
 */
public class NoNameFoundExceptionClient extends TablutClient {

	private int game;
	private boolean debug;

	private GameIntelligence intelligence;

	public NoNameFoundExceptionClient(String player, String name, int gameChosen, int timeout, String ipAddress, boolean debug) throws UnknownHostException, IOException {
		super(player, name, timeout, ipAddress);
		game = gameChosen;
		debug = true;
	}
	
	public NoNameFoundExceptionClient(String player, String name, int timeout, String ipAddress, boolean debug) throws UnknownHostException, IOException {
		this(player, name, 4, timeout, ipAddress, debug);
	}
	
	public NoNameFoundExceptionClient(String player, int timeout, String ipAddress) throws UnknownHostException, IOException {
		this(player, "NoNameFoundException[" + player + "]", 4, timeout, ipAddress, false);
	}

	public NoNameFoundExceptionClient(String player) throws UnknownHostException, IOException {
		this(player, "NoNameFoundException[" + player + "]", 4, 60, "localhost", false);
	}


	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		int gametype = 4;
		String role = "";
		String name = "NoNameFoundException";
		String ipAddress = "localhost";
		boolean debug = false;
		int timeout = 60;
		// TODO: change the behavior?
		if (args.length < 1) {
			clientPrintln("You must specify which player you are (WHITE or BLACK)");
			clientPrintln("USAGE: ./runmyplayer <black|white> <timeout-in-seconds> <server-ip> <debug>");
			System.exit(-1);
		} else {
			role = (args[0]);
			clientPrintln("Readed player role: " + role);
			name = "NoNameFoundException_[" + role + "]";
			clientPrintln("Selected player name: " + name);
		}
		if (args.length == 2) {
			System.out.println(args[1]);
			try{
				timeout = Integer.parseInt(args[1]);
				clientPrintln("Readed timeout: " + name);
			} catch (Exception e) {
				clientPrintln("Invalid argument for timeout: " + timeout +
						". Please type an integer value representing the number of seconds");
				clientPrintln("USAGE: ./runmyplayer <black|white> <timeout-in-seconds> <server-ip> <debug>");
			}
		}
		if (args.length == 3) {
			ipAddress = args[2];
			clientPrintln("Readed server address: " + ipAddress);
		}
		if (args.length == 4) {
			if(args[3].equalsIgnoreCase("debug")) {
				debug = true;
				clientPrintln("Activated debug");
			}
			else
				clientPrintln("Ignoring unexpected argument \'" + args[3] + "\'");
		}
		clientPrintln("Configuration: role = " + role + ", name = " + name + ", game type = " +
				gametype + ",\n\t\ttimeout = " + timeout + ", server ip = " + ipAddress + ", debug = " + debug);

		NoNameFoundExceptionClient client = new NoNameFoundExceptionClient(
				role, name, gametype, timeout, ipAddress, debug);
		clientPrintln("Running client...");
		client.run();
	}

	private static void clientPrintln(String line) {
		System.out.println(NoNameFoundExceptionClient.class.getSimpleName() + " \t| ");
	}

	@Override
	public void run() {

		try {
			this.declareName();
		} catch (Exception e) {
			e.printStackTrace();
		}

		State state;
		Game game = null;
		Action action = null;
		switch (this.game) {
		case 4:
			state = new StateTablut();
			state.setTurn(Turn.WHITE);
			game = new GameAshtonTablut(99, 0, "garbage", "fake", "fake");
			clientPrintln("Ashton Tablut game");
			TreeSearch<HeuristicVisitable<ReachableState>> searchLogic =
					TreeSearchFactory.create(TreeSearchFactory.DEEPEN_ALPHA_BETA_AG,
							ReachableState.class,
					HeuristicFactory.create("", ReachableState.class), game, 3);
			intelligence = new TransposedGameIntelligence(searchLogic);
			break;
		default:
			clientPrintln("Error in game selection");
			clientPrintln("Game \'" + this.game + "\' not supported");
			System.exit(4);
		}

		clientPrintln("Load completed.");
		clientPrintln("You are player " + this.getPlayer().toString() + "!");

		/* GAME LOOP ******************************************************************** */
		boolean gameEnd = false;
		while (!gameEnd) {
			try {
				this.read(); //Read the new state and put it into currentState var
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.exit(1);
			}
			System.out.println("Current state:");
			//Update the state
			state = this.getCurrentState();
			System.out.println(state.toString());

			switch (getCurrentState().getTurn()) {
				case DRAW:
				case WHITEWIN:
				case BLACKWIN:
					gameEnd = true;
			}

			if(!gameEnd) {
				//If !gameEnd then the turn is BLACK or WHITE
				if(getCurrentState().getTurn().equals(getPlayer())) {
					/* MY TURN **************************************************** */
					clientPrintln("Asking move to the intelligence...");
					action = intelligence.think();
					clientPrintln("Action found: " + action.toString());
					try {
						this.write(action);
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}

				} else {
					/* ADVERSARY TURN ********************************************* */
					clientPrintln("Waiting for the adversary");
				}
			}
		}

		clientPrintln("Game end!");
		Turn winner = getWinner(getCurrentState().getTurn());
		clientPrintln("The winner is: " + winner.toString());
		if(winner.equals(getPlayer())){
			clientPrintln("CONGRATS... YOU WIN!");
		} else {
			clientPrintln("OH NO... YOU LOOSE!");
		}

	}

	private Turn getWinner(Turn endTurn) {
		switch (endTurn){
			case BLACKWIN:
				return Turn.BLACK;
			case WHITEWIN:
				return Turn.BLACKWIN;
			default:
				throw new IllegalArgumentException(
						"The turn \'" + endTurn.toString() + "\' is not a final turn");
		}
	}
}
