import java.util.*;

public class Solution {
    public int[] smallestSufficientTeam(String[] req, List<List<String>> people) {
        int n = req.length;
        Map<String,Integer> idx = new HashMap<>();
        for(int i=0;i<n;i++) idx.put(req[i],i);

        Map<Integer,List<Integer>> dp = new HashMap<>();
        dp.put(0,new ArrayList<>());

        for(int i=0;i<people.size();i++){
            int mask=0;
            for(String s:people.get(i)) mask |= 1<<idx.get(s);

            Map<Integer,List<Integer>> copy = new HashMap<>(dp);
            for(int m:copy.keySet()){
                int comb = m|mask;
                if(!dp.containsKey(comb) || dp.get(comb).size()>copy.get(m).size()+1){
                    List<Integer> team = new ArrayList<>(copy.get(m));
                    team.add(i);
                    dp.put(comb,team);
                }
            }
        }

        List<Integer> res = dp.get((1<<n)-1);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
