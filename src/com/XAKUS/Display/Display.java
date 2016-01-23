package com.XAKUS.Display;

import com.XAKUS.Game.Constants;
import com.XAKUS.Sea.Sea;

/**
 * Created by xakus on 18.11.2015.
 */
public abstract class Display {
      public static void drawFullDisplay(int[][] myMatrix, int[][] compMatrix) {

            System.out.println("\u001b[2J");
            image();
            System.out.print("                              ");
            for(int i = 0; i < myMatrix[0].length; i++) {
                  if(i > 9) {

                        System.out.print(" " + " " + (i + 1));
                  } else {
                        System.out.print(" " + " " + " " + (i + 1));
                  }
            }
            if(myMatrix[0].length >= 10) {
                  System.out.print("        ");
            } else {
                  System.out.print("         ");
            }
            for(int i = 0; i < compMatrix[0].length; i++) {
                  if(i > 9) {
                        System.out.print(" " + " " + (i + 1));
                  } else {
                        System.out.print(" " + " " + " " + (i + 1));
                  }
            }
            System.out.println();
            System.out.print("                              ");
            System.out.print(Constants.ANSI_CYAN + " |" + Constants.ANSI_RESET);
            ////// |___|___|___|___| .....
            for(int i = 0; i < myMatrix[0].length; i++) {
                  System.out.print(Constants.ANSI_CYAN + "___|" + Constants.ANSI_RESET);
            }
            System.out.print(Constants.ANSI_CYAN + "        |" + Constants.ANSI_RESET);
            for(int i = 0; i < compMatrix[0].length; i++) {
                  System.out.print(Constants.ANSI_CYAN + "___|" + Constants.ANSI_RESET);
            }
            System.out.println();
            for(int i = 0; i < myMatrix.length; i++) {
                  System.out.print("                              ");
                  System.out.print(Character.toString((char) (i + 65)) + Constants.ANSI_CYAN + "|");
                  for(int j = 0; j < myMatrix[i].length; j++) {
                        System.out.print(Constants.ANSI_CYAN + "_" + Constants.ANSI_RESET + getMySymbol(myMatrix[i][j]) + Constants.ANSI_CYAN + "_|" + Constants.ANSI_RESET);
                  }
                  System.out.print("       " + Character.toString((char) (i + 65)) + Constants.ANSI_CYAN + "|" + Constants.ANSI_RESET);
                  for(int j = 0; j < compMatrix[i].length; j++) {
                        System.out.print(Constants.ANSI_CYAN + "_" + Constants.ANSI_RESET + getCompSymbol(compMatrix[i][j]) + Constants.ANSI_CYAN + "_|" + Constants.ANSI_RESET);
                  }
                  System.out.println();
            }
      }

      public static void writeTextAndDisplay(String str) {
            drawFullDisplay(Sea.myMatrix, Sea.compMatrix);
            System.out.print("                              ");
            System.out.print("                                        ");
            System.out.println(Constants.ANSI_YELLOW + str + Constants.ANSI_RESET);
      }

      public static void writeText(String str) {
            System.out.print("                              ");
            System.out.print("                                        ");
            System.out.println(Constants.ANSI_YELLOW + str + Constants.ANSI_RESET);
      }

      private static String getMySymbol(int x) {
            String[] strings = new String[]{
                    "_",
                    "~",
                    "*",
                    "X",
                    "O"
            };
            String str = null;
            if(strings[x].equals("X")) {
                  str = Constants.ANSI_RED + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("O")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("*")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("_")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("~")) {
                  str = Constants.ANSI_RED + strings[x] + Constants.ANSI_RESET;
            }
            return str;
      }

      private static String getCompSymbol(int x) {
            String[] strings = new String[]{
                    "_",
                    "~",
                    "*",
                    "X",
                    "O"
            };
            String str = null;
            if(strings[x].equals("X")) {
                  str = Constants.ANSI_RED + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("_")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("O")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("*")) {
                  str = Constants.ANSI_YELLOW + strings[x] + Constants.ANSI_RESET;
            }
            if(strings[x].equals("~")) {
                  str = Constants.ANSI_CYAN + strings[x] + Constants.ANSI_RESET;
            }
            return str;
      }

