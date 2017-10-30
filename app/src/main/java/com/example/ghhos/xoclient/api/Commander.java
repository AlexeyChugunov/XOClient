package com.example.ghhos.xoclient.api;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;

import com.example.ghhos.xoclient.R;
import com.example.ghhos.xoclient.ui.fragments.FragmentGame;
import com.example.ghhos.xoclient.ui.fragments.FragmentRA;

import java.util.Objects;

/**
 * Created by GHhos on 25.02.2017.
 */
public class Commander {


    public static void listenLoop(String message) {

        /*if (message.startsWith("{")) {
            message = message.replaceAll(";", ",");
            FragmentManager.gameFrag.GameTurn(message);
            return;
        }
*/
        //String command = message.substring(0 ,message.indexOf(","));
        message = message.replaceAll("\\r\\n", "");
        String mess = message.substring(message.indexOf(",") + 1);
        String args[] = message.split(",");

        switch (args[0]) {
            case "loginsuccess": {
                FragmentManager.lobbyFrag.AddToPlayerList(args);
                break;
            }
            case "list": {
                FragmentManager.lobbyFrag.AddToPlayerList(args);
                break;
            }
            case "loginrefuse":{
                FragmentManager.lobbyFrag.LoginRefuse(); //MsgIncorrect lohin or pass
                break;
            }
            case "forgotpasssuccess":{
                ;//Msg Your password was send to your email!
                break;
            }
            case "forgotpassrefuse":{
               ; //Msg Invalid Login!
                break;
            }


            case "invite": {
                FragmentManager.lobbyFrag.InvitationBox(args[1]);
                break;
            }

            case "ask":{
                if (Objects.equals(args[1], "XO")) {
                    FragmentManager.SessionKey = "yes";
                    FragmentManager.ShowGame(FragmentManager.lobbyFrag.getFragmentManager().beginTransaction());
                }
                else {
                    FragmentManager.lobbyFrag.MessageBox("Connection denied", "Invitation issue");
                }
                break;
            }

            case "gamexo":{
                //if(args[1]=="0" || args[1]=="1"||args[1]=="2"||args[1]=="3"||args[1]=="4"||args[1]=="5"||args[1]=="6"||args[1]=="7"||args[1]=="8"||args[1]=="9")
                //FragmentManager.gameFrag.GameTurn(args[1],args[2]);
               // else
                //FragmentManager.gameFrag.GameStatus(args[1]);//остальные команды
                FragmentManager.gameFrag.GameCommand(mess);
                break;
            }

            /*
            case "success": {
                if (args[0].equals("yes")) {
                    FragmentManager.SessionKey = args[1];
                    FragmentManager.ShowGame(FragmentManager.lobbyFrag.getFragmentManager().beginTransaction());
                }
                else {
                    FragmentManager.lobbyFrag.MessageBox("Connection denied", "Invitation issue");
                }
                break;
            }
            case "auth": {
                if (args[0].equals("yes")) {
                    FragmentManager.lobbyFrag.Autherization(true);
                }
                else {
                    FragmentManager.lobbyFrag.Autherization(false);
                }
                break;
            }
            case "reg": {
                if (args[0].equals("yes")) {
                    FragmentManager.lobbyFrag.Registation(true);
                } else {
                    FragmentManager.lobbyFrag.Registation(false);
                }
                break;
            }
            case "game": {
                if (args[0].equals("quit")) {
                    FragmentManager.lobbyFrag.MessageBox("Player left the game. You win!", "Game over");
                // win = true;
                    FragmentManager.gameFrag.init = false;
                }
                break;
            }
            case "changepass": {
                String msg;
                if (args[0].equals("yes")) {
                    msg = "Password successfully changed!";
                }
                else {
                    msg = "Invalid login or/and password";
                }
                FragmentManager.lobbyFrag.MessageBox(msg, "Password change");
                break;
            }
            */


        }
    }

//    private void ToLobby() {
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_activity_fragment_placeholder,FragmentManager.lobbyFrag);
//        transaction.commit();
//    }
}
