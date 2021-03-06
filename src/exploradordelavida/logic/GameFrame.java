/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradordelavida.logic;

import helper.ComboBoxRenderer;
import helper.FancyButton;
import helper.MusicThread;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import menu.Memoria;
import menu.Menu;

/**
 *
 * @author julia
 */
public class GameFrame extends JFrame {

    public Board gameBoard;
    private boolean isRunning;
    private Thread music;
    private Memoria memoria;
    public static int selectedSpecie = Cell.BLACK_SPECIES;
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter(".EJI", "EJI");

    //AQUI VA LO QUE USTEDES HACEN!! LOS BOTONES LLAMAN ESTAS FUNCIONES...
    public void setGameSpeed(int secondsPerTurn) {
    }

    public void doSimulation() {
    }

    public void pauseSimulation() {
    }

    public void restartGame() {
        gameBoard.clearBoard();
    }
//--------------Getter and Setter para gardar y cargar-----------------------
    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }
 // -----------------------Guardar y cargar partida------------------------   

    public void saveGame() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filtro);
        int opcion = fileChooser.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            this.memoria.setNombre(archivoSeleccionado.getAbsolutePath());
            this.memoria.setMemorisa(getGameBoard());
            this.memoria.guardar();
        } else if (opcion == JFileChooser.CANCEL_OPTION) {
            fileChooser.setVisible(false);
        }
    }

    public void loadGame() throws IOException, FileNotFoundException, ClassNotFoundException {
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileFilter(filtro);
        int opcion = filechooser.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = filechooser.getSelectedFile();
            this.memoria.setNombre(archivoSeleccionado.getAbsolutePath());
            this.memoria.abrir();
            hide();
            music.stop();
            new GameFrame(this.memoria.getMemorisa());

        } else if (opcion == JFileChooser.CANCEL_OPTION) {
            filechooser.hide();

        }
    }
//-----------Menu: Cierra el Juego y abre otra vez el menu-------------------
    public void openMenu() {
        music.stop();
        hide();
        Menu menu = new Menu();
        menu.setVisible(true);
    }
//----------Musica-----------
    public void stopMusic() {
        music.stop();
    }

    public GameFrame() {
        super("Explorador de la vida");
        this.gameBoard = new Board(25);
        this.setPreferredSize(new Dimension(658, 700));
        this.setLocation(300,0);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.memoria = new Memoria();

        //Adding the Game Board!!
        this.getContentPane().add(gameBoard, BorderLayout.CENTER);

        //Adding the game menu
        addGameMenu();

        //Initializing music
        music = new MusicThread();
        music.start();

        this.pack();
        this.setVisible(true);
    }
//--------------Constructor de cuando se carga una partida----------------------
    public GameFrame(Board gameBoard) {
        super("Explorador de la vida");
        this.gameBoard = gameBoard;
        this.setPreferredSize(new Dimension(658, 700));
        this.setLocation(300,0);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.memoria = new Memoria();

        //Adding the Game Board!!
        this.getContentPane().add(gameBoard, BorderLayout.CENTER);

        //Adding the game menu
        addGameMenu();

        //Initializing music
        music = new MusicThread();
        music.start();

        this.pack();
        this.setVisible(true);
    }

    private void addGameMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.GRAY);

        //---STOP THE MUSIC----
        FancyButton musicButton = new FancyButton("volume", 1);
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                stopMusic();
            }
        });
        menuPanel.add(musicButton);
        //------MENU---
        FancyButton menuButton = new FancyButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                openMenu();
            }
        });
        menuPanel.add(menuButton);
        //------GUARDAR-----
        FancyButton saveButton = new FancyButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    saveGame();
                } catch (IOException ex) {
                    Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuPanel.add(saveButton);
        //--------CARGAR-----
        FancyButton loadButton = new FancyButton("Cargar");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    loadGame();
                } catch (IOException ex) {
                    Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuPanel.add(loadButton);
        //-------SELECTOR DE ESPECIE-----
        Integer[] species = {1, 2, 3};
        JComboBox specieSelector = new JComboBox(species);
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(30, 30));
        specieSelector.setRenderer(renderer);
        specieSelector.setSelectedIndex(0);
        specieSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox cb = (JComboBox) ae.getSource();
                Integer selectedValue = (Integer) cb.getSelectedItem();
                selectedSpecie = selectedValue;
            }
        });
        menuPanel.add(specieSelector);
        //-----PLAY---- 
        FancyButton playButton = new FancyButton("play", 1);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doSimulation();
            }
        });
        menuPanel.add(playButton);
        //-----AVANZAR TURNO--
        FancyButton turnButton = new FancyButton("step", 1);
        turnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameBoard.doTurn();
            }
        });
        menuPanel.add(turnButton);
        //----PAUSE------
        FancyButton pauseButton = new FancyButton("pause", 1);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pauseSimulation();
            }
        });
        menuPanel.add(pauseButton);
        //-----RESTART----
        FancyButton restartButton = new FancyButton("stop", 1);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                restartGame();
            }
        });
        menuPanel.add(restartButton);

        this.getContentPane().add(menuPanel, BorderLayout.SOUTH);
    }
}
