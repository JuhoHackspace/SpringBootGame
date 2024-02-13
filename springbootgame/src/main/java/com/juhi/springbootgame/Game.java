package com.juhi.springbootgame;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private List<Player> players;
    private QuestionPool questions;
    private int round;
    private int playerCount;
    private Question current;
    private boolean gameStarted;
    private boolean roundStarted;
    private boolean allowNewPlayers;
    Map<Integer, Character> answers;
    public Game() {
        players = new ArrayList<>();
        questions = new QuestionPool();
        answers = new HashMap<>();
        round = 0;
        playerCount = 0;
        gameStarted = false;
        roundStarted = false;
        allowNewPlayers = false;
    }

    public void addPlayer(String name) {
        playerCount++;
        players.add(new Player(name, playerCount));
    }

    public void newGameSamePlayers() {
        round = 0;
        for(Player p: players) {
            p.resetPoints();
        }
        questions.resetShownQuestions();
        answers.clear();
        gameStarted = true;
        allowNewPlayers = false;
    }

    public void newGameNewPlayers() {
        round = 0;
        players.clear();
        playerCount = 0;
        questions.resetShownQuestions();
        answers.clear();
        gameStarted = true;
        allowNewPlayers = true;
    }

    public Question nextQuestion() {
        round++;
        roundStarted = true;
        allowNewPlayers = false;
        answers.clear();
        current = questions.randomQuestion();
        return current;
    }

    public void setPlayerAnswer(int playerNmbr,char answer) {
        answers.put(playerNmbr,answer);
    } 

    public int getPlayerCount() {
        return playerCount;
    }
    
    public boolean allowNewPlayers() {
        return allowNewPlayers;
    }

    public void setPointsForPlayer(int playerNmbr) {
        players.get(playerNmbr-1).addPoints(5);
    }
    
    public boolean checkForWin() {
        for(Player p: players) {
            if(p.getPoints() == 20) {
                return true;
            }
        }
        return false;
    }

    public String getPlayersStatus() {
        List<Player> possibleWinners = new ArrayList<>();
        String output = "";
        for(Player p: players) {
            if(p.getPoints() == 20) {
                possibleWinners.add(p);
            }
            output += System.lineSeparator() + "Player number: " + p.getNmbr() + " " + p.getName() + " has " + p.getPoints() + " points" + System.lineSeparator();
        }
        if(possibleWinners.size() > 0) {
            if(possibleWinners.size() == 1) {
                output += System.lineSeparator() + "Player number: " + possibleWinners.get(0).getNmbr() + " " + possibleWinners.get(0).getName() + " has won the game with 20 points";
            }else {
                output += System.lineSeparator() + "Following players have tied for the victory with 20 points: " + System.lineSeparator();
                for(Player winner: possibleWinners) {
                    output += "Player number: " + winner.getNmbr() + " " + winner.getName() + System.lineSeparator();
                }
            }
        }
        return output;
    }

    public boolean getRoundStatus() {
        return roundStarted;
    }

    public boolean getGameStatus() {
        return gameStarted;
    }

    public String getNameByNmbr(int nmbr) {
        return players.get(nmbr-1).getName();
    }

    public int getRound() {
        return round;
    }

    public String setPointsAndGetWinners() {
        List<Player> roundWinners = new ArrayList<>();
        String output = "";
        for (Map.Entry<Integer, Character> entry : answers.entrySet()) {
            int playerNumber = entry.getKey();
            char answer = entry.getValue();
            if(answer == current.getCorrectAnswer()) {
                output += "Player number: " + playerNumber + " " + getNameByNmbr(playerNumber) +  " answered: " + answer + " and gained 5 points with a correct answer!" + System.lineSeparator();
                roundWinners.add(players.get(playerNumber-1));
                setPointsForPlayer(playerNumber);
            }else {
                output += "Player number: " + playerNumber + " " + getNameByNmbr(playerNumber) + " answered: " + answer + " which is wrong!" + System.lineSeparator();
            }
        }
        return output;
    }
}
