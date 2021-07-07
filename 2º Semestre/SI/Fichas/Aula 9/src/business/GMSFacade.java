/*
 * GMSFacade
 * ruicouto in 10/abr/2017
 */
package business;

import data.GameDAO;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author ruicouto  (IJ project: jfc)
 */
public class GMSFacade {
    public static List<Game> listGames(int pag) {
        List<Game> games = GameDAO.list();
        return games.subList(pag*5,(1+pag)*5);
    }

    /*public static List<Game> listGames(int year) {
        List<Game> games = GameDAO.list().stream()
                .filter(g -> g.getYear() == year)
                .collect(Collectors.toList());
        return games;
    }*/


    public static List<Integer> getYears() {
        List<Integer> games = GameDAO.getYears();
        return games;
    }
}
