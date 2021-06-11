package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/20
 * Time:下午7:01
 *
 *
 * 保证文件名唯一
 *
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/making-file-names-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode1487 {

    public String[] getFolderNames(String[] names) {

        Map<String, Integer> map = new HashMap<>();

        String[] result = new String[names.length];

        for(int i=0; i<names.length; i++) {

            String name = names[i];

            if(!map.containsKey(name)) {
                result[i] = name;
                map.put(name, null);
            }
            else {
                if(null == map.get(name)) {
                    String temp = name+"("+1+")";
                    if(!map.containsKey(temp)) {
                        result[i] = temp;
                        map.put(name, 1);
                    }
                    else {
                        int newIndex = this.process(map, name, 1);
                        temp = name+"("+newIndex+")";
                        result[i] = temp;
                        map.put(temp, newIndex);
                    }
                }
                else {
                    int newIndex = this.process(map, name, (map.get(name) == null ? 0 :
                            map.get(name)) + 1);
                    String temp = name+"("+newIndex+")";
                    result[i] = temp;
                    //map.put(temp, newIndex);
                }
            }
        }

        return result;
    }

    private int process(Map<String, Integer> map, String name, int index) {
        if(!map.containsKey(name+"("+index+")")) {
            return index;
        }
        else {
            return this.process(map, name, ++index);
        }
    }

    public static void main(String[] args) {
        String[] s = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        System.out.println(new LeetCode1487().getFolderNames(s));
    }
}