      private static void image() {
            System.out.println(
                    Constants.ANSI_BLUE + "             _____.---------" + Constants.ANSI_RESET + Constants.ANSI_YELLOW + "/\\     \n" + Constants.ANSI_RESET +
                            Constants.ANSI_BLUE + "            <____|._" + Constants.ANSI_RESET + Constants.ANSI_RED + "SeaFight" + Constants.ANSI_RESET + "" + Constants.ANSI_YELLOW + "||\n" + Constants.ANSI_RESET +
                            Constants.ANSI_BLUE + "            <____|.---------" + Constants.ANSI_RESET + Constants.ANSI_YELLOW + "||\n" + Constants.ANSI_RESET +
                            "                        .---''---,\n" +
                            "                         ;..__..'    _...\n" +
                            "                       ,'/  ;" + Constants.ANSI_YELLOW + "|" + Constants.ANSI_RESET + "/..--''    \\\n" +
                            "                     ,'_/.-/':            :\n" +
                            "                _..-'''/  /  |  \\    \\   _|/|\n" +
                            "               \\      /-./_ \\;   \\    \\,;'   \\\n" +
                            "               ,\\    / \\:  `:\\    \\   //    `:`.\n" +
                            "             ,'  \\  /-._;   | :    : ::    ,.   .\n" +
                            "           ,'     ::   /`-._| |    | || ' :  `.`.)\n" +
                            "        _,'       |;._:: |  | |    | `|   :    `'\n" +
                            "      ,'   `.     /   |`-:_ ; |    |  |  : \\\n" +
                            "      `--.   )   /|-._:    :          |   \\ \\\n" +
                            "         /  /   :_|   ;`-._;   __..--';    : :\n" +
                            "        /  (    ;|;-./_  _/.-:'o |   /     ' |\n" +
                            "       /  , \\._/_/_./--''/_|:|___|_,'        |\n" +
                            "      :  /   `'-'--'----'---------'          |\n" +
                            "      | :     " + Constants.ANSI_RED + "O" + Constants.ANSI_RESET + " ._" + Constants.ANSI_RED + "O   O" + Constants.ANSI_RESET + "_. " + Constants.ANSI_RED + "O" + Constants.ANSI_RESET + " ._" + Constants.ANSI_RED + "O   O" + Constants.ANSI_RESET + "_.      ; ;\n" +
                            "      : `.      " + Constants.ANSI_YELLOW + "//    //    //    //  " + Constants.ANSI_RESET + "   ,' /\n" +
                            Constants.ANSI_CYAN + "    ~~~" + Constants.ANSI_RESET + "`.______" + Constants.ANSI_YELLOW + "//" + Constants.ANSI_RESET + "____" + Constants.ANSI_YELLOW + "//" + Constants.ANSI_RESET + "____" + Constants.ANSI_YELLOW + "//" + Constants.ANSI_RESET + "____" + Constants.ANSI_YELLOW + "//" + Constants.ANSI_RESET + "_______,'" + Constants.ANSI_CYAN + "~~~~~~~\n" + Constants.ANSI_RESET +
                            Constants.ANSI_YELLOW + "              //    //" + Constants.ANSI_CYAN + "~ " + Constants.ANSI_RESET + Constants.ANSI_YELLOW + "  //    //\n" +
                            Constants.ANSI_CYAN + "       ~~" + Constants.ANSI_YELLOW + "   _//   _//   _// " + Constants.ANSI_CYAN + "~" + Constants.ANSI_YELLOW + " _//    " + Constants.ANSI_CYAN + " ~\n" + Constants.ANSI_RESET +
                            Constants.ANSI_CYAN + "     ~" + Constants.ANSI_RESET + Constants.ANSI_YELLOW + "     / /   / /   / /   / /  " + Constants.ANSI_CYAN + "~      ~~\n" + Constants.ANSI_RESET +
                            Constants.ANSI_CYAN + "          ~~~   ~~~   ~~~   ~~~" + Constants.ANSI_RESET);
      }
}