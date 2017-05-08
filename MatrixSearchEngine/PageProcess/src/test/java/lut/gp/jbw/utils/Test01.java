package lut.gp.jbw.utils;

import java.util.List;
import java.util.Map;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

/**
 *
 * @author vincent May 7, 2017 1:34:35 PM
 */
public class Test01 {

    @Test
    public void testFile() {
        String source = "中国人名helloand";
        List<Word> words = WordSegmenterUtil.segmenterWithStopWords(source);
        Map<List<Word>, List<Word>> situation = ProcessSearch.bool(words);
        for (List<Word> andWords : situation.keySet()) {
            System.out.print("AND:");
            for (Word w : andWords) {
                System.out.print(w + "\t");
            }
            System.out.print("NOT:");
            for (Word w : situation.get(andWords)) {
                System.out.print(w + "\t");
            }
            System.out.println("");
        }
    }
}
