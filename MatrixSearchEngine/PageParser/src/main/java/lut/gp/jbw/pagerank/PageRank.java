package lut.gp.jbw.pagerank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vincent Apr 29, 2017 4:26:20 PM
 */
public class PageRank {

    private final static double DAMPINGfFACTOR = 0.85; //阻尼系数,即α
    private final static int MAXITERATIONS = 100; //最大迭代次数
    private final static double MINDELTA = 0.00001; //确定迭代是否结束的参数,即ϵ
    private static Map<String, Set<String>> graph;

    /**
     *
     * @param data (url,links)
     * @return （url, pagerank）
     */
    public static Map<String, Double> pageRank(Map<String, Set<String>> data) {
        graph = data;
        Map<String, Set<String>> incidents = incidents(data);
        Set<String> nodes = graph.keySet();
        Map<String, Double> res = new HashMap<>();
        //先将图中没有出链的节点改为对所有节点都有出链
        graph.keySet().stream().filter((url) -> (graph.get(url).isEmpty())).forEachOrdered((url) -> {
            graph.put(url, nodes);
        });
        int graphSize = nodes.size();
        if (graphSize == 0) {
            System.exit(0);
        }

        //给每个页面赋予初始PageRank值
        nodes.forEach((node) -> {
            res.put(node, 1.0 / graphSize);
        });

        double dampingValue = (1.0 - DAMPINGfFACTOR) / graphSize;
        for (int i = 0; i < MAXITERATIONS; i++) {
            double change = 0;
            for (String node : nodes) {
                double rank = 0;
                rank = incidents.get(node).stream() //遍历所有“入射”的页面
                        .map((in) -> DAMPINGfFACTOR * (res.get(in) / graph.get(in).size()))
                        .reduce(rank, (accumulator, _item) -> accumulator + _item);
                rank += dampingValue;
                change += Math.abs(res.get(node) - rank);
                res.put(node, rank);
            }
            if (change < MINDELTA) {
                break;
            }
        }
        return res;
    }

    /**
     * 计算每一个页面的入链集合
     *
     * @param data
     * @return
     */
    private static Map<String, Set<String>> incidents(Map<String, Set<String>> data) {
        Map<String, Set<String>> res = new HashMap<>();
        data.keySet().forEach((url) -> {
            Set<String> links = data.get(url);
            links.stream().map((link) -> {
                if (!res.containsKey(link)) {
                    res.put(link, new HashSet<>());
                }
                return link;
            }).forEachOrdered((link) -> {
                res.get(link).add(url);
            });
        });
        return res;
    }
}
