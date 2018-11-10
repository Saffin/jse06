package cz.ucl.javase.football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResultReader {

    private static final String[] TEAM_NAMES = {
            "Benátky"
            ,"Benešov"
            ,"Chrudim"
            ,"Dobrovice"
            ,"Domažlice"
            ,"Hořovicko"
            ,"Jirny"
            ,"Králův Dvůr"
            ,"Litoměřicko"
            ,"Mas Táborsko"
            ,"Olympia"
            ,"Písek"
            ,"Převýšov"
            ,"Štěchovice"
            ,"Tachov"
            ,"Vltavín"
            ,"Vyšehrad"
            ,"Zápy"
    };

    public List<Team> readResults(String fileName) {
        List<Team> teams = new ArrayList<>(TEAM_NAMES.length);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                this.getClass().getClassLoader().getResourceAsStream("footballResults.txt")));) {
            int indexOfTeams = 0;

            String inputLine;
            while ((inputLine = br.readLine()) != null) {

                // TODO implement the method createTeam
               // Team team = createTeam(TEAM_NAMES[indexOfTeams], inputLine);
               // teams.add(team);

                indexOfTeams++;
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return teams;

    }

}
