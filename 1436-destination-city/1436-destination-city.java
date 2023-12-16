class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> s=new HashSet<>();
        for(List<String> l:paths) s.add(l.get(1));
        for(List<String> l:paths) s.remove(l.get(0));
        return s.iterator().next();
    }
}