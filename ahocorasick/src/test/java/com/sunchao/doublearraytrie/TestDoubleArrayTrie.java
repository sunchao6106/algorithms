package com.sunchao.doublearraytrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.*;
public class TestDoubleArrayTrie extends TestCase {
	
	private DoubleArrayTrie dat = new DoubleArrayTrie();
	
	public void testDoubleArrayTrieReadAndWrite() throws IOException{
		
		String fileName ="C:\\java\\java\\dict\\word";
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        List<String> words = new ArrayList<String>();
        Set<Character> charset = new HashSet<Character>();
        while ((line = reader.readLine()) != null)
        {
            words.add(line);
            // 制作一份码表debug
            for (char c : line.toCharArray())
            {
                charset.add(c);
            }
        }
        reader.close();
        // 这个字典如果要加入新词必须按字典序，参考下面的代码
//        Collections.sort(words);
//        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/sorted.dic", false));
//        for (String w : words)
//        {
//            writer.write(w);
//            writer.newLine();
//        }
        System.out.println("字典词条：" + words.size());
 
        {
            String infoCharsetValue = "";
            String infoCharsetCode = "";
            for (Character c : charset)
            {
                infoCharsetValue += c.charValue() + "    ";
                infoCharsetCode += (int)c.charValue() + " ";
            }
            infoCharsetValue += '\n';
            infoCharsetCode += '\n';
            System.out.print(infoCharsetValue);
            System.out.print(infoCharsetCode);
        }
 
        DoubleArrayTrie dat = new DoubleArrayTrie();
        System.out.println("是否错误: " + dat.build(words));
        System.out.println(dat);
      //  int index1 = dat.exactMatchSearch("hehe");
     //   System.out.println(words.get(index1));
        List<Integer> integerList = dat.commonPrefixSearch("一举一动");
        for (int index : integerList)
        {
            System.out.println(words.get(index));
        }
	}
   
	
	
}
