package gui;

import mummymaze.MummyMazeState;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SolutionPanel extends JFrame {

    private final GameArea gameArea;

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		LinkedList<String> lista = new LinkedList<String>();
//		String estado = 	"             \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" . . . . . H \n" +
//		"     -       \n" +
//		" . . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		estado = 	"             \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" . . . . H   \n" +
//		"     -       \n" +
//		" . . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		estado = 	"             \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" . . . H . . \n" +
//		"     -       \n" +
//		" . . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		estado = 	"             \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" . . H . .   \n" +
//		"     -       \n" +
//		" . . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		estado = 	"             \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" . H . . . . \n" +
//		"     -       \n" +
//		" . . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		estado = 	"             \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" H . . . . . \n" +
//		"     -       \n" +
//		" . . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		estado = 	" S            \n" +		
//		" . . . . .|. \n" +
//		"     -       \n" +
//		" . . . . . . \n" +
//		"     -       \n" +
//		" H . . .|. . \n" +
//		"       -   - \n" +
//		" . . . . .|. \n" +
//		"   - -       \n" +
//		" . . . M . . \n" +
//		"         -   \n" +
//		" . . . . . . \n" +
//		" S           \n";
//		lista.add(estado);
//		showSolution(lista,10);
//	}

    private SolutionPanel() {
        super("Show solution");
        gameArea = new GameArea();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(gameArea, BorderLayout.CENTER);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent evt) {
//                // Exit the application
//                System.exit(0);
//            }
//        });
    }

    public static void showSolution(final List<MummyMazeState> states, final double solutionCost) {
        final SolutionPanel p = new SolutionPanel();
        p.setVisible(true);
        p.pack();
        Thread t = new Thread() {
            public void run() {
                p.setSolutionCost(solutionCost);
                for (MummyMazeState s : states) {
                    p.setState(s);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public static void showState(final MummyMazeState state) {
        final SolutionPanel p = new SolutionPanel();
        p.setVisible(true);
        p.pack();
        Thread t = new Thread() {
            public void run() {
                p.setState(state);
                p.setShowSolutionCost(false);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }


    private void setState(MummyMazeState state) {
        gameArea.setState(state);
    }

    public void setShowSolutionCost(boolean showSolutionCost) {
        gameArea.setShowSolutionCost(showSolutionCost);
    }

    private void setSolutionCost(double solutionCost) {
        gameArea.setSolutionCost(solutionCost);
    }

}
