package misc;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/1650545/Rippling-or-SE-or-DSAlgo-Round-orHighest-performing-rating-employee-team
 *
 * Company xyz.com has an organizational structure such that each employee in the company can have at most one manager
 * and may have many subordinates. The company recently conducted their quarterly performance review cycle and each employee has received a performance rating.
 *
 * An example structure is as follows:
 *
 *           A(5)
 *  B(3)                    C(1)
 *
 *                 D(4)             E(10)
 * A is the manager of B and C
 * C is the manager of D and E
 * Performance ratings are mentioned in brackets
 * Now given the employee information of a company, return the employee whose team has the highest performance rating average.
 * A team is defined as a group consisting of an employee and all their subordinates (not just the direct ones).
 * Sample input/output:
 * Input format: [employee name, rating, List]
 * data = [['A', 5, ['B', 'C']],
 * ['B', 3, []], ['C', 2, ['D', 'E']], ['D', 4, []], ['E', 10, []]
 * Output: E
 *
 * Modified version of https://leetcode.com/problems/employee-importance/
 */
class Team {
    String name;
    int rating;
    List<String> teams;

    public Team(String name, int rating, List<String> teams) {
        this.name = name;
        this.rating = rating;
        this.teams = teams;
    }
}
public class EmployeeRating {
    public static void main(String[] args) {
        Team e1= new Team("A",5, Arrays.asList("B", "C"));
        Team e2= new Team("B",3, Collections.emptyList());
        Team e3= new Team("C",1, Arrays.asList("D", "E"));
        Team e4= new Team("D",4, Collections.emptyList());
        Team e5= new Team("E",10,Collections.emptyList());
        List<Team> teamList = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
        EmployeeRating employeeRating= new EmployeeRating();
        employeeRating.getBestTeam(teamList);
    }

    private void getBestTeam(List<Team> teamList) {
        String BT=null;
        int bTeamRanking=Integer.MIN_VALUE;
        Map<String,Integer> map= new HashMap<>();
        for (Team team : teamList) {
            map.put(team.name, team.rating);
        }
        System.out.println(map);
        for (Team team : teamList) {
            List<String> subTeams= team.teams;
            int cr= team.rating;
            int count=1;
            for (String ct:subTeams){
                count++;
                cr+=map.get(ct);
            }
            int temp=cr/count;
            if (temp>bTeamRanking) {
                bTeamRanking = temp;
                BT = team.name;
            }
        }
        System.out.println("Best Team is "+BT+" Ranking is"+bTeamRanking);
    }
}
