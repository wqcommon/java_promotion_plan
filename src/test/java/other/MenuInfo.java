package other;

import java.util.List;

/**
 * @author: wenqiang
 * @date: 2020-04-29 21:11
 */
public class MenuInfo {

    private MenuNode root;


    class MenuNode{

        private String menuName;

        private String menuUrl;

        private List<MenuNode> children;

    }
}

