package view;

import control.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The game's main window.
 */
public class GameWindow extends JFrame {
    /**
     * The instance of the singleton GameWindow class.
     */
    private static final GameWindow instance = new GameWindow();

    private SettlerActionsView actionsView;
    private SettlerInventoryView inventoryView;
    private AsteroidStatusView asteroidStatusView;
    private GameStatusView gameStatusView;
    private MapView mapView;

    /**
     * Creates a GameWindow object.
     */
    private GameWindow() {
        super("Asteroid mining game");
        Dimension windowSize = new Dimension(1280, 720);
        this.setPreferredSize(windowSize);
        this.setMinimumSize(windowSize); // TODO: teszteléshez ezt majd lehet célszerű kikommentezni
        this.setLocationRelativeTo(null); // place the window in the center of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        mapView = new MapView();
        JScrollPane scrollPane = new JScrollPane(mapView);
        this.add(scrollPane, BorderLayout.CENTER);

        gameStatusView = new GameStatusView();
        this.add(gameStatusView, BorderLayout.NORTH);

        actionsView = new SettlerActionsView();
        this.add(actionsView, BorderLayout.SOUTH);

        inventoryView = new SettlerInventoryView();
        this.add(inventoryView, BorderLayout.WEST);

        asteroidStatusView = new AsteroidStatusView();
        this.add(asteroidStatusView, BorderLayout.EAST);

        this.pack();
    }

    /**
     * Starts the game.
     *
     * @param names A list containing the players' names.
     */
    public static void init(ArrayList<String> names) {
        Game.setStatusView(instance.gameStatusView);
        Game.start(names);
    }

    /**
     * This method can be used to access the main window object outside this class.
     *
     * @return The instance of this singleton class.
     */
    public static GameWindow getInstance() {
        return instance;
    }

    /**
     * Get the singleton class' AsteroidStatusView object.
     *
     * @return The AsteroidStatusView used throughout the game.
     */
    public static AsteroidStatusView getAsteroidStatusView() {
        return instance.asteroidStatusView;
    }
}
