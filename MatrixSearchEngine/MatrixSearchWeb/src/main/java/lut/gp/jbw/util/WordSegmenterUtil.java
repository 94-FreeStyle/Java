package lut.gp.jbw.util;

import java.util.ArrayList;
import java.util.List;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent Apr 2, 2017 6:33:46 PM
 */
public class WordSegmenterUtil {

    public static List<Word> segmenter(String str) {
        return WordSegmenter.seg(str);
    }

    public static List<String> segmenterWithStopWords(String str) {
        List<String> res = new ArrayList<>();
        List<Word> ws = WordSegmenter.segWithStopWords(str);
        for (Word w : ws) {
            res.add(w.getText());
        }
        return res;
    }
}
