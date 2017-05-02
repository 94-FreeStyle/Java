/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.util;

import java.util.List;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent
 */
public class WordSegmenterUtilTest {

    /**
     * Test of segmenter method, of class WordSegmenterUtil.
     */
    public void testSegmenter() {
        System.out.println("segmenter");
        String str = "你是谁，我叫贾博文，你看过一本书叫做天才在左，疯子在右吗？";
        List<Word> result = WordSegmenterUtil.segmenter(str);
        for(Word word:result){
            System.out.println(word.getText());
        }
    }   
}
