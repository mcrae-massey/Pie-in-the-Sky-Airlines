package Schedule;

import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

/**
 * @author McRae Massey
 * @version 1.0.0
 *
 * Route finder that serves as a canonical source of all routes. This software
 * has two operations: to store and update information about the cities we service
 * and to query its data store for pathing information to determine routes between
 * those cities.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //FileReader input = new FileReader("input.txt");
        //FileReader output = new FileReader("output.txt");
        //FileReader error = new FileReader("error.txt");

        System.out.print("Please enter a command: ");
        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.next();
        String[] command = commandLine.split("\\s+");

        /**
         * valid input commands with usage
         * ADD origin (string), destination (string), mileage (float), duration (float)
         * QUERY origin (string), destination (string)
         */

        switch (command[0]) {
            case "ADD":
                new Commands().Add(command[1], command[2], Float.parseFloat(command[3]), Float.parseFloat(command[4]));
                break;
            case "QUERY":
                new Commands().Query(command[1], command[2]);
                break;
            default:
                //add multi params for second param
                new Commands().Malformed(command[0], command[2]);
        }
    }
}
