package lut.gp.jbw.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent Apr 2, 2017 6:33:46 PM
 */
public class WordSegmenterUtil {

    public static List<Word> segmenter(String str) {
        return WordSegmenter.segWithStopWords(str);//去掉停止词
    }

    public static Map<String, Integer> wordCountToMap(List<Word> wl) {
        Map<String, Integer> wc = new HashMap<>();
        wl.forEach((Word word) -> {
            if (!wc.containsKey(word.getText())) {
                wc.put(word.getText(), 0);
            }
            wc.put(word.getText(), wc.get(word.getText()) + 1);
        });
        return wc;
    }
}
