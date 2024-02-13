package com.juhi.springbootgame;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MyRestController {
private Game game;
private int currentPlayerTurn;
    @GetMapping("/")
    public String instructions() {
        return "GAME INSTRUCTIONS" + System.lineSeparator() + "1.Start a new game with new players by GET mapping '/newGameNewPlayers' " + System.lineSeparator() + "2. Follow instructions and start adding players" + System.lineSeparator() + "3. If you allready have a player pool, and wish to start a new game with the same players GET map '/newGame' ";
    }
    
    @GetMapping("/newGame")
    public String newGame() {
        if(game == null) {
            return "You have not created a game yet and you have no player pool. GET map '/newGameNewPlayers' to create a game";
        }else if(game.getPlayerCount() == 0) {
            return "You have not created a player pool yet. GET map '/newGameNewPlayers' and follow instructions";
        }else {
            game.newGameSamePlayers();
            currentPlayerTurn = 1;
            return "Starting New Game. The first question:" + System.lineSeparator() + game.nextQuestion().toString() + System.lineSeparator() + "Player " + game.getNameByNmbr(currentPlayerTurn) + ", post your answer!";
        }
    }

    @GetMapping("/newGameNewPlayers")
    public String newGameNewPlayers() {
        if(game == null) {
            game = new Game();
        }
        game.newGameNewPlayers();
        return "You have created a new game."+ System.lineSeparator() + "To create a user pool POST map '/addPlayer' with the player name inside the request body (name: 'player name')." + System.lineSeparator() + "Add as many players as you want. When you're done, follow the instructions to start the game rounds";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@RequestBody String player) {
        if(game == null) {
            return "You have not created a game yet and you cannot create a player pool. GET map '/newGameNewPlayers' to create a game";
        }else if(!game.allowNewPlayers()) {
            return "You have allready created a player pool. GET map '/newGameNewPlayers' to create a new game with new users";
        }else {
            game.addPlayer(player.substring(player.indexOf('=') + 1));
            return "Player succesfully added. To add another player, POST map '/addPlayer' again with a new name. To start the game GET map '/newGame'";
        }
    }

    @PostMapping("/postAnswer")
    public String postAnswer(@RequestBody String answer) {
        String output = "";
        if(game == null) {
            output += "You have not created a game yet and you cannot post an answer. GET map '/newGameNewPlayers' to create a game";
        }else if(!game.getRoundStatus()) {
            output += "You have no ongoing game round. To start a new game and the first round, GET map '/newGame' ";
        }else {
            String ans = answer.substring(answer.indexOf('=') + 1);
            if(ans.length() == 1 && ans.charAt(0) >= 'A' && ans.charAt(0) <= 'D') {
                game.setPlayerAnswer(currentPlayerTurn, ans.charAt(0));
                if(currentPlayerTurn == game.getPlayerCount()) {
                    currentPlayerTurn = 1;
                    output += "All answers posted" + System.lineSeparator() + game.setPointsAndGetWinners();
                    if(!game.checkForWin()) {
                        output += game.getPlayersStatus() + System.lineSeparator() + "No winner yet. Next question: " + System.lineSeparator() + game.nextQuestion().toString() + System.lineSeparator() + "Player " + game.getNameByNmbr(currentPlayerTurn) + ", post your answer!";
                    }else {
                        output += game.getPlayersStatus() + System.lineSeparator() + "Start a new game with same players by GET mappin '/newGame' or create a new game with new users by GET mapping '/newGameNewPlayers' ";
                    }
                }else {
                    output += "Answer for player " + game.getNameByNmbr(currentPlayerTurn) + " succefully posted. Player " + game.getNameByNmbr(currentPlayerTurn+1) + ", post your answer!";
                    currentPlayerTurn++;
                }
            }else {
                output += "Incorrect answer type. Please post a letter from A to D!";
                System.out.println("Input answer: " + ans);
            }
        }
        return output;
    }
    

}
