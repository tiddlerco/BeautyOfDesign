package design.create.prototype;

import design.create.prototype.entity.SearchWord;

import java.util.HashMap;
import java.util.List;

/**
 * 先采用浅拷贝的方式创建 newKeywords。
 * 对于需要更新的 SearchWord 对象，
 * 我们再使用深度拷贝的方式创建一份新的对象，替换 newKeywords 中的老对象
 *
 * @Author 喻可
 * @Date 2021/7/12 10:08
 */
public class DemoImprove4 {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // Shallow copy
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyWord())) {
                newKeywords.remove(searchWord.getKeyWord());
            }
            newKeywords.put(searchWord.getKeyWord(), searchWord);
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }
}
