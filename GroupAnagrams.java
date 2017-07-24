import java.util.*;

/*
* Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */

public class GroupAnagrams {

    public List<List<String>> group(String[] strs) {

        List<List<String>> ret = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
           char[] chars = s.toCharArray();
           Arrays.sort(chars);
           String key = String.valueOf(chars);

           //表示key還沒有存在,先產生empty list之後再加入
           if(map.get(key)==null) {
               map.put(key, new ArrayList<>());
           }
           map.get(key).add(s);

        }
        for(Map.Entry<String, List<String>> entry: map.entrySet())
            ret.add(entry.getValue());

        return ret;
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams sol = new GroupAnagrams();
        System.out.println("the list " + sol.group(strs));

    }

}
