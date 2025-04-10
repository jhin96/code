package offer;


import java.util.Stack;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“nowcoder. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a nowcoder.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=23287&sourceUrl=
 *
 */
public class offer73_翻转单词序列 {

    public String ReverseSentence(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] split = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            stack.push(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }

}
