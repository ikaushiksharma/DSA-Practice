class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> fm=new HashMap<>();
        for(char n:s.toCharArray())
            fm.put(n,fm.getOrDefault(n,0)+1);
        PriorityQueue<Character> pq=new PriorityQueue<>((n1,n2)->fm.get(n2)-fm.get(n1));
        for(char c:fm.keySet())
            pq.offer(c);
        StringBuilder sb=new StringBuilder();
        char c;
        while(!pq.isEmpty())
        {
            c=pq.poll();
            for(int i=0;i<fm.get(c);i++)
                sb.append(c);
        }
        return sb.toString();
    }
}