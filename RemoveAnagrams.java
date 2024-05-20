class RemoveAnagrams {
    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        Map<Character,Integer> temp = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            if(temp.containsKey(ch)){
                temp.put(ch,temp.get(ch)+1);
            }else{
                temp.put(ch,1);
            }
        }

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(temp.containsKey(ch)){
                if(temp.get(ch)>0){
                    temp.put(ch,temp.get(ch)-1);
                }
            }else{
                return false;
            }
        }

        for(char ch : temp.keySet()){
            if(temp.get(ch) != 0){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> out = new ArrayList<>();
        out.add(words[0]);
        for(int i=1; i<words.length; i++){
            boolean check = isAnagram(words[i], words[i-1]);
            if(!check){
                out.add(words[i]);
            }
        }
        return out;
    }
}
