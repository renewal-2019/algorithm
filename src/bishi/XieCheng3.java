package bishi;

/**
 * 题目描述：
 * ElasticSearch 是常用的开源搜索引擎，支持fuzzyQuery 给搜索带来很大便利。
 * 其简单原理如下，surprize有拼写错误，把z换成s后得到  surprise，即纠正一个字母，
 * 就可以匹配正确的单词。
 * 同样，把surprize的z替换成s，然后在末尾加个d，可以得到surprised。
 * 给定字典[ "surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"]
 * 为正确单词
 * 编程实现单词纠正，判断输入的单词能否在2(包含)次纠正操作内得到字典中的单词。
 * 纠正操作是以下三种，
 * 1：替换字符串中的一个字母;
 * 2：删除字符串中的一个字母;
 * 3：在字符串中增加一个字母。
 */
public class XieCheng3 {
}
