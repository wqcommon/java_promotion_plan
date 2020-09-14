package ques1;

/**
 * @author: wenqiang
 * @date: 2020-04-30 15:17
 */
public class CategoryCase {

    public static void main(String[] args) {
        //电脑
        Computer computer = new Computer();
        computer.setCategory("电脑");
        computer.setCpu("intel i7");

        //衣服
        Clothes clothes = new Clothes();
        clothes.setPure(false);
        clothes.setCategory("衣服");

        //食品
        Food food = new Food();
        food.setCategory("食品");
        food.setFormula("醋、油等");

        // 家具
        Furniture furniture = new Furniture();
        furniture.setCategory("家具");
        furniture.setMaterial("红木");

        //------ 输出各种类型的信息

    }
}
