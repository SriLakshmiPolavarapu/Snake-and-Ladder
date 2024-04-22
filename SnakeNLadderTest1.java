import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.sql.*;
class SnakeNLadder
{
final static int winpoint=9;
static Map<Integer,Integer> snake =new HashMap<Integer,Integer>();
static Map<Integer,Integer> ladder =new HashMap<Integer,Integer>();
{
snake.put(8,3);
snake.put(4,2);
ladder.put(5,9);

}
public void startGame()
{
int player1=0,player2=0;
int currentPlayer=-1;
Scanner s=new Scanner(System.in);
String str;
int diceValue=0;
do
{
System.out.println(currentPlayer==-1);
System.out.println("press r to roll dice");
str=s.next();
diceValue=rollDice();

  
        if(currentPlayer == -1)
        {
            player1 = calculatePlayerValue(player1,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player1))
            {
                System.out.println("First player wins");
                return;
            }
        }
else
        {
            player2 = calculatePlayerValue(player2,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player2))
            {
                System.out.println("Second player wins");
                return;
            }
        }
          

currentPlayer=-currentPlayer;
}
while("r".equals(str));
}
public int rollDice()
{
int n=0;
Random r=new Random();
n=r.nextInt(7);
return(n==0?1:n);
}
public int calculatePlayerValue(int player,int diceValue)
{
player=player+diceValue;
if(player>winpoint)
{
player=player-diceValue;
return player;
}
if(null!=snake.get(player))
{
System.out.println("swallowed by snake");
player=snake.get(player);
}

if(null!=ladder.get(player))
{
System.out.println("climb up the ladder");
player=ladder.get(player);
}
return player;
}
public boolean  isWin(int player)
{
return winpoint==player;}}


public class  SnakeNLadderTest1
{
public static void main(String args[])throws Exception
  
{
final int winpoint=9;
SnakeNLadder v=new SnakeNLadder();
v.startGame();

}
}
