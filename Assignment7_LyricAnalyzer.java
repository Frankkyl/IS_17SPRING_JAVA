/**
 * Created by kysft on 3/13/17.
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class LyricAnalyzer {
    private String lyricWord;
    private int wordPosition;
    private HashMap<String, ArrayList<Integer>> map;

    public String getLyricWord() {
        return lyricWord;
    }

    public void setLyricWord(String lyricWord) {
        this.lyricWord = lyricWord;
    }

    public int getWordPosition() {
        return wordPosition;
    }

    public void setWordPosition(int wordPosition) {
        this.wordPosition = wordPosition;
    }

    public HashMap<String, ArrayList<Integer>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, ArrayList<Integer>> map) {
        this.map = map;
    }

    public LyricAnalyzer(HashMap<String, ArrayList<Integer>> map, String lyricWord, int wordPosition) {
        this.map = map;
        this.lyricWord = lyricWord;
        this.wordPosition = wordPosition;
    }

    public static void add(HashMap<String, ArrayList<Integer>> map, String lyricWord, int wordPosition) {//Q: why it's all static?
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (map.containsKey(lyricWord)) {
            al = map.get(lyricWord);//Q:"al=" is must, if we dont, no varient to save the former data
            al.add(wordPosition);

        } else {
            al.add(wordPosition);
            map.put(lyricWord, al);
        }
    }

    public static void displayWords(HashMap<String, ArrayList<Integer>> map) {

        //transfer hashmap to treemap, so we have auto sort
        Map<String, ArrayList<Integer>> map2 = new TreeMap<>();//Q: is this good?http://stackoverflow.com/questions/7860822/sorting-hashmap-based-on-keys
        map2.putAll(map);
        //output one by one

        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            ArrayList al = new ArrayList();
            //System.out.println(map.get(key));
            for (int i = 0; i < map2.get(key).size(); i++) {

                al.add(map2.get(key).get(i));

            }
            System.out.println(key + ": " + al.toString().replace("[","").replace("]",""));
        }
    }

    public static void displayLyrics(HashMap<String, ArrayList<Integer>> map) {
        //System.out.println("check map input: " + map);
        HashMap hm = new HashMap();
        ArrayList al = new ArrayList();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            //System.out.println(map.get(key));
            for (int i = 0; i < map.get(key).size(); i++) {
                //System.out.println(map.get(key).get(i));
                //System.out.println(key);
                hm.put(map.get(key).get(i), key);
                al.add(map.get(key).get(i));
            }
        }
        //System.out.println(hm);//Q:why this output looks sorted...{1=WHAT, 2=HAVE, -3=I, 4=WHAT, 5=HAVE, -6=I, 7=WHAT, 8=HAVE, 9=I, 10=DONE, 11=TO, 12=DESERVE, -13=THIS}
                                //FL:Yes, looks sorted for this case, but no guaranteed
        //System.out.println(al);
        //sort al
        int maxPosition = al.size();
        for (int m=1;m<maxPosition+1;m++){
            if(hm.containsKey(m)){
                System.out.print(hm.get(m) + " ");
            }else{
                System.out.print(hm.get((-1)*m) + "\n");
            }
        }

        /*Map<Integer, String> hm2 = new TreeMap<>();
        hm2.putAll(hm);*/
        //System.out.println(hm2);
       /* ArrayList newal=new ArrayList();
        for(int m=0;m<al.size();m++){
            if(Math.abs((int)al.get(m))>(Math.abs((int)al.get(m+1)))){
                newal.add(al.get(m));
            }else{
                newal.add(al.get(m+1));
            }
        }*/
        //System.out.println(newal);
        /*for (int j = 0; j < al.size(); j++) {
            System.out.print(hm.get(al.get(j)));

            if (j > 0) {
                System.out.print(" ");
            } else {
                System.out.print("\n");
            }
        }*/
    }

    public static int count(HashMap<String, ArrayList<Integer>> map) {
        return map.size();
    }

    public static String mostFrequentWord(HashMap<String, ArrayList<Integer>> map) {
        return "mostF";
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        int position = 1;// word position index start from 1

        //path,Q:this is the common way we pick up the data from local disks?
        String pathname = "/Users/kysft/Documents/workspace/kyfstll/Assignment7/test/test1.txt";// files path for Mac: "/Users/kysft/Documents/"

        File f = new File(pathname);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = "";
        while (true) {
            line = br.readLine();
            if (line == null || line.length() == 0) {
                break;
            }
            String[] arr = line.trim().split("\\s+");// to avoid more blank in the file
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1) {
                    add(map, arr[i].toUpperCase(), position++);
                    //System.out.println(map);
                } else {
                    add(map, arr[i].toUpperCase(), (-1) * position);
                    position++;
                    //System.out.println(map);
                }
            }
        }
        br.close();

        displayLyrics(map);
        System.out.println();
        displayWords(map);
        System.out.println();
        System.out.println("The number of unique words in the lyric is: " + count(map));
        System.out.println();
        System.out.println("Most frequent word: " + mostFrequentWord(map));
    }
}
