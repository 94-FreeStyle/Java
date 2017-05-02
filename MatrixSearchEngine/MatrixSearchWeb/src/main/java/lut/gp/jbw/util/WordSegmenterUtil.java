package lut.gp.jbw.util;

import java.util.List;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent Apr 2, 2017 6:33:46 PM
 */
public class WordSegmenterUtil {

    public static List<Word> segmenter(String str) {
        return WordSegmenter.segWithStopWords(str);
    }
}
