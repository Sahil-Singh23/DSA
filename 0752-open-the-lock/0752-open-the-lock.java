class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))return 0;
        
        Set<String> visited = new HashSet<>();

        for(String s: deadends) visited.add(s);

        if(visited.contains("0000"))return -1;
        visited.add("0000");

        Queue<String> q = new LinkedList<>();

        q.offer("0000");

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;

            for(int x=0 ; x<size ; x++){
                String s = q.poll();
                char[] cur = s.toCharArray();
                for(int i =0 ; i<4 ; i++){
                    //for each char try decrement n increment , 
                    char[] increment = cur.clone();
                    increment[i] = (char)((Character.getNumericValue(cur[i])+1)%10+'0');
                    char[] decrement = cur.clone();
                    decrement[i] = (char)((Character.getNumericValue(cur[i])-1+10)%10+'0');
                    String incr = new String(increment);
                    String decr = new String(decrement);
                    //System.out.println(incr);
                    if(target.equals(incr) || target.equals(decr)) return steps;
                    if(!visited.contains(incr)){
                        visited.add(incr);
                        q.offer(incr);
                    }
                    if(!visited.contains(decr)){
                        visited.add(decr);
                        q.offer(decr);
                    }
                }
            }
        }return -1;

    }
}