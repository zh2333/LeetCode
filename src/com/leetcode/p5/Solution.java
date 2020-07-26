package com.leetcode.p5;

class Solution {
	
	public static void main(String[] args) {
		String s = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"
; 
		System.out.println(longestPalindrome(s));

	}
    public static String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        char[] rev;
        char[] maxString={};
        if(c.length < 2){
            return s;
        }
        for(int i = 0;i<c.length;i++){
            for(int j = i;j<c.length;j++){
                rev = reverse(s.substring(i,j+1).toCharArray());
                if(String.valueOf(rev).equals(s.substring(i,j+1))){
                    if(String.valueOf(rev).length() > String.valueOf(maxString).length()){
                        maxString = rev;
                    }
                }
            }
        }
        return String.valueOf(maxString);
    }

    public static char[] reverse(char[] c){
        char temp;
        int len = c.length;
        for(int i = 0;i < c.length / 2;i++){
            temp = c[i];
            c[i] = c[len - i - 1];
            c[len - i - 1] = temp;
        }
        return c;
    }
}