package Schedule;

import java.util.Arrays;

/**
 * @author McRae Massey
 * @version 1.0.0
 *
 * Commands contains the methods for storing and updating information about the cities we service
 * and to query its data store for pathing information to determine routes between
 * those cities.
 * Input commands - ADD and Query
 * Output commands - Edge, Result, Path, Malformed
 */
public class Commands {

    /**
     * ADD COMMAND will add or update the records stored by the system and will
     * output an EDGE COMMAND to stdout to report a successful update.
     * @param origin - the name of originating city (string)
     * @param destination - the name of the destination city (string)
     * @param mileage - the mileage for the leg (float)
     * @param duration - the duration of the flight (float)
     */
    public void Add(String origin, String destination, float mileage, float duration) {
        Edge(origin, destination, mileage, duration);
    }

    /**
     * QUERY COMMAND will search all of the stored records to determine all paths
     * from the originating city to the destination city. If at least one path from
     * the originating city to the destination city exists a RESULT COMMAND will
     * be written to stdout followed by PATH COMMANDS, in ascending order of cost,
     * for each possible route.
     *
     * If at least one path from the originating city to the destination city does
     * not exist the QUERY will be considered malformed.
     * @param origin - the name of originating city (string)
     * @param destination - the name of the destination city (string)
     */
    public void Query(String origin, String destination) {
        //TODO: implement depth-first traversal of a graph
        /**
         * 1) The idea is to do Depth First Traversal of given directed graph.
         * 2) Start the DFS traversal from origin.
         * 3) Keep storing the visited vertices in an array or HashMap say ‘path[]’.
         * 4) If the destination vertex is reached, print contents of path[].
         * 5) The important thing is to mark current vertices in the path[] as visited also so that the traversal
         *    doesn't go in a cycle.
         */

        Result(origin, destination);
        /**
         * A path is made up of "legs" from an originating city to a destination
         * city. The cost of an individual leg is defined as the mileage of the leg
         * multiplied by 15 added to the flight time multiplied by 30 rounded to the
         * nearest hundredth. The cost of a path is the sum of the cost of each "leg"
         * in the path.
         */
        String nextCity = "";
        float cost = 0;
        Path(cost, origin, destination, nextCity);
    }

    /**
     * For each successful ADD COMMAND and corresponding EDGE COMMAND is
     * written to stdout.
     * @param origin - the name of originating city (string)
     * @param destination - the name of the destination city (string)
     * @param mileage - the mileage for the leg (float)
     * @param duration - the duration of the flight (float)
     */
    public String Edge(String origin, String destination, float mileage, float duration) {
        String edgeOutput = "EDGE " + origin + ", " + destination +  ", " + mileage + ", " + duration;
        System.out.print(edgeOutput);
        return edgeOutput;
    }

    /**
     * For each successful QUERY COMMAND and corresponding RESULT COMMAND is
     * written to stdout.
     * @param origin - the name of originating city (string)
     * @param destination - the name of the destination city (string)
     */
    public String Result(String origin, String destination) {
        String result = "RESULT " + origin + ", " + destination;
        System.out.print(result);
        return result;
    }

    /**
     * For each successful QUERY COMMAND a corresponding PATH COMMAND for all
     * available paths should be written to stdout in ascending order by the
     * cost of the path.
     * @param cost - the cost of the path (float)
     * @param origin - the name of originating city (string)
     * @param destination - the name of the destination city (string)
     * @param nextCity - the name of the next city in the path (string) (varargs)
     */
    public String Path(float cost, String origin, String destination, String... nextCity) {
        String path = "PATH " + cost + ", " + origin + ", " + Arrays.toString(nextCity) + ", " + destination;
        return path;
    }

    /**
     * An error should be generated for all malformed input COMMANDs. A command is
     * considered malformed if the name of the command is not listed in the INPUT
     * section, the COMMAND's parameters do not match the expected parameters, or the
     * COMMAND is otherwise considered malformed (see QUERY). All errors should write a
     * MALFORMED command to stderr.
     * @param command - the name of the COMMAND that caused the error (string)
     * @param params - the parameters of the command that caused the error (string) (varargs)
     */
    public String Malformed(String command, String... params) {
        String malformed = "MALFORMED " + command + Arrays.toString(params);
        System.out.println(malformed);
        return malformed;
    }
}
