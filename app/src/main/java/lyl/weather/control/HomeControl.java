package lyl.weather.control;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface HomeControl {

     interface HomePresenter {
        void init();

        void initMenu();

        String[] getTitles();

        void  saveUserinfo();
    }
     interface HomeView {


        void init(String [] titles,boolean isHasmenu);


    }

     interface IHomeModel {

        /**
         * 监听菜单个数
         */
        interface GetMenuListener {
            void has();

            void notHas();
        }

        /**
         * 获取菜单
         *
         * @param getMenuListener
         */
        void getMenu(GetMenuListener getMenuListener);

        /**
         * 获取标题
         *
         * @return
         */
        String[] getTitles();

        /**
         * 获取个人信息
         */
        void saveUserinfo();


        void upDataVersion();
    }
}
