package cz.ucl.javase.football;

import java.util.List;

public class FootballApplication {

    public static void main(String[] args) {

        ResultReader resultReader = new ResultReader();
        List<Team> teams = resultReader.readResults("footballResults.txt");

        //TODO sort the team list and print it

    }

}
