package Algo.Regex;

public class BOJ_72410 {
    class Solution {
        public String solution(String new_id) {
            String answer = "";

            new_id = new_id.toLowerCase();

            new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

            new_id = new_id.replaceAll("\\.{2,}", ".");

            if(new_id.startsWith(".")) {
                new_id = new_id.substring(1);
            }

            if(new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length()-1);
            }

            if(new_id.length() == 0) {
                new_id += "a";
            }

            if(new_id.length() >= 16) {
                new_id = new_id.substring(0, 15);

                if(new_id.endsWith(".")) {
                    new_id = new_id.substring(0, new_id.length()-1);
                }
            }

            if(new_id.length() <= 2) {
                String str = new_id.substring(new_id.length()-1, new_id.length());
                while(new_id.length() < 3) {
                    new_id += str;
                }
            }

            return new_id;
        }
    }
}
